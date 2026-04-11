package com.gs.greenspace.repository;
import com.gs.greenspace.entity.BannerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerRepository extends JpaRepository<BannerEntity, Long> {
}
