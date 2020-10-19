package lisboyblog.service.admin.impl;

import lisboyblog.mapper.FurlMapper;
import lisboyblog.pojo.Furl;
import lisboyblog.service.admin.FurlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author FAN BOY
 * @version 1.0
 * @date 2020/8/17 10:05
 */
@Service
public class FurlServiceImpl implements FurlService {

    @Autowired
    FurlMapper furlMapper;


    @Override
    public void addFurl(String description,String url, String pwd) {
        furlMapper.insert(new Furl(null,description,url,pwd));
    }


    @Override
    public List<Furl> findAllFurl() {
        List<Furl> furls = furlMapper.selectList(null);
        return furls;
    }


    @Override
    public void deletdFurl(Long id) {
        furlMapper.deleteById(id);
    }
}
