package lisboyblog.controller.admin;

import lisboyblog.pojo.Lable;
import lisboyblog.service.admin.LableService;
import lisboyblog.util.OpenLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author FAN BOY
 * @version 1.0
 * @date 2020/8/15 21:12
 */
@Controller
@RequestMapping("admin")
public class LableController {

    @Autowired
    LableService lableService;

    @RequestMapping(value = "catlable",method = RequestMethod.GET)
    public String catlable(Model model){
        List<Lable> all = lableService.findAll();
        model.addAttribute("lable",all);
        return "admin/lable";
    }

    @RequestMapping(value = "addlable",method = RequestMethod.GET)
    @OpenLog(operModul = "addlable",operDesc = "添加分类",operType ="GET" )
    public String addlable(@RequestParam(name = "lable") String lable){
        lableService.addlable(lable);
        return "redirect:catlable";
    }

    @RequestMapping(value = "deletelable",method = RequestMethod.GET)
    @OpenLog(operModul = "delelable",operDesc = "删除分类",operType = "GET")
    public String delelable(Long id){
       lableService.deletelable(id);
        return "redirect:catlable";
    }
}
