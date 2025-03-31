package com.example.corebase.repository.promotional;

import com.example.corebase.entity.promotional.BannerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerRepository extends JpaRepository<BannerEntity, String> {
}
