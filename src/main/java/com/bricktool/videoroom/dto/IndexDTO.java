package com.bricktool.videoroom.dto;

public class IndexDTO {
    private int type;
    private String keyword;
    private int page;
    private int pageSize;

    public IndexDTO(int type, String keyword, int page, int pageSize) {
        this.type = type;
        this.keyword = keyword;
        this.page = page;
        this.pageSize = pageSize;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
