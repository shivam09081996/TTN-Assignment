package com.TTN.AmazonWebsite.Repo;

import com.TTN.AmazonWebsite.Entity.Product.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<Product,Integer> {

}
