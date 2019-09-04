package com.cxk.service;

import com.cxk.mapper.TUserTeamMapper;
import com.cxk.po.TUser;
import com.cxk.vo.JoinTeamVo;

public interface UserService {

    TUser findUserByName(String username) throws Exception;

    TUser findUserByStdId(String stdId) throws Exception;

    Integer insertUser(TUser user) throws Exception;

    Integer updateUserInfoByName(TUser user, String username) throws Exception;

    TUser findUserById(Integer id) throws Exception;

    Integer insertUserToUser2TeamById(JoinTeamVo joinTeamVo) throws Exception;

    Integer[] selectUserBelongSameTeam(Integer teamId) throws Exception;

    Integer findUserJoinTeam(TUser user) throws Exception;

    Integer insertUser2Team(Integer userId, Integer teamId) throws Exception;

    Integer insertUser2Comp(Integer userId, Integer compId) throws Exception;
}
