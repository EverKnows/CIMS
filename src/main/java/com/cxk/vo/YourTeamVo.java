package com.cxk.vo;

import com.cxk.po.TComp;
import com.cxk.po.TTeam;
import com.cxk.po.TUser;

import java.util.List;

public class YourTeamVo {

    private List<TUser> userList;

    private TTeam team;

    private TComp comp;

    public List<TUser> getUserList() {
        return userList;
    }

    public void setUserList(List<TUser> userList) {
        this.userList = userList;
    }

    public TTeam getTeam() {
        return team;
    }

    public void setTeam(TTeam team) {
        this.team = team;
    }

    public TComp getComp() {
        return comp;
    }

    public void setComp(TComp comp) {
        this.comp = comp;
    }
}
