package com.gs.greenspace.dto.response;
import java.time.LocalDateTime;

public class ProjectResponseDto {

    private Long id;
    private String category;
    private String name;
    private String description;
    private String location;
    private String year;
    private String area;
    private Integer displayOrder;
    private String status;
    private String mainImageBase64;
    private String subImage1Base64;
    private String subImage2Base64;
    private String subImage3Base64;
    private String subImage4Base64;
    private String subImage5Base64;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProjectResponseDto() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getYear() { return year; }
    public void setYear(String year) { this.year = year; }

    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }

    public Integer getDisplayOrder() { return displayOrder; }
    public void setDisplayOrder(Integer displayOrder) { this.displayOrder = displayOrder; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getMainImageBase64() { return mainImageBase64; }
    public void setMainImageBase64(String mainImageBase64) { this.mainImageBase64 = mainImageBase64; }

    public String getSubImage1Base64() { return subImage1Base64; }
    public void setSubImage1Base64(String subImage1Base64) { this.subImage1Base64 = subImage1Base64; }

    public String getSubImage2Base64() { return subImage2Base64; }
    public void setSubImage2Base64(String subImage2Base64) { this.subImage2Base64 = subImage2Base64; }

    public String getSubImage3Base64() { return subImage3Base64; }
    public void setSubImage3Base64(String subImage3Base64) { this.subImage3Base64 = subImage3Base64; }

    public String getSubImage4Base64() { return subImage4Base64; }
    public void setSubImage4Base64(String subImage4Base64) { this.subImage4Base64 = subImage4Base64; }

    public String getSubImage5Base64() { return subImage5Base64; }
    public void setSubImage5Base64(String subImage5Base64) { this.subImage5Base64 = subImage5Base64; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}