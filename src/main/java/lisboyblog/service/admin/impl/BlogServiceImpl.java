package lisboyblog.service.admin.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;

import lisboyblog.mapper.BlogMapper;
import lisboyblog.pojo.Blog;
import lisboyblog.pojo.Comment;
import lisboyblog.service.admin.BlogService;
import lisboyblog.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author FAN BOY
 * @version 1.0
 * @date 2020/7/18 17:36
 */
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogMapper blogMapper;

    @Autowired
    RedisUtil redisUtil;


    @Override
    public void updateblog(Blog blog) {
        redisUtil.del(blog.getId()+"");
        blogMapper.updateById(blog);
    }


    @Override
    public List<Blog> findFeatBlog() {
        QueryWrapper<Blog> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("creationtime");
        List<Blog> blogs = blogMapper.selectList(queryWrapper);
        return blogs;
    }


    @Override
    public List<Blog> findbloglike(int pageNum, int pageSize,String find) {
        QueryWrapper<Blog> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("title",find).or().like("category",find);
        PageHelper.startPage(pageNum, pageSize);
        List<Blog> blogs = blogMapper.selectList(queryWrapper);
        return blogs;
    }


    @Override
    public int findCoutBlog() {
        return blogMapper.selectList(null).size();
    }


    @Override
    public List<Blog> findAllBlog(int pageNum, int pageSize) {
        QueryWrapper<Blog> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("creationtime");
        PageHelper.startPage(pageNum, pageSize);
        return blogMapper.selectList(queryWrapper);
    }



    @Override
    public List<Blog> findAllBlog() {
        QueryWrapper<Blog> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("creationtime");
        return blogMapper.selectList(queryWrapper);
    }


    @Override
    public Blog findOneBlog(Long id) {
        String s = id + "";
        Blog redisblog = (Blog) redisUtil.get(s);
        if (redisblog == null) {
            System.out.println(556);
            Blog blog = blogMapper.selectById(id);
            boolean set = redisUtil.set(s, blog);
        }
        Blog redisblog2 = (Blog) redisUtil.get(s);
        return redisblog2;
    }


    @Override
    public void insertblog(String title, String text, String category,String imgs) {
        blogMapper.insert(new Blog(null,imgs, "lisboy", title, category, text, 0L, 0L, "0", null, null));
    }


    @Override
    public void updaterecommend(Long id, String recommend) {
        blogMapper.updaterecommend(id, recommend);
    }


    @Override
    public void deleteBlog(Long id) {
        redisUtil.del(id+"");
        blogMapper.deleteById(id);
    }


    @Override
    public List findTime() {
        List time = blogMapper.findTime();
        return time;
    }
}
