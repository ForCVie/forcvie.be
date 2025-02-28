package com.example.corebase.repository.system;

import com.example.corebase.entity.system.SysUserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserRoleRepository extends JpaRepository<SysUserRoleEntity, String> {
}
