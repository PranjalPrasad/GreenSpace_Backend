package com.gs.greenspace.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "form_fields")
public class FormFieldEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fieldName;      // e.g. "Full Name", "Mobile Number"
    private String fieldType;      // e.g. "text", "email", "tel", "textarea"
    private String placeholder;    // e.g. "Enter your name"
    private int displayOrder;      // field ka position form mein

    public FormFieldEntity() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFieldName() { return fieldName; }
    public void setFieldName(String fieldName) { this.fieldName = fieldName; }

    public String getFieldType() { return fieldType; }
    public void setFieldType(String fieldType) { this.fieldType = fieldType; }

    public String getPlaceholder() { return placeholder; }
    public void setPlaceholder(String placeholder) { this.placeholder = placeholder; }

    public int getDisplayOrder() { return displayOrder; }
    public void setDisplayOrder(int displayOrder) { this.displayOrder = displayOrder; }
}
