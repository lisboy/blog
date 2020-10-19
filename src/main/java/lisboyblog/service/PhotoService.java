package lisboyblog.service;

import lisboyblog.pojo.Photo;

import java.util.List;

/**
 * @author FAN BOY
 * @version 1.0
 * @date 2020/8/17 19:07
 */
public interface PhotoService {
    /**
     * 获得所有个人相片
     * @return
     */
    List<Photo> findAll();

    /**
     * 添加新的相片
     * @param url
     */
    void addphoto(String url);

    /**
     * 删除一张相片
     * @param id
     */
    void deleteph(Long id);

    /**
     * 查找一张相片
     * @param id
     * @return
     */
    Photo findOne(Long id);
}
