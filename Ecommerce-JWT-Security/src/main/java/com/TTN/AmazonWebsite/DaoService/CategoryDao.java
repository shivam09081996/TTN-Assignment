package com.TTN.AmazonWebsite.DaoService;

import com.TTN.AmazonWebsite.Entity.MetaData.CategoryMetaDataFieldValues;
import com.TTN.AmazonWebsite.Entity.MetaData.CategoryMetadataFields;
import com.TTN.AmazonWebsite.Entity.Product.Category;
import com.TTN.AmazonWebsite.Repo.CategoryMetaDataFieldRepo;
import com.TTN.AmazonWebsite.Repo.CategoryMetaDataFieldValuesRepo;
import com.TTN.AmazonWebsite.Repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryDao {

        @Autowired
        private CategoryMetaDataFieldRepo categoryMetaDataFieldRepo;

        @Autowired
        private CategoryRepo categoryRepo;


        @Autowired
        private CategoryMetaDataFieldValuesRepo categoryMetaDataFieldValuesRepo;

        public String addMetaDataField(String field){

        CategoryMetadataFields categoryMetadataFields=new CategoryMetadataFields();
        categoryMetadataFields.setName(field);

        categoryMetaDataFieldRepo.save(categoryMetadataFields);

        return  "field saved successfully";
    }


        public List<CategoryMetadataFields> viewMetadataField(){
            return categoryMetaDataFieldRepo.findallfields();
        }


        public String AddCategory(String CatgoryName){
            Category category=new Category();
            category.setProductType(CatgoryName);
            categoryRepo.save(category);
            return "category added successfully";
        }

        public Optional<Category> findCategory(int  id){
          return categoryRepo.findById(id);
        }

        public List<Category> findList(){
            return categoryRepo.findListOfCategory();
        }

        public String CategoryUpdate(int id,String newCategory){
          Category category=categoryRepo.findById(id).get();
          category.setProductType(newCategory);
          categoryRepo.save(category);
          return "your category  is  updated";
        }


        public String metaDataForCategory(int categoryID,int metadataFiledId,String fieldvalue){
        Category category=categoryRepo.findById(categoryID).get();

        CategoryMetadataFields categoryMetadataFields=categoryMetaDataFieldRepo.findById(metadataFiledId).get();

            CategoryMetaDataFieldValues categoryMetaDataFieldValues=new CategoryMetaDataFieldValues();

            categoryMetaDataFieldValues.setCategoryMetadataFields(categoryMetadataFields);

            categoryMetaDataFieldValues.setCategory(category);

            categoryMetaDataFieldValues.setValues(fieldvalue);

            categoryMetaDataFieldValuesRepo.save(categoryMetaDataFieldValues);

            return "metadata is saved for category";


        }


        public String updateMetaDataValuesForField(int categoryID,int metadataFiledId,
                                                   int  fieldId,String fieldvalue){

            Category category=categoryRepo.findById(categoryID).get();
            CategoryMetadataFields categoryMetadataFields=categoryMetaDataFieldRepo.findById(metadataFiledId).get();


            CategoryMetaDataFieldValues categoryMetaDataFieldValues=
                    categoryMetaDataFieldValuesRepo.findById(fieldId).get();

            categoryMetaDataFieldValues.setCategoryMetadataFields(categoryMetadataFields);

            categoryMetaDataFieldValues.setCategory(category);

            categoryMetaDataFieldValues.setValues(fieldvalue);

            categoryMetaDataFieldValuesRepo.save(categoryMetaDataFieldValues);

            return "metadata is saved for category";

        }

}
