package com.dev.controller.util;

import java.util.List;

public class PageInfo {

    private int limit;
    private int offset;

    public PageInfo(int limit, int offset) {
        this.limit = limit;
        this.offset = offset;
    }

    public PageInfo(){};

    public int getLimit() {
        return limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
