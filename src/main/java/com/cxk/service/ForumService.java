package com.cxk.service;

import com.cxk.po.TTopic;

import java.util.List;

public interface ForumService {

    List<TTopic> findAllTopicByBoardId(Integer id) throws Exception;
}
