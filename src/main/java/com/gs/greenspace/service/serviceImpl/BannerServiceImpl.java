package com.gs.greenspace.service.serviceImpl;
import com.gs.greenspace.entity.BannerEntity;
import com.gs.greenspace.repository.BannerRepository;
import com.gs.greenspace.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerRepository bannerRepository;

    @Override
    public BannerEntity createBanner(String pageName, String header, String text,
                                     List<MultipartFile> bannerFileOneList,
                                     MultipartFile bannerFileTwo,
                                     MultipartFile bannerFileThree,
                                     MultipartFile bannerFileFour) throws IOException {

        BannerEntity banner = new BannerEntity(pageName, header, text);

        // Handle bannerFileOne (List<byte[]>)
        if (bannerFileOneList != null && !bannerFileOneList.isEmpty()) {
            List<byte[]> fileBytesList = new ArrayList<>();
            for (MultipartFile file : bannerFileOneList) {
                if (!file.isEmpty()) {
                    fileBytesList.add(file.getBytes());
                }
            }
            banner.setBannerFileOne(fileBytesList);
        }

        // Handle single files
        if (bannerFileTwo != null && !bannerFileTwo.isEmpty()) {
            banner.setBannerFileTwo(bannerFileTwo.getBytes());
        }
        if (bannerFileThree != null && !bannerFileThree.isEmpty()) {
            banner.setBannerFileThree(bannerFileThree.getBytes());
        }
        if (bannerFileFour != null && !bannerFileFour.isEmpty()) {
            banner.setBannerFileFour(bannerFileFour.getBytes());
        }

        return bannerRepository.save(banner);
    }

    @Override
    public BannerEntity updateBanner(Long id, String pageName, String header, String text,
                                     List<MultipartFile> bannerFileOneList,
                                     MultipartFile bannerFileTwo,
                                     MultipartFile bannerFileThree,
                                     MultipartFile bannerFileFour) throws IOException {

        Optional<BannerEntity> optional = bannerRepository.findById(id);
        if (optional.isEmpty()) {
            throw new RuntimeException("Banner not found with id: " + id);
        }

        BannerEntity banner = optional.get();
        banner.setPageName(pageName);
        banner.setHeader(header);
        banner.setText(text);

        // Update bannerFileOne if provided
        if (bannerFileOneList != null && !bannerFileOneList.isEmpty()) {
            List<byte[]> fileBytesList = new ArrayList<>();
            for (MultipartFile file : bannerFileOneList) {
                if (!file.isEmpty()) {
                    fileBytesList.add(file.getBytes());
                }
            }
            banner.setBannerFileOne(fileBytesList);
        }

        if (bannerFileTwo != null && !bannerFileTwo.isEmpty()) {
            banner.setBannerFileTwo(bannerFileTwo.getBytes());
        }
        if (bannerFileThree != null && !bannerFileThree.isEmpty()) {
            banner.setBannerFileThree(bannerFileThree.getBytes());
        }
        if (bannerFileFour != null && !bannerFileFour.isEmpty()) {
            banner.setBannerFileFour(bannerFileFour.getBytes());
        }

        return bannerRepository.save(banner);
    }

    @Override
    public List<BannerEntity> getAllBanners() {
        return bannerRepository.findAll();
    }

    @Override
    public BannerEntity getBannerById(Long id) {
        return bannerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Banner not found with id: " + id));
    }

    @Override
    public void deleteBanner(Long id) {
        if (!bannerRepository.existsById(id)) {
            throw new RuntimeException("Banner not found with id: " + id);
        }
        bannerRepository.deleteById(id);
    }
}
