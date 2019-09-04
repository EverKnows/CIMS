package com.cxk.service.Impl;

import com.cxk.mapper.TTopicMapper;
import com.cxk.po.TTopic;
import com.cxk.po.TTopicExample;
import com.cxk.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ForumServiceImpl implements ForumService {
    @Autowired
    private TTopicMapper topicMapper;

    public List<TTopic> findAllTopicByBoardId(Integer id) throws Exception {
        TTopicExample topicExample = new TTopicExample();
        TTopicExample.Criteria criteria = topicExample.createCriteria();
        criteria.andBoardIdEqualTo(id);
        List<TTopic> topicList = topicMapper.selectByExample(topicExample);
        return topicList;
    }
}
