package com.cxk.vo;

import com.cxk.po.Page;
import com.cxk.po.TTeam;

import java.util.List;

public class TeamListVo {
    private List<TTeam> teamList;

    private List<String> userNameList;

    public List<String> getUserNameList() {
        return userNameList;
    }

    public void setUserNameList(List<String> userNameList) {
        this.userNameList = userNameList;
    }

    private Page page;

    private String status;

    private String errorInfo;

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public List<TTeam> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<TTeam> teamList) {
        this.teamList = teamList;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
