package lisboyblog.service.impl;

import lisboyblog.mapper.PhotoMapper;
import lisboyblog.pojo.Photo;
import lisboyblog.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author FAN BOY
 * @version 1.0
 * @date 2020/8/17 19:09
 */
@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private PhotoMapper photoMapper;
    @Override
    public List<Photo> findAll() {
        return photoMapper.selectList(null);
    }

    @Override
    public void deleteph(Long id) {
        photoMapper.deleteById(id);
    }

    @Override
    public Photo findOne(Long id) {
        return photoMapper.selectById(id);
    }

    @Override
    public void addphoto(String url) {
        photoMapper.insert(new Photo(null,url));
    }
}
