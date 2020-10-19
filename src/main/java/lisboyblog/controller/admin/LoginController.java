package lisboyblog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author FAN BOY
 * @version 1.0
 * @date 2020/8/15 15:12
 */
@Controller
@RequestMapping("admin")
public class LoginController {

    @RequestMapping(value = "tologin",method = RequestMethod.GET)
    public String tologin(){
        return "admin/login";
    }

}
