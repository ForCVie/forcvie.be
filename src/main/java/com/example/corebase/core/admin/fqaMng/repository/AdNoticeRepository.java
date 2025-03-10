package com.example.corebase.core.admin.fqaMng.repository;

import com.example.corebase.core.admin.fqaMng.model.request.AdNoticeFilterReq;
import com.example.corebase.entity.NoticeEntity;
import com.example.corebase.repository.NoticeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdNoticeRepository extends NoticeRepository {

    @Query(value = """
        SELECT 
            n.notice_seq,
            n.title,
            n.content,
            FN_GET_CODE_NAME(n.post_cd) as post_cd,
            FN_GET_CODE_NAME(n.top_fix_cd) as top_fix_cd,
            n.read_cnt
        FROM notice n
        WHERE (:#{#req.title} IS NULL OR q.title LIKE CONCAT('%', :#{#req.title}, '%'))
            AND (:#{#req.postCd} IS NULL OR q.post_cd = :#{#req.postCd})
            AND (:#{#req.topFixCd} IS NULL OR q.top_fix_cd = :#{#req.topFixCd})
    """, nativeQuery = true)
    Page<NoticeEntity> getPageData(AdNoticeFilterReq req, Pageable pageable);
}
