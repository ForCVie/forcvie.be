package com.example.corebase.repository.promotional;

import com.example.corebase.entity.promotional.BannerTeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("bannerTeeRepository")
public interface BannerTeeRepository extends JpaRepository<BannerTeeEntity, String> {
    String BANNER_TEE_REPOSITORY = "bannerTeeRepository";
}
