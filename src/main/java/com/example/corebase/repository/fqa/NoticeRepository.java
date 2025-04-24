package com.example.corebase.repository.fqa;

import com.example.corebase.entity.fqa.NoticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("noticeRepository")
public interface NoticeRepository extends JpaRepository<NoticeEntity, String> {
    String NOTICE_REPOSITORY = "noticeRepository";
}
