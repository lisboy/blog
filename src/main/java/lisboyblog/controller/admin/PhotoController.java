package lisboyblog.controller.admin;

import lisboyblog.pojo.Blog;
import lisboyblog.pojo.Photo;
import lisboyblog.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * @author FAN BOY
 * @version 1.0
 * @date 2020/8/17 19:10
 */
@Controller
@RequestMapping("admin")
public class PhotoController {

    @Autowired
    PhotoService photoService;
    @RequestMapping("addphoto")
    public String addphoto(@RequestParam(name="url") MultipartFile url) throws IOException {
        if(!url.isEmpty()){
            String path = this.getClass().getResource("/").getPath()+"static/img";
            final String fileName = url.getOriginalFilename();
            File file = new File(path,fileName);
            url.transferTo(file);
            photoService.addphoto("/img/"+url.getOriginalFilename());
        }
        return "redirect:catphoto";
    }

    @RequestMapping("catphoto")
    public String catphoto(Model model){
        List<Photo> photos = photoService.findAll();
        model.addAttribute("photo",photos);
        return "admin/photo";
    }
    @RequestMapping(value = "deletephoto",method = RequestMethod.GET)
    public String deletephoto(Model model,Long id) throws FileNotFoundException {
        Photo photo = photoService.findOne(id);
        String path = ResourceUtils.getURL("classpath:").getPath()+"static";
        String realPath = path.replace('/', '\\').substring(1,path.length());
        File file = new File(realPath,photo.getUrl());
        file.delete();
        photoService.deleteph(id);
        return "redirect:catphoto";
    }
}
