package com.example.corebase.core.admin.promotionMng.repository;

import com.example.corebase.core.admin.promotionMng.model.dto.AdBannerConDTO;
import com.example.corebase.core.admin.promotionMng.model.request.AdBannerFilterReq;
import com.example.corebase.core.admin.promotionMng.model.response.AdBannerResponse;
import com.example.corebase.entity.promotional.BannerEntity;
import com.example.corebase.repository.promotional.BannerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdBannerRepository extends BannerRepository {

    @Query(value = """
        SELECT 
            b.banner_seq, 
            b.banner_nm,
            b.use_yn,
            b.url,
            FN_GET_CODE_NAME(b.banner_type) as typeNm
        FROM banner b
        WHERE b.del_yn = :#{#con.delYn} 
        AND (:#{#req.typeCd} IS NULL OR b.banner_type LIKE CONCAT('%', :#{#req.typeCd}, '%'))
        AND (:#{#req.bannerNm} IS NULL OR b.banner_nm LIKE CONCAT('%', :#{#req.bannerNm}, '%'))
        AND (:#{#req.useYn} IS NULL OR b.use_yn LIKE CONCAT('%', :#{#req.useYn}, '%'))
        AND (:#{#req.url} IS NULL OR b.url LIKE CONCAT('%', :#{#req.url}, '%'))
    """, nativeQuery = true)
    Page<AdBannerResponse> getPageAdBanner(@Param("req") AdBannerFilterReq req, @Param("con") AdBannerConDTO con, Pageable pageable);

    Optional<BannerEntity> findByBannerSeqAndDelYn(String bannerSeq, String delYn);
}
