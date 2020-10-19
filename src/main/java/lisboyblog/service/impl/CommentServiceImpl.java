package lisboyblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lisboyblog.mapper.CommentMapper;
import lisboyblog.pojo.Comment;
import lisboyblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author FAN BOY
 * @version 1.0
 * @date 2020/8/16 23:50
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;

    @Override
    public List<Comment> findAll(Long blogid) {
        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("blogid",blogid).orderByDesc("updatetime");
        List<Comment> comments = commentMapper.selectList(queryWrapper);

        return comments;
    }

    @Override
    public void addcomment(Long blogid,String name,String email,String content) {
        if (name==null)name="评论君";
        if (email==null)email="123456789@163.com";
        commentMapper.insert(new Comment(null,blogid,name,email,content,null,null));
    }
}
