package lisboyblog.config;


import lisboyblog.service.admin.impl.UserDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 * @author FAN BOY
 * @version 1.0
 * @date 2020/6/26 14:43
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{


    @Autowired
    UserDateService userDateService;
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/admin/**").
                    authorizeRequests()
                    .anyRequest()
                    .authenticated();
            //以下是自定义login页面以及设置登出界面
            http.formLogin()
                    .loginPage("/admin/tologin")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .loginProcessingUrl("/admin/login")
                    .successForwardUrl("/admin/")
                    .failureForwardUrl("/admin/tologin?error=true").permitAll()

                    .and()
                    .logout()
                    .logoutUrl("/admin/logou")
                    .logoutSuccessUrl("/admin/tologin")
                    .invalidateHttpSession(true)
                    .deleteCookies("remove").and().csrf().disable();

            http.rememberMe();
            http.headers().cacheControl();
        }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDateService);
        super.configure(auth);
    }
    @Bean
    NoOpPasswordEncoder noOpPasswordEncoder(){
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}



