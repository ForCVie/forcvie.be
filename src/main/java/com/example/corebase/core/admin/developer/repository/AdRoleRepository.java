package com.example.corebase.core.admin.developer.repository;

import com.example.corebase.entity.system.SysRoleEntity;
import com.example.corebase.repository.system.SysRoleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface AdRoleRepository extends SysRoleRepository {

    Page<SysRoleEntity> findByRoleCdContainsAndRoleNmContainsAndRoleSiteCdContains(String roleCd, String roleNm, String roleSiteCd, Pageable pageable);
}
