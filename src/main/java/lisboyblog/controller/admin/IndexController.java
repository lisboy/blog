package lisboyblog.controller.admin;

import lisboyblog.pojo.Pending;
import lisboyblog.service.admin.PendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author FAN BOY
 * @version 1.0
 * @date 2020/8/15 15:19
 */
@Controller
@RequestMapping("admin")
public class IndexController {
    @Autowired
    PendingService pendingService;

    @RequestMapping({"index","","/"})
    public String Index(Model model){
        List<Pending> all = pendingService.findAll();
        model.addAttribute("pending",all);
        return "admin/adminindex";
    }
    @RequestMapping("deletdPend")
    public String deletdPend(Long id){
        pendingService.deletdPend(id);
        return "redirect:index";
    }

}
