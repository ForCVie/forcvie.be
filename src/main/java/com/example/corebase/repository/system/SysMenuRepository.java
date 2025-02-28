package com.example.corebase.repository.system;

import com.example.corebase.entity.system.SysMenuEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("sysMenuRepository")
public interface SysMenuRepository extends JpaRepository<SysMenuEntity, String> {

    List<SysMenuEntity> findByDelYnAndSiteTypeOrderByDisplayOrder(String delYn, String type);
}
