package com.example.corebase.repository.fqa;

import com.example.corebase.entity.fqa.QAEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("qaRepository")
public interface QARepository extends JpaRepository<QAEntity, String> {
    String QA_REPOSITORY = "qaRepository";
}
