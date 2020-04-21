package com.TTN.AmazonWebsite.Entity.MetaData;

import com.TTN.AmazonWebsite.Entity.Product.Category;

import javax.persistence.*;

@Entity
public class CategoryMetaDataFieldValues {
    @Id
    private int  id;

    @Column(name = "info")
    private String values;

    @OneToOne
    @JoinColumn(name = "CATEGORY_METADATA_FIELD_ID")
    private CategoryMetadataFields categoryMetadataFields;

    @ManyToOne
    @JoinColumn(name = "category_ID")
    private Category category;

    public CategoryMetadataFields getCategoryMetadataFields() {
        return categoryMetadataFields;
    }

    public void setCategoryMetadataFields(CategoryMetadataFields categoryMetadataFields) {
        this.categoryMetadataFields = categoryMetadataFields;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }
}
