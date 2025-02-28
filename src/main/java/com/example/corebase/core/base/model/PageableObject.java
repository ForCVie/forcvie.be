package com.example.corebase.core.base.model;

import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
public class PageableObject<T> {

    private List<T> data;
    private long totalRecord;
    private int currentPage;

    public PageableObject(Page<T> page) {
        this.data = page.getContent();
        this.totalRecord = page.getTotalElements();
        this.currentPage = page.getNumber();
    }
}
