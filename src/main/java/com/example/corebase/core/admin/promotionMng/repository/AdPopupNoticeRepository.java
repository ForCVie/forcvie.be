package com.example.corebase.core.admin.promotionMng.repository;

import com.example.corebase.core.admin.promotionMng.model.dto.AdPopupNoticeConDTO;
import com.example.corebase.core.admin.promotionMng.model.request.AdPopupNoticeFilterReq;
import com.example.corebase.core.admin.promotionMng.model.response.AdBannerTeeResponse;
import com.example.corebase.entity.promotional.PopupNoticeEntity;
import com.example.corebase.repository.promotional.PopupNoticeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdPopupNoticeRepository extends PopupNoticeRepository {

    @Query(value = """
        SELECT 
            b.popup_notice_seq,
            b.title,
            b.url,
            FN_GET_CODE_NAME(b.use_yn) as useYn,
            b.start_date,
            b.end_date
        FROM popup_notice b
        WHERE b.del_yn = :#{#con.delYn} 
        AND (:#{#req.title} IS NULL OR b.title LIKE CONCAT('%', :#{#req.title}, '%'))
        AND (:#{#req.useYn} IS NULL OR b.use_yn LIKE CONCAT('%', :#{#req.useYn}, '%'))
        AND (:#{#req.url} IS NULL OR b.url LIKE CONCAT('%', :#{#req.url}, '%'))
        AND (:#{#req.startDate} IS NULL OR :#{#req.startDate} = '' OR b.start_date >= :#{#req.startDate})
        AND (:#{#req.endDate} IS NULL OR :#{#req.endDate} = '' OR b.end_date <= :#{#req.endDate})
    """, nativeQuery = true)
    Page<AdBannerTeeResponse> getPagePopupNotice(@Param("req") AdPopupNoticeFilterReq req, @Param("con") AdPopupNoticeConDTO con, Pageable pageable);

    Optional<PopupNoticeEntity> findByPopupNoticeSeq(String id, String delYn);
}
