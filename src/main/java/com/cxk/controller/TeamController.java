package com.cxk.controller;

import com.cxk.mapper.TTeamMapper;
import com.cxk.po.*;
import com.cxk.service.CompService;
import com.cxk.service.TeamService;
import com.cxk.service.UserService;
import com.cxk.vo.CreateTeamVo;
import com.cxk.vo.TeamListVo;
import com.cxk.vo.YourTeamVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
@Controller
public class TeamController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private UserService userService;

    @Autowired
    private TTeamMapper tTeamMapper;

    @Autowired
    private CompService compService;

    @RequestMapping("/teamlist")
    public String teamQuery(TeamListVo teamListVo, Model model) throws Exception {
        List<TTeam> teamList = teamService.findTeamByCompIdByPage(teamListVo);
        List<String> list = new ArrayList<String>();
        for (TTeam tTeam : teamList) {
            list.add(userService.findUserById(tTeam.getUserId()).getUsername());
        }
        teamListVo.setUserNameList(list);
        model.addAttribute("teamList", teamListVo);
        return "teamList";
    }

    @RequestMapping("/yourteam")
    public String yourteam (HttpSession session, Model model) throws Exception {
        YourTeamVo vo = new YourTeamVo();
        String username = (String) session.getAttribute("username");
        TUser user = userService.findUserByName(username);
        Integer teamId = teamService.findTeamIdByUserId(user.getId());
        if (teamId == null ) {
            model.addAttribute("teamVo", vo);
            return "yourTeam";
        }
        TTeam team = tTeamMapper.selectByPrimaryKey(teamId);
        TComp comp = teamService.findCompByTeamId(teamId);
        System.out.println("comp : " + comp.getCompName());
        List<TUser> userList = teamService.findUsersBelongYourTeam(user.getId());
        vo.setComp(comp);
        vo.setUserList(userList);
        vo.setTeam(team);

        model.addAttribute("teamVo", vo);
        return "yourTeam";
    }

    @RequestMapping("/createTeam")
    public String createTeam(Integer compId, Model model) throws Exception {
        model.addAttribute("compId", compId);
        return "createTeam";
    }

    @RequestMapping("/addTeam")
    public @ResponseBody CreateTeamVo addTeam(CreateTeamVo createTeamVo, HttpSession session) throws Exception {
        Integer compId = createTeamVo.getCompId();
        String username = (String) session.getAttribute("username");
        createTeamVo.setUserName(username);
        TUser user = userService.findUserByName(username);
        Integer flag = userService.findUserJoinTeam(user);
        if (flag == 0) {
            Integer sum = teamService.insertTeamByName(createTeamVo.getTeamName(), user.getId());
            if (sum == null) {
                createTeamVo.setStatus("fail");
                createTeamVo.setErrorInfo("该队伍名已被注册!");
                return createTeamVo;
            } else if (sum == 0) {
                createTeamVo.setStatus("fail");
                createTeamVo.setErrorInfo("遇到未知错误!");
                return createTeamVo;
            } else {
                TTeamExample example = new TTeamExample();
                TTeamExample.Criteria criteria = example.createCriteria();
                criteria.andTeamNameEqualTo(createTeamVo.getTeamName());
                List<TTeam> teams = tTeamMapper.selectByExample(example);
                Integer teamId = teams.get(0).getId();
                userService.insertUser2Team(user.getId(), teamId);
                userService.insertUser2Comp(user.getId(), compId);
                teamService.insertTeamByName(createTeamVo.getTeamName(), user.getId());
                createTeamVo.setStatus("success");
            }
        } else {
            createTeamVo.setStatus("fail");
            createTeamVo.setErrorInfo("你已经加入了队伍!");
            return createTeamVo;
        }
        return createTeamVo;
    }
}
