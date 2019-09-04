package com.cxk.vo;

import com.cxk.po.Page;
import com.cxk.po.TComp;
import java.util.Date;
import java.util.List;

public class CompListVo {

    private Page page;

    private List<TComp> compList;

    private String level;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String time;

    private String order;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }



    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<TComp> getCompList() {
        return compList;
    }

    public void setCompList(List<TComp> compList) {
        this.compList = compList;
    }
}
