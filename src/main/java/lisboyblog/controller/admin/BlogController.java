package lisboyblog.controller.admin;

import com.github.pagehelper.PageInfo;
import lisboyblog.pojo.Blog;
import lisboyblog.pojo.Lable;
import lisboyblog.service.admin.BlogService;
import lisboyblog.service.admin.LableService;
import lisboyblog.util.OpenLog;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * @author FAN BOY
 * @version 1.0
 * @date 2020/8/15 19:02
 */
@Controller
@RequestMapping("admin")
public class BlogController {

    @Autowired
    BlogService blogService;

    @Autowired
    LableService lableService;
    @RequestMapping(value = "toaddblog",method = RequestMethod.GET)
    public String toaddblog(Model model) throws FileNotFoundException {
        List<Lable> lables = lableService.findAll();
        model.addAttribute("lable",lables);
        return "admin/addblog";
    }

    @RequestMapping(value = "selectblog",method = RequestMethod.GET)
    public String selectblog(Model model,Long id){
        Blog oneBlog = blogService.findOneBlog(id);
        List<Lable> lables = lableService.findAll();
        model.addAttribute("lable",lables);
        model.addAttribute("myblog",oneBlog);
        return "admin/blogedit";
    }

    @PostMapping("updateblog")
    @OpenLog(operModul = "updatemyblog",operDesc = "修改博文",operType = "GET")
    public String updatemyblog( Model model,
                                @RequestParam(name="id") Long id,
                                @RequestParam(name="recommend") String recommend,
                                @RequestParam(name="name") String name,
                                @RequestParam(name="text") String text,
                                @RequestParam(name="category") String category,
                                @RequestParam(name="title") String title,
                                @RequestParam(name="likes") Long likes,
                                @RequestParam(name="views") Long views,
                                @RequestParam(name="imgs") String imgs,
                                @RequestParam(name="imgs1") MultipartFile imgs1) throws IOException {
        Blog blog=new Blog(id,imgs,name,title,category,text,likes,views,recommend,null,null);
        if(!imgs1.isEmpty()) {
            blog.setImgs("/img/" + imgs1.getOriginalFilename());
            String path = this.getClass().getResource("/").getPath() + "static/img";
            final String fileName = imgs1.getOriginalFilename();
            File file = new File(path, fileName);
            imgs1.transferTo(file);
            String path1 =this.getClass().getResource("/").getPath()+"static";
            File file1 = new File(path1,imgs);
            file1.delete();
            imgs="/img/"+imgs1.getOriginalFilename();
            blog.setImgs(imgs);
            blogService.updateblog(blog);
        }else {
            blogService.updateblog(blog);
        }
        return "redirect:adminblog";
    }

    @PostMapping("addblogok")
    @OpenLog(operModul = "addblog",operDesc = "添加博文",operType = "GET")
    public String addblog(@RequestParam(name = "title") String title,
                          @RequestParam(name = "text") String text,
                          @RequestParam(name = "category") String category,
                          @RequestParam(name="imgs") MultipartFile imgs) throws IOException {
        if(!imgs.isEmpty()){
            String path =this.getClass().getResource("/").getPath()+"static/img";
             String fileName = imgs.getOriginalFilename();
                File file = new File(path,fileName);
                imgs.transferTo(file);
                blogService.insertblog(title, text, category,"/img/"+imgs.getOriginalFilename());
                return "redirect:adminblog";
            }
        return "redirect:toaddblog";
    }

    @RequestMapping("addblogimg")
    @ResponseBody
    public JSONObject editormdPic (@RequestParam(value = "editormd-image-file", required = true) MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception{

        String fileName = file.getOriginalFilename();

        String path = this.getClass().getResource("/").getPath()+"static/img";
        File targetFile = new File(path, fileName);

        //保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        JSONObject res = new JSONObject();
        res.put("url", "/img"+fileName);
        res.put("success", 1);
        res.put("message", "upload success!");
        return res;
    }

    @GetMapping("adminblog")
    public String adminblog(Model model,
                            @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        if (pageNum <= 0) {
            pageNum = 1;
        }
        List<Blog> all = blogService.findAllBlog(pageNum, pageSize);
        PageInfo<Blog> pageInfo = new PageInfo(all);
        int page[] = new int[pageInfo.getPages()];
        for (int i = 0; i < pageInfo.getPages(); i++) {
            page[i] = i;
        }
        String couts = "总共" + pageInfo.getPages() + " 页,共" + pageInfo.getTotal() + " 条数据。 每页";
        model.addAttribute("page", page);
        model.addAttribute("cout", couts);
        model.addAttribute("blog", pageInfo);
        return "admin/adminBlog";
    }

    @GetMapping("adminrecommend")
    @OpenLog(operModul = "admindrecommend",operDesc = "修改博文",operType = "GET")
    public String admindrecommend(@RequestParam(name = "recommend") String recommend,
                                  @RequestParam(name = "id") Long id) {
        blogService.updaterecommend(id, recommend);
        return "redirect:adminblog";
    }
    @GetMapping("admindeleteBlog")
    public String admindeleteBlog(@RequestParam(name = "id") Long id) throws FileNotFoundException {
        Blog oneBlog = blogService.findOneBlog(id);
        String path =this.getClass().getResource("/").getPath()+"static";
        File file = new File(path,oneBlog.getImgs());
        file.delete();
        blogService.deleteBlog(id);
        return "redirect:adminblog";
    }
}
