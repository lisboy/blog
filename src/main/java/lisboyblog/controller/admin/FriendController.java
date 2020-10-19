package lisboyblog.controller.admin;

import lisboyblog.pojo.Friend;
import lisboyblog.pojo.Furl;
import lisboyblog.service.admin.FriendService;
import lisboyblog.service.admin.FurlService;
import lisboyblog.service.admin.PendingService;
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
public class FriendController {

    @Autowired
    FriendService friendService;

    @Autowired
    PendingService pendingService;

    @RequestMapping("friend")
    public String friend(Model model){
        List<Friend> allFriend = friendService.findAllFriend();
        model.addAttribute("friend",allFriend);
        return "admin/friend";
    }

    @RequestMapping("addfriend")
    public String addfurl(@RequestParam(name = "blogname")String blogname,
                          @RequestParam(name = "url")String url,
                          @RequestParam(name = "logo",defaultValue = "/img/u=458327471,2618665836&fm=26&gp=0.jpg")String logo,
                          @RequestParam(name = "introduction")String introduction,
                          @RequestParam(name = "classification")String classification,
                          @RequestParam(name = "pendingid",defaultValue = "0")Long pendingid) {
        if (pendingid!=0){
            pendingService.deletdPend(pendingid);
        }
        friendService.addFriend(new Friend(null,blogname,url,logo,introduction,classification,null,null));
        return "redirect:friend";
    }

    @RequestMapping("deletefriend")
    public String addfurl(@RequestParam(name = "id")Long id){
        friendService.deletdFriend(id);
        return "redirect:friend";
    }
}
