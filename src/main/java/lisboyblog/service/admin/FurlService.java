package lisboyblog.service.admin;

import lisboyblog.pojo.Furl;

import java.util.List;

/**
 * @author FAN BOY
 * @version 1.0
 * @date 2020/8/17 10:03
 */
public interface FurlService {
   /**
    * 新增工具链接
    * @param description
    * @param url
    * @param pwd
    */
   void addFurl(String description,String url,String pwd);

   /**
    * 获得所有工具链接
    * @return
    */
   List<Furl> findAllFurl();

   /**
    * 根据链接id删除链接
    * @param id
    */
   void deletdFurl(Long id);
}
