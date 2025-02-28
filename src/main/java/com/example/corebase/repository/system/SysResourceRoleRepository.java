package com.example.corebase.repository.system;

import com.example.corebase.entity.system.SysResourceRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysResourceRoleRepository extends JpaRepository<SysResourceRoleEntity, Long> {
}
