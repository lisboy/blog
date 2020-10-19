package lisboyblog.controller;

import lisboyblog.pojo.Blog;
import lisboyblog.pojo.Comment;
import lisboyblog.pojo.Lable;
import lisboyblog.pojo.Photo;
import lisboyblog.service.CommentService;
import lisboyblog.service.PhotoService;
import lisboyblog.service.admin.BlogService;
import lisboyblog.service.admin.LableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author FAN BOY
 * @version 1.0
 * @date 2020/8/16 19:54
 */
@Controller
public class ReadController {

    @Autowired
    BlogService blogService;

    @Autowired
    LableService lableService;

    @Autowired
    CommentService commentService;

    @Autowired
    PhotoService photoService;

    @RequestMapping("toreadblog")
    public String toreadblog(Model model, Long id, @RequestParam(name = "mess",defaultValue ="")String mess){
        Blog oneBlog = blogService.findOneBlog(id);
        model.addAttribute("oneblog",oneBlog);
        //热门博文
        List<Blog> allBlog = blogService.findAllBlog();
        model.addAttribute("hostblog",allBlog);
        //评论
        List<Comment> comments = commentService.findAll(id);
        model.addAttribute("comments",comments);
        //标签
        List<Lable> lables = lableService.findAll();
        model.addAttribute("lable",lables);
        if (mess!=""){
            model.addAttribute("mess",mess);
        }
        return "readblog";
    }
    @RequestMapping("addcomment")
    public String rigth(Model model,HttpServletRequest servletRequest, String email){
        String name = servletRequest.getParameter("name");
        String content = servletRequest.getParameter("content");
        String blogid = servletRequest.getParameter("blogid");
        long blogID = Long.parseLong(blogid);
        commentService.addcomment(blogID,name,email,content);
        return "redirect:toreadblog?id="+blogID;
    }
}
