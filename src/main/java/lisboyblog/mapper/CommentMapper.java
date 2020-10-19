package lisboyblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lisboyblog.pojo.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author FAN BOY
 * @version 1.0
 * @date 2020/8/16 23:47
 */
@Repository
public interface CommentMapper extends BaseMapper<Comment> {

}
