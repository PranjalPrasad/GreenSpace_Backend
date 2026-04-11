package com.gs.greenspace.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "projects")
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category")
    private String category;

    @Lob
    @Column(name = "main_image", columnDefinition = "LONGBLOB")
    private byte[] mainImage;

    @Lob
    @Column(name = "sub_image_1", columnDefinition = "LONGBLOB")
    private byte[] subImage1;

    @Lob
    @Column(name = "sub_image_2", columnDefinition = "LONGBLOB")
    private byte[] subImage2;

    @Lob
    @Column(name = "sub_image_3", columnDefinition = "LONGBLOB")
    private byte[] subImage3;

    @Lob
    @Column(name = "sub_image_4", columnDefinition = "LONGBLOB")
    private byte[] subImage4;

    @Lob
    @Column(name = "sub_image_5", columnDefinition = "LONGBLOB")
    private byte[] subImage5;

    @Column(name = "name")
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "location")
    private String location;

    @Column(name = "year")
    private String year;

    @Column(name = "area")
    private String area;

    @Column(name = "display_order")
    private Integer displayOrder;

    @Column(name = "status")
    private String status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public ProjectEntity() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public byte[] getMainImage() { return mainImage; }
    public void setMainImage(byte[] mainImage) { this.mainImage = mainImage; }

    public byte[] getSubImage1() { return subImage1; }
    public void setSubImage1(byte[] subImage1) { this.subImage1 = subImage1; }

    public byte[] getSubImage2() { return subImage2; }
    public void setSubImage2(byte[] subImage2) { this.subImage2 = subImage2; }

    public byte[] getSubImage3() { return subImage3; }
    public void setSubImage3(byte[] subImage3) { this.subImage3 = subImage3; }

    public byte[] getSubImage4() { return subImage4; }
    public void setSubImage4(byte[] subImage4) { this.subImage4 = subImage4; }

    public byte[] getSubImage5() { return subImage5; }
    public void setSubImage5(byte[] subImage5) { this.subImage5 = subImage5; }

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

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}