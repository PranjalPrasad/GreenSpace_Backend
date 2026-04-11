package com.gs.greenspace.service.serviceImpl;

import com.gs.greenspace.dto.request.ProjectRequestDto;
import com.gs.greenspace.dto.response.ProjectResponseDto;
import com.gs.greenspace.entity.ProjectEntity;
import com.gs.greenspace.repository.ProjectRepository;
import com.gs.greenspace.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public ProjectResponseDto createProject(ProjectRequestDto requestDto) throws IOException {
        ProjectEntity entity = new ProjectEntity();

        entity.setCategory(requestDto.getCategory());
        entity.setName(requestDto.getName());
        entity.setDescription(requestDto.getDescription());
        entity.setLocation(requestDto.getLocation());
        entity.setYear(requestDto.getYear());
        entity.setArea(requestDto.getArea());
        entity.setDisplayOrder(requestDto.getDisplayOrder());
        entity.setStatus(requestDto.getStatus());

        if (requestDto.getMainImage() != null && !requestDto.getMainImage().isEmpty()) {
            entity.setMainImage(requestDto.getMainImage().getBytes());
        }
        if (requestDto.getSubImage1() != null && !requestDto.getSubImage1().isEmpty()) {
            entity.setSubImage1(requestDto.getSubImage1().getBytes());
        }
        if (requestDto.getSubImage2() != null && !requestDto.getSubImage2().isEmpty()) {
            entity.setSubImage2(requestDto.getSubImage2().getBytes());
        }
        if (requestDto.getSubImage3() != null && !requestDto.getSubImage3().isEmpty()) {
            entity.setSubImage3(requestDto.getSubImage3().getBytes());
        }
        if (requestDto.getSubImage4() != null && !requestDto.getSubImage4().isEmpty()) {
            entity.setSubImage4(requestDto.getSubImage4().getBytes());
        }
        if (requestDto.getSubImage5() != null && !requestDto.getSubImage5().isEmpty()) {
            entity.setSubImage5(requestDto.getSubImage5().getBytes());
        }

        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());

        ProjectEntity saved = projectRepository.save(entity);
        return mapToResponseDto(saved);
    }

    @Override
    public ProjectResponseDto getProjectById(Long id) {
        ProjectEntity entity = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found with id: " + id));
        return mapToResponseDto(entity);
    }

    @Override
    public List<ProjectResponseDto> getAllProjects() {
        List<ProjectEntity> entities = projectRepository.findAll();
        List<ProjectResponseDto> responseDtos = new ArrayList<>();
        for (ProjectEntity entity : entities) {
            responseDtos.add(mapToResponseDto(entity));
        }
        return responseDtos;
    }

    @Override
    public ProjectResponseDto updateProject(Long id, ProjectRequestDto requestDto) throws IOException {
        ProjectEntity entity = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found with id: " + id));

        entity.setCategory(requestDto.getCategory());
        entity.setName(requestDto.getName());
        entity.setDescription(requestDto.getDescription());
        entity.setLocation(requestDto.getLocation());
        entity.setYear(requestDto.getYear());
        entity.setArea(requestDto.getArea());
        entity.setDisplayOrder(requestDto.getDisplayOrder());
        entity.setStatus(requestDto.getStatus());

        if (requestDto.getMainImage() != null && !requestDto.getMainImage().isEmpty()) {
            entity.setMainImage(requestDto.getMainImage().getBytes());
        }
        if (requestDto.getSubImage1() != null && !requestDto.getSubImage1().isEmpty()) {
            entity.setSubImage1(requestDto.getSubImage1().getBytes());
        }
        if (requestDto.getSubImage2() != null && !requestDto.getSubImage2().isEmpty()) {
            entity.setSubImage2(requestDto.getSubImage2().getBytes());
        }
        if (requestDto.getSubImage3() != null && !requestDto.getSubImage3().isEmpty()) {
            entity.setSubImage3(requestDto.getSubImage3().getBytes());
        }
        if (requestDto.getSubImage4() != null && !requestDto.getSubImage4().isEmpty()) {
            entity.setSubImage4(requestDto.getSubImage4().getBytes());
        }
        if (requestDto.getSubImage5() != null && !requestDto.getSubImage5().isEmpty()) {
            entity.setSubImage5(requestDto.getSubImage5().getBytes());
        }

        entity.setUpdatedAt(LocalDateTime.now());

        ProjectEntity updated = projectRepository.save(entity);
        return mapToResponseDto(updated);
    }

    @Override
    public ProjectResponseDto patchProject(Long id, ProjectRequestDto requestDto) throws IOException {
        ProjectEntity entity = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found with id: " + id));

        if (requestDto.getCategory() != null) {
            entity.setCategory(requestDto.getCategory());
        }
        if (requestDto.getName() != null) {
            entity.setName(requestDto.getName());
        }
        if (requestDto.getDescription() != null) {
            entity.setDescription(requestDto.getDescription());
        }
        if (requestDto.getLocation() != null) {
            entity.setLocation(requestDto.getLocation());
        }
        if (requestDto.getYear() != null) {
            entity.setYear(requestDto.getYear());
        }
        if (requestDto.getArea() != null) {
            entity.setArea(requestDto.getArea());
        }
        if (requestDto.getDisplayOrder() != null) {
            entity.setDisplayOrder(requestDto.getDisplayOrder());
        }
        if (requestDto.getStatus() != null) {
            entity.setStatus(requestDto.getStatus());
        }
        if (requestDto.getMainImage() != null && !requestDto.getMainImage().isEmpty()) {
            entity.setMainImage(requestDto.getMainImage().getBytes());
        }
        if (requestDto.getSubImage1() != null && !requestDto.getSubImage1().isEmpty()) {
            entity.setSubImage1(requestDto.getSubImage1().getBytes());
        }
        if (requestDto.getSubImage2() != null && !requestDto.getSubImage2().isEmpty()) {
            entity.setSubImage2(requestDto.getSubImage2().getBytes());
        }
        if (requestDto.getSubImage3() != null && !requestDto.getSubImage3().isEmpty()) {
            entity.setSubImage3(requestDto.getSubImage3().getBytes());
        }
        if (requestDto.getSubImage4() != null && !requestDto.getSubImage4().isEmpty()) {
            entity.setSubImage4(requestDto.getSubImage4().getBytes());
        }
        if (requestDto.getSubImage5() != null && !requestDto.getSubImage5().isEmpty()) {
            entity.setSubImage5(requestDto.getSubImage5().getBytes());
        }

        entity.setUpdatedAt(LocalDateTime.now());

        ProjectEntity patched = projectRepository.save(entity);
        return mapToResponseDto(patched);
    }

    @Override
    public void deleteProject(Long id) {
        ProjectEntity entity = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found with id: " + id));
        projectRepository.delete(entity);
    }

    private ProjectResponseDto mapToResponseDto(ProjectEntity entity) {
        ProjectResponseDto dto = new ProjectResponseDto();

        dto.setId(entity.getId());
        dto.setCategory(entity.getCategory());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setLocation(entity.getLocation());
        dto.setYear(entity.getYear());
        dto.setArea(entity.getArea());
        dto.setDisplayOrder(entity.getDisplayOrder());
        dto.setStatus(entity.getStatus());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        if (entity.getMainImage() != null) {
            dto.setMainImageBase64(Base64.getEncoder().encodeToString(entity.getMainImage()));
        }
        if (entity.getSubImage1() != null) {
            dto.setSubImage1Base64(Base64.getEncoder().encodeToString(entity.getSubImage1()));
        }
        if (entity.getSubImage2() != null) {
            dto.setSubImage2Base64(Base64.getEncoder().encodeToString(entity.getSubImage2()));
        }
        if (entity.getSubImage3() != null) {
            dto.setSubImage3Base64(Base64.getEncoder().encodeToString(entity.getSubImage3()));
        }
        if (entity.getSubImage4() != null) {
            dto.setSubImage4Base64(Base64.getEncoder().encodeToString(entity.getSubImage4()));
        }
        if (entity.getSubImage5() != null) {
            dto.setSubImage5Base64(Base64.getEncoder().encodeToString(entity.getSubImage5()));
        }

        return dto;
    }
}