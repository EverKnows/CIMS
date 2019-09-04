package com.cxk.controller;

import com.cxk.mapper.TTopicMapper;
import com.cxk.mapper.TUserMapper;
import com.cxk.po.TTopic;
import com.cxk.po.TUser;
import com.cxk.service.ForumService;
import com.cxk.vo.ForumVo;
import com.cxk.vo.TopicVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ForumController {
    @Autowired
    private ForumService forumService;

    @Autowired
    private TTopicMapper topicMapper;

    @Autowired
    private TUserMapper userMapper;

    @RequestMapping("/forumList")
    public String forum(ForumVo forumVo, Model model) throws Exception {
        PageHelper.startPage(forumVo.getPage().getCurrentPage(), forumVo.getPage().getRow());
        List<TTopic> topicList = forumService.findAllTopicByBoardId(forumVo.getBoardId());
        PageInfo<TTopic> pageInfo = new PageInfo<TTopic>(topicList);

        forumVo.getPage().setTotalPages(pageInfo.getPages());
        forumVo.setTopicList(pageInfo.getList());
        model.addAttribute("forumVo", forumVo);
        return "forumList";
    }

    @RequestMapping("/forumInfo")
    public String forumInfo(Integer id, Model model) throws Exception {
        TopicVo topicVo = new TopicVo();
        TTopic topic = topicMapper.selectByPrimaryKey(id);
        TUser user = userMapper.selectByPrimaryKey(topic.getUserId());
        topicVo.setTopic(topic);
        topicVo.setUser(user);
        model.addAttribute("topicVo", topicVo);
        return "topicInfo";
    }
}
