package com.example.corebase.core.admin.developer.repository;

import com.example.corebase.entity.system.SysMenuRoleEntity;
import com.example.corebase.repository.system.SysMenuRoleRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdMenuRoleRepository extends SysMenuRoleRepository {

    List<SysMenuRoleEntity> findByRoleId(String roleId);
}
