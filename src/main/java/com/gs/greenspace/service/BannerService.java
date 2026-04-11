package com.gs.greenspace.service;
import com.gs.greenspace.entity.BannerEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BannerService {

    BannerEntity createBanner(String pageName, String header, String text,
                              List<MultipartFile> bannerFileOne,
                              MultipartFile bannerFileTwo,
                              MultipartFile bannerFileThree,
                              MultipartFile bannerFileFour) throws IOException;

    BannerEntity updateBanner(Long id, String pageName, String header, String text,
                              List<MultipartFile> bannerFileOne,
                              MultipartFile bannerFileTwo,
                              MultipartFile bannerFileThree,
                              MultipartFile bannerFileFour) throws IOException;

    List<BannerEntity> getAllBanners();

    BannerEntity getBannerById(Long id);

    void deleteBanner(Long id);
}
