package lisboyblog.service.admin;

import lisboyblog.pojo.Friend;
import lisboyblog.pojo.Furl;

import java.util.List;

/**
 * @author FAN BOY
 * @version 1.0
 * @date 2020/8/17 10:03
 */
public interface FriendService {
   /**
    * 新增友链
    * @param friend
    */
   void addFriend(Friend friend);

   /**
    * 获得所有友情链接
    * @return
    */
   List<Friend> findAllFriend();

   /**
    * 根据链接id删除链接
    * @param id
    */
   void deletdFriend(Long id);
}
