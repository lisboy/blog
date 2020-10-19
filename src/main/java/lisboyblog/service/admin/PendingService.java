package lisboyblog.service.admin;

import lisboyblog.pojo.Pending;

import java.util.List;

/**
 * @author FAN BOY
 * @version 1.0
 * @date 2020/9/13 12:33
 */
public interface PendingService  {
    List<Pending> findAll();
    void addPending(Pending pending);
    void deletdPend(Long id);
}
