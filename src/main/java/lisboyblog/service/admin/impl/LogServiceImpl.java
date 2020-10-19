package lisboyblog.service.admin.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import lisboyblog.mapper.LogMapper;
import lisboyblog.pojo.Log;
import lisboyblog.service.admin.LogService;
import lisboyblog.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author FAN BOY
 * @version 1.0
 * @date 2020/8/16 14:22
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    LogMapper logMapper;

    @Autowired
    RedisUtil redisUtil;

    @Override
    public void addLog(String log) {
        logMapper.insert(new Log(null,log,null,null));
    }


    @Override
    public List<Log> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.orderByDesc("creationtime");
        List<Log> logs = logMapper.selectList(queryWrapper);
        return logs;
    }


    @Override
    public void truncate() {
//        redisUtil.flushDb();
        logMapper.truncate();
    }
}
