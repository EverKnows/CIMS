package com.cxk.controller;

import com.cxk.controller.Utils.VerifyCodeUtils;
import com.cxk.mapper.TUserMapper;
import com.cxk.po.TUser;
import com.cxk.service.UserService;
import com.cxk.vo.JoinTeamVo;
import com.cxk.vo.LoginVo;
import com.cxk.vo.ModifyUserInfoVo;
import com.cxk.vo.RegistVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/logout")
    public String logout(HttpSession session) throws Exception {
        session.invalidate();
        return "index";
    }
    @RequestMapping("/info")
    public String info(HttpSession session, Model model) throws Exception {
        String username = (String) session.getAttribute("username");
        TUser user = userService.findUserByName(username);
        model.addAttribute("user", user);
        return "userinfo";
    }

    @RequestMapping("/modifyuserinfo")
    public String modifyuserinfo(HttpSession session, Model model) throws Exception {
        String username = (String) session.getAttribute("username");
        TUser user = userService.findUserByName(username);
        model.addAttribute("user", user);
        return "modifyuserinfo";
    }

    @RequestMapping("/updateuserinfo")
    public @ResponseBody ModifyUserInfoVo updateUserInfo(ModifyUserInfoVo userInfoVo,HttpSession session) throws Exception {
        String username = (String) session.getAttribute("username");
        int i = userService.updateUserInfoByName(userInfoVo.getUser(), username);
        if (i != 1) {
            userInfoVo.setStatus("fail");
            userInfoVo.setErrorInfo("未知错误");
        } else {
            userInfoVo.setStatus("success");
        }
        return userInfoVo;
    }

    @RequestMapping("/index")
    public String index() throws Exception {
        return "index";
    }

    @RequestMapping("/login")
    public String login() throws Exception {
        return "login";
    }

    @RequestMapping("/regist")
    public String regist() throws Exception {
        return "regist";
    }

    @RequestMapping("/loginCtrl")
    public @ResponseBody
    LoginVo loginCtrl(LoginVo loginVo
            , HttpServletRequest request
            , HttpServletResponse response) throws Exception {
        TUser user = userService.findUserByName(loginVo.getUsername());
        if (user.getPassword().equals(loginVo.getPassword())) {
            request.getSession().setAttribute("username", user.getUsername());
            loginVo.setAddress(request.getContextPath() + "/index");
        } else {
            loginVo.setStatus("fail");
        }
        return loginVo;
    }

    @RequestMapping("/getCheckCode")
    public void getCheckCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        session.setAttribute("checkCode", verifyCode);
        BufferedImage img = VerifyCodeUtils.getImage(133, 33, verifyCode);
        ImageIO.write(img, "jpg", response.getOutputStream());
    }

    @RequestMapping("/registCtrl")
    public @ResponseBody RegistVo validateUsername(RegistVo registVo,HttpServletRequest request) throws Exception {
        String stdId = null;
        TUser user = userService.findUserByName(registVo.getUser().getUsername());
        if (user == null) {
            user = userService.findUserByStdId(registVo.getUser().getStdId());
            if (user == null) {
                String code = (String) request.getSession().getAttribute("checkCode");
                if (code.equalsIgnoreCase(registVo.getCheckCode())) {
                    Integer integer = userService.insertUser(registVo.getUser());
                    if (integer == 0) {
                        registVo.setStatus("fail");
                        registVo.setErrorInfo("发生了未知错误！请刷新页面！");
                    } else {
                        registVo.setStatus("success");
                    }
                } else {
                    registVo.setStatus("fail");
                    registVo.setErrorInfo("验证码错误");
                }

            } else {
                registVo.setStatus("fail");
                registVo.setErrorInfo("该学号已被注册");
            }
        } else {
            registVo.setStatus("fail");
            registVo.setErrorInfo("用户名已存在");
        }
        return registVo;
    }

    @RequestMapping("/jointeam")
    public @ResponseBody
    JoinTeamVo joinTeam(JoinTeamVo joinTeamVo, HttpSession session) throws Exception {
        String username = (String) session.getAttribute("username");
        TUser user = userService.findUserByName(username);
        joinTeamVo.setUser(user);
        Integer flag = userService.findUserJoinTeam(joinTeamVo.getUser());
        if (flag >= 1) {
            joinTeamVo.setStatus("fail");
            joinTeamVo.setErrorInfo("你已经拥有了队伍！");
            return joinTeamVo;
        }

        Integer[] userIdList = userService.selectUserBelongSameTeam(joinTeamVo.getId());
        System.out.println(userIdList.length);
        if (userIdList.length > 4) {
            joinTeamVo.setStatus("fail");
            joinTeamVo.setErrorInfo("队伍人已满");
            return joinTeamVo;
        } else {
            userService.insertUserToUser2TeamById(joinTeamVo);
            joinTeamVo.setStatus("success");
            return joinTeamVo;
        }
    }


}
