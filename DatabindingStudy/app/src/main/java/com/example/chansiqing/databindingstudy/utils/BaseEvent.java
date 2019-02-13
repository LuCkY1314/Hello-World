package com.example.chansiqing.databindingstudy.utils;

/**
 * eventBus使用的信息传递类
 *
 * @author: chansiqing
 * @date: 2019-01-31 14:55
 */
public class BaseEvent {
    public static final String ON_RESUME = "onResume";
    public static final String ON_PAUSE = "onPause";
    public static final String ON_SCROLL = "onScroll";
    public static final String ON_SCROLL_STOP = "onScrollStop";
    private String id;
    private Object param;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BaseEvent(String id) {
        this.id = id;
    }
}
