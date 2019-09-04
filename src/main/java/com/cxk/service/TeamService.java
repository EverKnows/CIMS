package com.cxk.service;

import com.cxk.po.TComp;
import com.cxk.po.TTeam;
import com.cxk.po.TUser;
import com.cxk.vo.TeamListVo;

import java.util.List;

public interface TeamService {
    List<TTeam> findTeamByCompIdByPage(TeamListVo teamListVo) throws Exception;

    Integer querySumOfTeam(TeamListVo teamListVo) throws  Exception;

    List<TUser> findUsersBelongYourTeam(Integer id) throws Exception;

    Integer findTeamIdByUserId(Integer id) throws Exception;

    TComp findCompByTeamId(Integer id) throws Exception;

    Integer insertTeamByName(String teamName, Integer userId) throws Exception;

    Integer insertTeam2Comp2Award(Integer teamId, Integer compId) throws Exception;

}
