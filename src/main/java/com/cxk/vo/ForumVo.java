package com.cxk.vo;

import com.cxk.po.Page;
import com.cxk.po.TTopic;

import java.util.List;

public class ForumVo {
    private List<TTopic> topicList;

    private Integer boardId;

    private Page page;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<TTopic> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<TTopic> topicList) {
        this.topicList = topicList;
    }

    public Integer getBoardId() {
        return boardId;
    }

    public void setBoardId(Integer boardId) {
        this.boardId = boardId;
    }
}
