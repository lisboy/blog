package lisboyblog.controller.admin;

import lisboyblog.pojo.Furl;
import lisboyblog.service.admin.FurlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author FAN BOY
 * @version 1.0
 * @date 2020/8/17 9:59
 */
@Controller
@RequestMapping("admin")
public class FurlController {

    @Autowired
    FurlService furlService;

    @RequestMapping("upfile")
    public String friend(Model model){
        List<Furl> allFurl = furlService.findAllFurl();
        model.addAttribute("url",allFurl);
        return "admin/upfile";
    }

    @RequestMapping("addfurl")
    public String addfurl(@RequestParam(name = "url")String url,
                          @RequestParam(name = "pwd",required = false)String pwd,
                          @RequestParam(name = "description")String description){
        furlService.addFurl(description,url, pwd);
        return "redirect:upfile";
    }
    @RequestMapping("deleteurl")
    public String addfurl(@RequestParam(name = "id")Long id){
        furlService.deletdFurl(id);
        return "redirect:upfile";
    }
}
