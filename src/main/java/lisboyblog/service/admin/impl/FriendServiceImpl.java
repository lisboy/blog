package lisboyblog.service.admin.impl;

import lisboyblog.mapper.FriendMapper;
import lisboyblog.mapper.FurlMapper;
import lisboyblog.pojo.Friend;
import lisboyblog.pojo.Furl;
import lisboyblog.service.admin.FriendService;
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
public class FriendServiceImpl implements FriendService {

    @Autowired
    FriendMapper friendMapper;


    @Override
    public void addFriend(Friend friend) {
        friendMapper.insert(friend);
    }


    @Override
    public List<Friend> findAllFriend() {
        List<Friend> friends = friendMapper.selectList(null);
        return friends;
    }


    @Override
    public void deletdFriend(Long id) {
        friendMapper.deleteById(id);
    }
}
