package com.gs.greenspace.controller;

import com.gs.greenspace.dto.request.ProjectRequestDto;
import com.gs.greenspace.dto.response.ProjectResponseDto;
import com.gs.greenspace.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    // CREATE
    @PostMapping(value = "/create-project",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ProjectResponseDto> createProject(
            @RequestPart(value = "category", required = false) String category,
            @RequestPart(value = "name", required = false) String name,
            @RequestPart(value = "description", required = false) String description,
            @RequestPart(value = "location", required = false) String location,
            @RequestPart(value = "year", required = false) String year,
            @RequestPart(value = "area", required = false) String area,
            @RequestPart(value = "displayOrder", required = false) String displayOrder,
            @RequestPart(value = "status", required = false) String status,
            @RequestPart(value = "mainImage", required = false) MultipartFile mainImage,
            @RequestPart(value = "subImage1", required = false) MultipartFile subImage1,
            @RequestPart(value = "subImage2", required = false) MultipartFile subImage2,
            @RequestPart(value = "subImage3", required = false) MultipartFile subImage3,
            @RequestPart(value = "subImage4", required = false) MultipartFile subImage4,
            @RequestPart(value = "subImage5", required = false) MultipartFile subImage5
    ) throws IOException {

        ProjectRequestDto requestDto = new ProjectRequestDto();
        requestDto.setCategory(category);
        requestDto.setName(name);
        requestDto.setDescription(description);
        requestDto.setLocation(location);
        requestDto.setYear(year);
        requestDto.setArea(area);
        requestDto.setDisplayOrder(displayOrder != null ? Integer.parseInt(displayOrder) : null);
        requestDto.setStatus(status);
        requestDto.setMainImage(mainImage);
        requestDto.setSubImage1(subImage1);
        requestDto.setSubImage2(subImage2);
        requestDto.setSubImage3(subImage3);
        requestDto.setSubImage4(subImage4);
        requestDto.setSubImage5(subImage5);

        ProjectResponseDto response = projectService.createProject(requestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // GET BY ID
    @GetMapping("/get-project-by-id/{id}")
    public ResponseEntity<ProjectResponseDto> getProjectById(@PathVariable Long id) {
        ProjectResponseDto response = projectService.getProjectById(id);
        return ResponseEntity.ok(response);
    }

    // GET ALL
    @GetMapping("/get-all-projects")
    public ResponseEntity<List<ProjectResponseDto>> getAllProjects() {
        List<ProjectResponseDto> response = projectService.getAllProjects();
        return ResponseEntity.ok(response);
    }

    // UPDATE (PUT - full update)
    @PutMapping(value = "/update-project/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ProjectResponseDto> updateProject(
            @PathVariable Long id,
            @RequestPart(value = "category", required = false) String category,
            @RequestPart(value = "name", required = false) String name,
            @RequestPart(value = "description", required = false) String description,
            @RequestPart(value = "location", required = false) String location,
            @RequestPart(value = "year", required = false) String year,
            @RequestPart(value = "area", required = false) String area,
            @RequestPart(value = "displayOrder", required = false) String displayOrder,
            @RequestPart(value = "status", required = false) String status,
            @RequestPart(value = "mainImage", required = false) MultipartFile mainImage,
            @RequestPart(value = "subImage1", required = false) MultipartFile subImage1,
            @RequestPart(value = "subImage2", required = false) MultipartFile subImage2,
            @RequestPart(value = "subImage3", required = false) MultipartFile subImage3,
            @RequestPart(value = "subImage4", required = false) MultipartFile subImage4,
            @RequestPart(value = "subImage5", required = false) MultipartFile subImage5
    ) throws IOException {

        ProjectRequestDto requestDto = new ProjectRequestDto();
        requestDto.setCategory(category);
        requestDto.setName(name);
        requestDto.setDescription(description);
        requestDto.setLocation(location);
        requestDto.setYear(year);
        requestDto.setArea(area);
        requestDto.setDisplayOrder(displayOrder != null ? Integer.parseInt(displayOrder) : null);
        requestDto.setStatus(status);
        requestDto.setMainImage(mainImage);
        requestDto.setSubImage1(subImage1);
        requestDto.setSubImage2(subImage2);
        requestDto.setSubImage3(subImage3);
        requestDto.setSubImage4(subImage4);
        requestDto.setSubImage5(subImage5);

        ProjectResponseDto response = projectService.updateProject(id, requestDto);
        return ResponseEntity.ok(response);
    }

    // PATCH (partial update)
    @PatchMapping(value = "/patch-project/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ProjectResponseDto> patchProject(
            @PathVariable Long id,
            @RequestPart(value = "category", required = false) String category,
            @RequestPart(value = "name", required = false) String name,
            @RequestPart(value = "description", required = false) String description,
            @RequestPart(value = "location", required = false) String location,
            @RequestPart(value = "year", required = false) String year,
            @RequestPart(value = "area", required = false) String area,
            @RequestPart(value = "displayOrder", required = false) String displayOrder,
            @RequestPart(value = "status", required = false) String status,
            @RequestPart(value = "mainImage", required = false) MultipartFile mainImage,
            @RequestPart(value = "subImage1", required = false) MultipartFile subImage1,
            @RequestPart(value = "subImage2", required = false) MultipartFile subImage2,
            @RequestPart(value = "subImage3", required = false) MultipartFile subImage3,
            @RequestPart(value = "subImage4", required = false) MultipartFile subImage4,
            @RequestPart(value = "subImage5", required = false) MultipartFile subImage5
    ) throws IOException {

        ProjectRequestDto requestDto = new ProjectRequestDto();
        requestDto.setCategory(category);
        requestDto.setName(name);
        requestDto.setDescription(description);
        requestDto.setLocation(location);
        requestDto.setYear(year);
        requestDto.setArea(area);
        requestDto.setDisplayOrder(displayOrder != null ? Integer.parseInt(displayOrder) : null);
        requestDto.setStatus(status);
        requestDto.setMainImage(mainImage);
        requestDto.setSubImage1(subImage1);
        requestDto.setSubImage2(subImage2);
        requestDto.setSubImage3(subImage3);
        requestDto.setSubImage4(subImage4);
        requestDto.setSubImage5(subImage5);

        ProjectResponseDto response = projectService.patchProject(id, requestDto);
        return ResponseEntity.ok(response);
    }

    // DELETE
    @DeleteMapping("/delete-project/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.ok("Project deleted successfully with id: " + id);
    }
}