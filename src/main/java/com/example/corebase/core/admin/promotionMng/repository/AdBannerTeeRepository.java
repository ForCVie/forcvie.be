package com.example.corebase.core.admin.promotionMng.repository;

import com.example.corebase.core.admin.promotionMng.model.dto.AdBannerTeeConDTO;
import com.example.corebase.core.admin.promotionMng.model.request.AdBannerTeeFilterReq;
import com.example.corebase.core.admin.promotionMng.model.response.AdBannerTeeResponse;
import com.example.corebase.entity.promotional.BannerTeeEntity;
import com.example.corebase.repository.promotional.BannerTeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdBannerTeeRepository extends BannerTeeRepository {

    @Query(value = """
        SELECT 
            b.banner_tee_seq,
            b.title,
            b.url,
            FN_GET_CODE_NAME(b.use_yn) as useYn,
            b.start_date,
            b.end_date
        FROM banner_tee b
        WHERE b.del_yn = :#{#con.delYn} 
        AND (:#{#req.title} IS NULL OR b.title LIKE CONCAT('%', :#{#req.title}, '%'))
        AND (:#{#req.useYn} IS NULL OR b.use_yn LIKE CONCAT('%', :#{#req.useYn}, '%'))
        AND (:#{#req.url} IS NULL OR b.url LIKE CONCAT('%', :#{#req.url}, '%'))
        AND (:#{#req.startDate} IS NULL OR b.start_date >= :#{#req.startDate})
        AND (:#{#req.endDate} IS NULL OR b.end_date >= :#{#req.endDate})
    """, nativeQuery = true)
    Page<AdBannerTeeResponse> getPageAdBannerTee(@Param("req") AdBannerTeeFilterReq req, @Param("con") AdBannerTeeConDTO con, Pageable pageable);

    Optional<BannerTeeEntity> findByBannerTeeSeqAndDelYn(String bannerSeq, String delYn);
}
