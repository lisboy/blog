package lisboyblog.service.admin.impl;

import lisboyblog.mapper.LableMapper;
import lisboyblog.pojo.Lable;
import lisboyblog.service.admin.LableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author FAN BOY
 * @version 1.0
 * @date 2020/8/15 21:37
 */
@Service
public class LableServiceImpl implements LableService {
    @Autowired
    LableMapper lableMapper;


    @Override
    public void addlable(String lable) {
        lableMapper.insert(new Lable(null,lable));
    }

    @Override
    public List<Lable> findAll() {
        List<Lable> lables = lableMapper.selectList(null);
        return lables;
    }


    @Override
    public void deletelable(Long id) {
        lableMapper.deleteById(id);
    }
}
