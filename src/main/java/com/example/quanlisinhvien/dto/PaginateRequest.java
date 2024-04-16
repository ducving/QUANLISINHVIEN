package com.example.quanlisinhvien.dto;

import org.springframework.data.domain.Sort;

public class PaginateRequest {
    private int page;
    private String sortBy;




    public String getSortBy() {
        return sortBy;
    }

    public PaginateRequest setSortBy(String sortBy) {
        this.sortBy = sortBy;
        return this;
    }

    private String direction;

    public Sort.Direction getDirection() {
        if (direction.equals("asc"))
            return Sort.Direction.ASC;

        return Sort.Direction.DESC;
    }

    public PaginateRequest setDirection(String direction) {
        this.direction = direction;
        return this;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public PaginateRequest() {
        this.page = 0;
        this.size = 5;
    }

    public PaginateRequest(int page, int size) {
        this.page = page;
        this.size = size;
    }

}
