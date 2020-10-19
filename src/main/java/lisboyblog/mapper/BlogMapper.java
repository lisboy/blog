package lisboyblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lisboyblog.pojo.Blog;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author FAN BOY
 * @version 1.0
 * @date 2020/7/16 21:52
 */
@Repository
public interface BlogMapper extends BaseMapper<Blog> {
    void updaterecommend(Long id, String recommend);

    List<Blog> findAll();

    List findTime();

}
