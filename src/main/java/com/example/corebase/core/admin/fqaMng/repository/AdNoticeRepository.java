package com.example.corebase.core.admin.fqaMng.repository;

import com.example.corebase.core.admin.fqaMng.model.request.AdNoticeFilterReq;
import com.example.corebase.core.admin.fqaMng.model.response.AdNoticeResponse;
import com.example.corebase.repository.fqa.NoticeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdNoticeRepository extends NoticeRepository {

    @Query(value = """
        SELECT 
            n.notice_seq as noticeSeq,
            n.title,
            FN_GET_CODE_NAME(n.post_cd) as postCd,
            FN_GET_CODE_NAME(n.top_fix_cd) as topFixCd
        FROM notice n
        WHERE (:#{#req.title} IS NULL OR n.title LIKE CONCAT('%', :#{#req.title}, '%'))
            AND (:#{#req.postCd} IS NULL OR n.post_cd LIKE CONCAT('%', :#{#req.postCd}, '%'))
            AND (:#{#req.topFixCd} IS NULL OR n.top_fix_cd LIKE CONCAT('%', :#{#req.topFixCd}, '%'))
            AND (:#{#req.roleId} IS NULL OR n.role_id LIKE CONCAT('%', :#{#req.roleId}, '%'))
    """, countQuery = """
        SELECT 
            n.notice_seq as noticeSeq,
            n.title,
            FN_GET_CODE_NAME(n.post_cd) as postCd,
            FN_GET_CODE_NAME(n.top_fix_cd) as topFixCd
        FROM notice n
        WHERE (:#{#req.title} IS NULL OR n.title LIKE CONCAT('%', :#{#req.title}, '%'))
            AND (:#{#req.postCd} IS NULL OR n.post_cd LIKE CONCAT('%', :#{#req.postCd}, '%'))
            AND (:#{#req.topFixCd} IS NULL OR n.top_fix_cd LIKE CONCAT('%', :#{#req.topFixCd}, '%'))
            AND (:#{#req.roleId} IS NULL OR n.role_id LIKE CONCAT('%', :#{#req.roleId}, '%'))
    """, nativeQuery = true)
    Page<AdNoticeResponse> getPageData(AdNoticeFilterReq req, Pageable pageable);
}
