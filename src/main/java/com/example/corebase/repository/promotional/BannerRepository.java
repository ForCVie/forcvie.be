package com.example.corebase.repository.promotional;

import com.example.corebase.entity.promotional.BannerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("bannerRepository")
public interface BannerRepository extends JpaRepository<BannerEntity, String> {
    String BANNER_REPOSITORY = "bannerRepository";
}
