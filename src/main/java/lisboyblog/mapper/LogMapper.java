package lisboyblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lisboyblog.pojo.Log;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author FAN BOY
 * @version 1.0
 * @date 2020/8/16 14:20
 */
@Repository
public interface LogMapper extends BaseMapper<Log> {
    List<Log> selectAll();
    void truncate();
}
