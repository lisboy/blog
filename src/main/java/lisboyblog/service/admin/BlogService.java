package lisboyblog.service.admin;



import lisboyblog.pojo.Blog;

import java.util.Date;
import java.util.List;

/**
 * @author FAN BOY
 * @version 1.0
 * @date 2020/7/18 17:36
 */
public interface BlogService {

    /**
     * 修改博客
     * @param blog
     */
    void updateblog(Blog blog);

    /**
     * 寻找
     * @return
     */
    List<Blog> findFeatBlog();

    /**
     * 根据标题或者分类模糊查询获得所有的相关博文
     * @param pageNum
     * @param pageSize
     * @param find
     * @return
     */
    List<Blog> findbloglike(int pageNum, int pageSize,String find);

    /**
     * 获取博文数量
     * @return
     */
    int findCoutBlog();

    /**
     * 分页方式查看所有博文
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Blog> findAllBlog(int pageNum, int pageSize);

    /**
     * 根据创建时间降序获得所有博文
     * @return
     */
    List<Blog> findAllBlog();
    /**
     * 修改推荐
     * @param id
     * @param recommend
     */
    void updaterecommend(Long id, String recommend);

    /**
     * 根据博文id从缓存中获取博文，如果为null则查询数据库获取
     * @param id
     * @return
     */
    Blog findOneBlog(Long id);

    /**
     * 添加一篇新的博文
     * @param title
     * @param text
     * @param category
     * @param imgs
     */
    void insertblog(String title, String text, String category,String imgs);

    /**
     * 根据id删除一篇博文
     * @param id
     */
    void deleteBlog(Long id);

    /**
     * 获得所有的博文时间
     * @return
     */
    List findTime();

}
