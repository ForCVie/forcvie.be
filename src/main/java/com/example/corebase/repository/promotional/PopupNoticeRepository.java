package com.example.corebase.repository.promotional;

import com.example.corebase.entity.promotional.PopupNoticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PopupNoticeRepository extends JpaRepository<PopupNoticeEntity, String> {
}
