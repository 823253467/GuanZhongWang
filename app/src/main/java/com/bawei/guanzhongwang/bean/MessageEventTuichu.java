package com.bawei.guanzhongwang.bean;

/**
 * Created by MK on 2017/12/16.
 */

public class MessageEventTuichu {
    //eventbus
    public String name;
    public String url;

    public MessageEventTuichu() {
    }

    public MessageEventTuichu(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
