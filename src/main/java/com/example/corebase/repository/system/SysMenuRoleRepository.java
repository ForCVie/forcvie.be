package com.example.corebase.repository.system;

import com.example.corebase.entity.system.SysMenuRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysMenuRoleRepository extends JpaRepository<SysMenuRoleEntity, String> {
}
