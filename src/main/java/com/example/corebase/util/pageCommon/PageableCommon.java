package com.example.corebase.util.pageCommon;

import com.example.corebase.core.base.model.PageableRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageableCommon {

    public static Pageable getPageable(PageableRequest pageableRequest) {
        Sort sort = sort(pageableRequest.getSort(), pageableRequest.getSortType());
        if (sort == null) {
            return PageRequest.of(pageableRequest.getPage() - 1, pageableRequest.getSize());
        }
        return PageRequest.of(pageableRequest.getPage() - 1, pageableRequest.getSize(), sort);
    }

    private static Sort sort(String sortField, String sortType) {
        if (sortField != null && !sortField.isEmpty()) {
            return sortType.equalsIgnoreCase("desc") ? Sort.by(Sort.Direction.DESC, sortField) : Sort.by(Sort.Direction.ASC, sortField);
        } else {
            return null;
        }
    }
}
