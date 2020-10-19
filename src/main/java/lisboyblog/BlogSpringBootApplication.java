package lisboyblog;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author FAN BOY
 * @version 1.0
 * @date 2020/8/30 21:48
 */
public class BlogSpringBootApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(LisboyblogApplication.class);//注意  ：这个类必须是启动类的名称
    }
}
