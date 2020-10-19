package lisboyblog.service.admin.impl;

import lisboyblog.mapper.PendingMapper;
import lisboyblog.pojo.Pending;
import lisboyblog.service.admin.PendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author FAN BOY
 * @version 1.0
 * @date 2020/9/13 12:34
 */
@Service
public class PendingServiceImpl implements PendingService {
    @Autowired
    PendingMapper pendingMapper;
    @Override
    public List<Pending> findAll() {
        return pendingMapper.selectList(null);
    }

    @Override
    public void addPending(Pending pending) {
        pendingMapper.insert(pending);
    }

    @Override
    public void deletdPend(Long id) {
        pendingMapper.deleteById(id);
    }
}
