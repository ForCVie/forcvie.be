package com.example.corebase.core.admin.developer.repository;

import com.example.corebase.entity.system.SysResourceEntity;
import com.example.corebase.repository.system.SysResourceRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface AdResourceRepository extends SysResourceRepository {

    Page<SysResourceEntity> findByUrlContainsAndRsNmContainsAndHttpMethodContainsAndRsTypeContainsOrderByIdDesc(String url, String rsNm, String httpMethod, String rsType, Pageable pageable);
}
