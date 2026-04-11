package com.gs.greenspace.dto.request;

import org.springframework.web.multipart.MultipartFile;

public class ProjectRequestDto {

    private String category;
    private String name;
    private String description;
    private String location;
    private String year;
    private String area;
    private Integer displayOrder;
    private String status;
    private MultipartFile mainImage;
    private MultipartFile subImage1;
    private MultipartFile subImage2;
    private MultipartFile subImage3;
    private MultipartFile subImage4;
    private MultipartFile subImage5;

    public ProjectRequestDto() {}

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

    public MultipartFile getMainImage() { return mainImage; }
    public void setMainImage(MultipartFile mainImage) { this.mainImage = mainImage; }

    public MultipartFile getSubImage1() { return subImage1; }
    public void setSubImage1(MultipartFile subImage1) { this.subImage1 = subImage1; }

    public MultipartFile getSubImage2() { return subImage2; }
    public void setSubImage2(MultipartFile subImage2) { this.subImage2 = subImage2; }

    public MultipartFile getSubImage3() { return subImage3; }
    public void setSubImage3(MultipartFile subImage3) { this.subImage3 = subImage3; }

    public MultipartFile getSubImage4() { return subImage4; }
    public void setSubImage4(MultipartFile subImage4) { this.subImage4 = subImage4; }

    public MultipartFile getSubImage5() { return subImage5; }
    public void setSubImage5(MultipartFile subImage5) { this.subImage5 = subImage5; }
}