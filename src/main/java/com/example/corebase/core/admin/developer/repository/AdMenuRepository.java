package com.example.corebase.core.admin.developer.repository;

import com.example.corebase.core.admin.developer.model.dto.AdMenuConDTO;
import com.example.corebase.core.admin.developer.model.request.AdMenuFilterRequest;
import com.example.corebase.core.admin.developer.model.response.AdMenuResponse;
import com.example.corebase.entity.system.SysMenuEntity;
import com.example.corebase.repository.system.SysMenuRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdMenuRepository extends SysMenuRepository {

    @Query(value = """
        SELECT 
            m.menu_id as menuId,
            FN_GET_CODE_NAME(m.site_type) as siteType,
            m.nm,
            FN_GET_CODE_NAME(m.use_yn) as useYn,
            parent.nm as parent
        FROM menu m 
        LEFT JOIN menu parent ON m.parent_id = parent.menu_id AND parent.del_yn = :#{#con.delYn}
        WHERE m.del_yn = :#{#con.delYn}
        AND (:#{#req.siteType} IS NULL OR m.site_type LIKE CONCAT('%', :#{#req.siteType}, '%'))
        AND (:#{#req.nm} IS NULL OR m.nm LIKE CONCAT('%', :#{#req.nm}, '%'))
        AND (:#{#req.parentId} IS NULL OR m.parent_id LIKE CONCAT('%', :#{#req.parentId}, '%'))
        AND (:#{#req.useYn} IS NULL OR m.use_yn LIKE CONCAT('%', :#{#req.useYn}, '%'))
    """, countQuery = """
        SELECT
            m.menu_id as menuId,
            FN_GET_CODE_NAME(m.site_type) as siteType,
            m.nm,
            FN_GET_CODE_NAME(m.use_yn) as useYn,
            parent.nm as parent
        FROM menu m
        LEFT JOIN menu parent ON m.parent_id = parent.menu_id AND parent.del_yn = :#{#con.delYn}
        WHERE m.del_yn = :#{#con.delYn}
        AND (:#{#req.siteType} IS NULL OR m.site_type LIKE CONCAT('%', :#{#req.siteType}, '%'))
        AND (:#{#req.nm} IS NULL OR m.nm LIKE CONCAT('%', :#{#req.nm}, '%'))
        AND (:#{#req.parentId} IS NULL OR m.parent_id LIKE CONCAT('%', :#{#req.parentId}, '%'))
        AND (:#{#req.useYn} IS NULL OR m.use_yn LIKE CONCAT('%', :#{#req.useYn}, '%'))
    """, nativeQuery = true)
    Page<AdMenuResponse> getPageData(@Param("req")AdMenuFilterRequest req, @Param("con")AdMenuConDTO con, Pageable pageable);

    Optional<SysMenuEntity> findByMenuIdAndDelYn(String menuId, String delYn);

    List<SysMenuEntity> findByMenuIdNotInAndDelYn(List<String> menuId, String delYn);

    List<SysMenuEntity> findByDelYnAndSiteType(String delYn, String siteType);
}
