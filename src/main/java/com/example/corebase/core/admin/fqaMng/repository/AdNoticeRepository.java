package com.example.corebase.core.admin.fqaMng.repository;

import com.example.corebase.core.admin.fqaMng.model.request.AdNoticeFilterReq;
import com.example.corebase.core.admin.fqaMng.model.response.AdNoticeResponse;
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
            n.read_cnt,
            sr.role_nm as role_id
        FROM notice n
        JOIN sys_role sr ON sr.role_id = n.role_id
        WHERE (:#{#req.title} IS NULL OR n.title LIKE CONCAT('%', :#{#req.title}, '%'))
            AND (:#{#req.postCd} IS NULL OR n.post_cd = :#{#req.postCd})
            AND (:#{#req.topFixCd} IS NULL OR n.top_fix_cd = :#{#req.topFixCd})
            AND (:#{#req.roleId} IS NULL OR n.role_id = :#{#req.roleId})
    """, nativeQuery = true)
    Page<AdNoticeResponse> getPageData(AdNoticeFilterReq req, Pageable pageable);
}
