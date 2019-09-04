package com.cxk.mapper;

import com.cxk.po.TUser;
import com.cxk.vo.JoinTeamVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TUserTeamMapper {
    Integer insertUserToTeam(JoinTeamVo joinTeamVo) throws Exception;

    Integer[] selectUserBelongSameTeam(Integer teamId) throws Exception;

    Integer findUserJoinTeam(TUser user) throws Exception;

    List<TUser> findUsersWhichBelongYourTeam(Integer id) throws Exception;

    Integer findTeamIdByUserId(Integer id) throws Exception;

    Integer insertUseridAndTeamId(@Param(value="userId") Integer userId, @Param(value="teamId") Integer teamId) throws Exception;
}
