package lisboyblog.controller.admin;

import com.github.pagehelper.PageInfo;
import lisboyblog.pojo.Blog;
import lisboyblog.pojo.Log;
import lisboyblog.service.admin.LogService;
import lisboyblog.util.OpenLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author FAN BOY
 * @version 1.0
 * @date 2020/8/16 13:45
 */
@Controller
@RequestMapping("admin")
public class LogController {
    @Autowired
    LogService logService;


    @GetMapping("catlog")
    public String adminblog(Model model,
                            @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        if (pageNum <= 0) {
            pageNum = 1;
        }
        List<Log> all = logService.findAll(pageNum, pageSize);
        PageInfo<Log> pageInfo = new PageInfo(all);
        int page[] = new int[pageInfo.getPages()];
        for (int i = 0; i < pageInfo.getPages(); i++) {
            page[i] = i;
        }

        String couts = "总共" + pageInfo.getPages() + " 页,共" + pageInfo.getTotal() + " 条数据。 每页";
        model.addAttribute("page", page);
        model.addAttribute("cout", couts);
        model.addAttribute("log", pageInfo);
        return "admin/log";
    }
    @GetMapping("truncatelog")
    public String truncatelog(){
        logService.truncate();
        return "redirect:catlog";
    }
}
