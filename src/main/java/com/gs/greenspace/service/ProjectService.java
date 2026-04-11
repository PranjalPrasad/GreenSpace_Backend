package com.gs.greenspace.service;

import com.gs.greenspace.dto.request.ProjectRequestDto;
import com.gs.greenspace.dto.response.ProjectResponseDto;

import java.io.IOException;
import java.util.List;

public interface ProjectService {

    ProjectResponseDto createProject(ProjectRequestDto requestDto) throws IOException;

    ProjectResponseDto getProjectById(Long id);

    List<ProjectResponseDto> getAllProjects();

    ProjectResponseDto updateProject(Long id, ProjectRequestDto requestDto) throws IOException;

    ProjectResponseDto patchProject(Long id, ProjectRequestDto requestDto) throws IOException;

    void deleteProject(Long id);
}