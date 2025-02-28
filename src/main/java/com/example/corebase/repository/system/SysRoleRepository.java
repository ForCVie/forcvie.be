package com.example.corebase.repository.system;

import com.example.corebase.entity.system.SysRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysRoleRepository extends JpaRepository<SysRoleEntity, String> {
}
