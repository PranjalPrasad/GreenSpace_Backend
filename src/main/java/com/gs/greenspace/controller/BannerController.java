package com.gs.greenspace.controller;
import com.gs.greenspace.entity.BannerEntity;
import com.gs.greenspace.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/banners")
@CrossOrigin(origins = "*")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    // CREATE
    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<BannerEntity> createBanner(
            @RequestParam("pageName") String pageName,
            @RequestParam("header") String header,
            @RequestParam("text") String text,
            @RequestParam(value = "bannerFileOne", required = false) List<MultipartFile> bannerFileOne,
            @RequestParam(value = "bannerFileTwo", required = false) MultipartFile bannerFileTwo,
            @RequestParam(value = "bannerFileThree", required = false) MultipartFile bannerFileThree,
            @RequestParam(value = "bannerFileFour", required = false) MultipartFile bannerFileFour) throws IOException {

        BannerEntity saved = bannerService.createBanner(pageName, header, text,
                bannerFileOne, bannerFileTwo, bannerFileThree, bannerFileFour);

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // UPDATE (Full update)
    @PutMapping(value = "/update/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<BannerEntity> updateBanner(
            @PathVariable Long id,
            @RequestParam("pageName") String pageName,
            @RequestParam("header") String header,
            @RequestParam("text") String text,
            @RequestParam(value = "bannerFileOne", required = false) List<MultipartFile> bannerFileOne,
            @RequestParam(value = "bannerFileTwo", required = false) MultipartFile bannerFileTwo,
            @RequestParam(value = "bannerFileThree", required = false) MultipartFile bannerFileThree,
            @RequestParam(value = "bannerFileFour", required = false) MultipartFile bannerFileFour) throws IOException {

        BannerEntity updated = bannerService.updateBanner(id, pageName, header, text,
                bannerFileOne, bannerFileTwo, bannerFileThree, bannerFileFour);

        return ResponseEntity.ok(updated);
    }

    // GET ALL
    @GetMapping("/get-all")
    public ResponseEntity<List<BannerEntity>> getAllBanners() {
        return ResponseEntity.ok(bannerService.getAllBanners());
    }

    // GET BY ID
    @GetMapping("/get/{id}")
    public ResponseEntity<BannerEntity> getBannerById(@PathVariable Long id) {
        return ResponseEntity.ok(bannerService.getBannerById(id));
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBanner(@PathVariable Long id) {
        bannerService.deleteBanner(id);
        return ResponseEntity.ok("Banner deleted successfully with id: " + id);
    }
}
