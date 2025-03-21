package com.example.corebase.core.admin.help.repository;

import com.example.corebase.entity.HelpMngEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelpMngRepository extends JpaRepository<HelpMngEntity, String> {

}
