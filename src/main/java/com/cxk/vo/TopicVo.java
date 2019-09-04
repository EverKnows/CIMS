package com.cxk.vo;

import com.cxk.po.TTopic;
import com.cxk.po.TUser;

public class TopicVo {
    private TTopic topic;

    private TUser user;

    public TTopic getTopic() {
        return topic;
    }

    public void setTopic(TTopic topic) {
        this.topic = topic;
    }

    public TUser getUser() {
        return user;
    }

    public void setUser(TUser user) {
        this.user = user;
    }
}
