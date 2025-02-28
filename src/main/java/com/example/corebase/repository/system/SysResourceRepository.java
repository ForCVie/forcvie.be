package com.example.corebase.repository.system;

import com.example.corebase.entity.system.SysResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysResourceRepository extends JpaRepository<SysResourceEntity, Long> {
}
