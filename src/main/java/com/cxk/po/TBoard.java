package com.cxk.po;

public class TBoard {
    private Integer id;

    private String boardName;

    private String boardDesc;

    private Integer topicNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName == null ? null : boardName.trim();
    }

    public String getBoardDesc() {
        return boardDesc;
    }

    public void setBoardDesc(String boardDesc) {
        this.boardDesc = boardDesc == null ? null : boardDesc.trim();
    }

    public Integer getTopicNum() {
        return topicNum;
    }

    public void setTopicNum(Integer topicNum) {
        this.topicNum = topicNum;
    }
}