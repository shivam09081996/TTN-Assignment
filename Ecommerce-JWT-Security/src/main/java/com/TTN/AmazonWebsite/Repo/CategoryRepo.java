package com.TTN.AmazonWebsite.Repo;

import com.TTN.AmazonWebsite.Entity.Product.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepo extends CrudRepository<Category,Integer> {


    Optional<Category> findById(int integer);

    @Query("from Category")
    public List<Category> findListOfCategory();
}
