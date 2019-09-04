package com.cxk.service.Impl;

import com.cxk.mapper.TTeam2comp2awardMapper;
import com.cxk.mapper.TTeamCompMapper;
import com.cxk.mapper.TTeamMapper;
import com.cxk.mapper.TUserTeamMapper;
import com.cxk.po.*;
import com.cxk.service.TeamService;
import com.cxk.vo.TeamListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TTeamMapper teamMapper;

    @Autowired
    private TTeamCompMapper teamCompMapper;

    @Autowired
    private TUserTeamMapper userTeamMapper;

    @Autowired
    private TTeam2comp2awardMapper team2comp2awardMapper;

    public List<TTeam> findTeamByCompIdByPage(TeamListVo teamListVo) throws Exception {
        if (teamListVo.getPage() == null) {
            teamListVo.setPage(new Page());
        }

        if (teamListVo.getPage().getCurrentPage() == null) {
            teamListVo.getPage().setCurrentPage(1);
        }

        if (teamListVo.getPage().getRow() == null) {
            teamListVo.getPage().setRow(5);
        }

        teamListVo.getPage().setStart((teamListVo.getPage().getCurrentPage() - 1) * teamListVo.getPage().getRow());
        List<TTeam> teamList = teamCompMapper.findTeamByCompIdByPage(teamListVo);
        teamListVo.setTeamList(teamList);
        Integer sum = teamCompMapper.querySumOfTeam(teamListVo);
        teamListVo.getPage().setTotalRecords(sum);
        System.out.println("sum : " + sum);
        Integer totalPages = (sum % teamListVo.getPage().getRow()) == 0 ? (sum / teamListVo.getPage().getRow()) :(sum / teamListVo.getPage().getRow() + 1);
        System.out.println("totalPages : " + totalPages);
        teamListVo.getPage().setTotalPages(totalPages);

        return teamListVo.getTeamList();

    }

    public Integer querySumOfTeam(TeamListVo teamListVo) throws Exception {
        return teamCompMapper.querySumOfTeam(teamListVo);
    }

    public List<TUser> findUsersBelongYourTeam(Integer id) throws Exception {
        List<TUser> userList = userTeamMapper.findUsersWhichBelongYourTeam(id);
        return userList;
    }

    public Integer findTeamIdByUserId(Integer id) throws Exception {
        Integer teamId = userTeamMapper.findTeamIdByUserId(id);
        return teamId;
    }

    public TComp findCompByTeamId(Integer id) throws Exception {
        TComp comp = teamCompMapper.findCompByTeamId(id);
        return comp;
    }

    public Integer insertTeamByName(String teamName, Integer userId) throws Exception {
        TTeamExample example = new TTeamExample();
        TTeam team = new TTeam();
        TTeamExample.Criteria criteria = example.createCriteria();
        criteria.andTeamNameEqualTo(teamName);
        List<TTeam> list = teamMapper.selectByExample(example);
        if (list.size() == 0 || list == null) {
            team.setTeamName(teamName);
            team.setUserId(userId);
            int i = teamMapper.insertSelective(team);
            return i;

        } else {
            return null;
        }
    }

    public Integer insertTeam2Comp2Award(Integer teamId, Integer compId) throws Exception {
        TTeam2comp2award team2comp2award = new TTeam2comp2award();
        team2comp2award.setCompId(compId);
        team2comp2award.setTeamId(teamId);
        int i = team2comp2awardMapper.insertSelective(team2comp2award);
        return i;
    }
}
