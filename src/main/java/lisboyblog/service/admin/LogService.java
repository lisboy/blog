package lisboyblog.service.admin;

import lisboyblog.pojo.Log;

import java.util.List;

/**
 * @author FAN BOY
 * @version 1.0
 * @date 2020/8/16 14:21
 */
public interface LogService {
    /**
     * 新增一个日志
     * @param log
     */
    void addLog(String log);

    /**
     * 获取所有日志
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Log> findAll(int pageNum, int pageSize);

    /**
     * 清楚日志表中所有数据
     */
   void truncate();
}
