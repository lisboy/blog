package lisboyblog.service;

import lisboyblog.pojo.Comment;

import java.util.List;

/**
 * @author FAN BOY
 * @version 1.0
 * @date 2020/8/16 23:48
 */
public interface CommentService {
    /**
     * 根据博文id查找所以评论
     * @param blogid
     * @return
     */
    List<Comment> findAll(Long blogid);

    /**
     * 添加评论
     * @param blogid
     * @param name
     * @param email
     * @param content
     */
    void addcomment(Long blogid,String name,String email,String content);
}
