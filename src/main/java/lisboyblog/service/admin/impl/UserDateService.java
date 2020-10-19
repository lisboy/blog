package lisboyblog.service.admin.impl;


import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author FAN BOY
 * @version 1.0
 * @date 2020/7/20 14:22
 */
@Service
public class UserDateService implements UserDetailsService {
    /**
     * 后台管理员账号密码，这里写死了
     * @param s
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return new User("root", "94267364wzp",new ArrayList());
    }
}
