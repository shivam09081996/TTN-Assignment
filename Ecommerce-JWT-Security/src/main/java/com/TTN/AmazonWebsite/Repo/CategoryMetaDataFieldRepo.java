package com.TTN.AmazonWebsite.Repo;

import com.TTN.AmazonWebsite.Entity.MetaData.CategoryMetadataFields;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryMetaDataFieldRepo extends CrudRepository<CategoryMetadataFields,Integer> {



    Optional<CategoryMetadataFields> findById(int integer);

    @Query("from CategoryMetadataFields")
   public List<CategoryMetadataFields> findallfields();
}
