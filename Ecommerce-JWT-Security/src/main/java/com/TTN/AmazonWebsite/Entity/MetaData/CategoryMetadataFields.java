package com.TTN.AmazonWebsite.Entity.MetaData;

import javax.persistence.*;


@Entity
public class CategoryMetadataFields {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @OneToOne(mappedBy = "categoryMetadataFields",cascade = CascadeType.ALL)
    private CategoryMetaDataFieldValues categoryMetaDataFieldValues;

    public CategoryMetaDataFieldValues getCategoryMetaDataFieldValues() {
        return categoryMetaDataFieldValues;
    }

    public void setCategoryMetaDataFieldValues(CategoryMetaDataFieldValues categoryMetaDataFieldValues) {
        this.categoryMetaDataFieldValues = categoryMetaDataFieldValues;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
