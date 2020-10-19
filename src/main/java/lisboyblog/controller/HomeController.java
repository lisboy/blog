package lisboyblog.controller;

import com.github.pagehelper.PageInfo;
import lisboyblog.mapper.PendingMapper;
import lisboyblog.pojo.*;
import lisboyblog.service.PhotoService;
import lisboyblog.service.admin.*;
import lisboyblog.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.*;

/**
 * @author FAN BOY
 * @version 1.0
 * @date 2020/8/16 18:09
 */
@Controller
public class HomeController {

    @Autowired
    BlogService blogService;

    @Autowired
    LableService lableService;

    @Autowired
    FurlService furlService;

    @Autowired
    FriendService friendService;

    @Autowired
    PhotoService photoService;

    @Autowired
    PendingService pendingService;
    @Autowired
    RedisUtil redisUtil;
    @RequestMapping({"/","index",""})
    public String index(){
        return "index";
    }
    @RequestMapping("pending")
    public String pending(Pending pending){
        pendingService.addPending(pending);
        return "redirect:link";
    }
    @RequestMapping("home")
    public String home(Model model,
                               @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                               @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize){
        List<Blog> allBlog = blogService.findAllBlog(pageNum, pageSize);
        List<Blog> all = blogService.findAllBlog(pageNum, pageSize);
        PageInfo<Blog> pageInfo = new PageInfo(all);
        int page[] = new int[pageInfo.getPages()];
        for (int i = 0; i < pageInfo.getPages(); i++) {
            page[i] = i;
        }
        model.addAttribute("page", page);
        model.addAttribute("blog", pageInfo);

        //侧边
        List<Blog> hostblog = blogService.findAllBlog();
        model.addAttribute("hostblog",hostblog);
        //标签
        List<Lable> lables = lableService.findAll();
        model.addAttribute("lable",lables);
        return "home";
    }

    @RequestMapping("catcearch")
    public String catsearch(Model model,
                        @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                        @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize,
                            String find){

        List<Blog> allBlog = blogService.findbloglike(pageNum, pageSize,find);

        PageInfo<Blog> pageInfo = new PageInfo(allBlog);
        int page[] = new int[pageInfo.getPages()];
        for (int i = 0; i < pageInfo.getPages(); i++) {
            page[i] = i;
        }
        int couts=page.length;
        model.addAttribute("page", page);
        model.addAttribute("cout", couts);
        model.addAttribute("blog", pageInfo);
        model.addAttribute("find", find);

        //侧边
        List<Blog> hostblog = blogService.findAllBlog();
        model.addAttribute("hostblog",hostblog);
        //标签
        List<Lable> lables = lableService.findAll();
        model.addAttribute("lable",lables);
        return "search";
    }
    @RequestMapping("toupfile")
    public String toupfile(Model model){

        List<Furl> allFurl = furlService.findAllFurl();
        model.addAttribute("furl",allFurl);


        //侧边
        List<Blog> hostblog = blogService.findAllBlog();
        model.addAttribute("hostblog",hostblog);
        //标签
        List<Lable> lables = lableService.findAll();
        model.addAttribute("lable",lables);
        return "upfile";
    }
    @RequestMapping("tomessage")
    public String tomessage(Model model){

        List<Furl> allFurl = furlService.findAllFurl();
        model.addAttribute("furl",allFurl);


        //侧边
        List<Blog> hostblog = blogService.findAllBlog();
        model.addAttribute("hostblog",hostblog);
        //标签
        List<Lable> lables = lableService.findAll();
        model.addAttribute("lable",lables);
        return "message";
    }
    @RequestMapping("toabout")
    public String toaboud(Model model){

        //侧边
        List<Blog> hostblog = blogService.findAllBlog();
        model.addAttribute("hostblog",hostblog);
        //标签
        List<Lable> lables = lableService.findAll();
        model.addAttribute("lable",lables);
        return "about";
    }

    @RequestMapping("link")
    public String link(Model model){
        List<Friend> allFriend = friendService.findAllFriend();
        model.addAttribute("friends",allFriend);
        return "link";
    }
    @RequestMapping("photo")
    public String photo(Model model){
        List<Photo> photos = photoService.findAll();
        model.addAttribute("photo", photos);
        return "photo";
    }
    @RequestMapping("catarchive")
    public String catarchive(Model model) throws ParseException {

        List<Blog> blogList = blogService.findAllBlog();
        model.addAttribute("blogList",blogList);

        //侧边
        List<Blog> hostblog = blogService.findAllBlog();
        model.addAttribute("hostblog",hostblog);
        //标签
        List<Lable> lables = lableService.findAll();
        model.addAttribute("lable",lables);
        return "archive";
    }
}
