package com.cxk.service.Impl;

import com.cxk.mapper.TUser2compMapper;
import com.cxk.mapper.TUserMapper;
import com.cxk.mapper.TUserTeamMapper;
import com.cxk.po.TUser;
import com.cxk.po.TUser2comp;
import com.cxk.po.TUserExample;
import com.cxk.service.UserService;
import com.cxk.vo.JoinTeamVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TUserMapper userMapper;

    @Autowired
    private TUserTeamMapper userTeamMapper;

    @Autowired
    private TUser2compMapper user2compMapper;

    public TUser findUserByName(String username) throws Exception {
        TUserExample example = new TUserExample();
        TUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<TUser> list = userMapper.selectByExample(example);
        if (list.size() == 0) {
            return null;
        } else {
            return list.get(0);
        }
    }

    public TUser findUserByStdId(String stdId) throws Exception {

        TUserExample example = new TUserExample();
        TUserExample.Criteria criteria = example.createCriteria();
        criteria.andStdIdEqualTo(stdId);
        List<TUser> list = userMapper.selectByExample(example);
        if (list.size() == 0)
            return null;
        return list.get(0);
    }

    public TUser findUserById(Integer id) throws Exception {
        TUser user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    public Integer insertUser(TUser user) throws Exception {
        int i = userMapper.insertSelective(user);
        return i;
    }

    public Integer updateUserInfoByName(TUser user, String username) throws Exception {
        TUserExample example = new TUserExample();
        TUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        int i = userMapper.updateByExampleSelective(user, example);
        return i;
    }

    public Integer insertUserToUser2TeamById(JoinTeamVo joinTeamVo) throws Exception {
        Integer sum = userTeamMapper.insertUserToTeam(joinTeamVo);
        return sum;
    }

    public Integer[] selectUserBelongSameTeam(Integer teamId) throws Exception {
        return userTeamMapper.selectUserBelongSameTeam(teamId);
    }

    public Integer findUserJoinTeam(TUser user) throws Exception {
        return userTeamMapper.findUserJoinTeam(user);
    }

    public Integer insertUser2Team(Integer userId, Integer teamId) throws Exception {
        Integer i = userTeamMapper.insertUseridAndTeamId(userId, teamId);
        return i;
    }

    public Integer insertUser2Comp(Integer userId, Integer compId) throws Exception {
        TUser2comp user2comp = new TUser2comp();
        user2comp.setCompId(compId);
        user2comp.setUserId(userId);
        int i = user2compMapper.insertSelective(user2comp);
        return i;
    }
}
