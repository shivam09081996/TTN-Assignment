package com.TTN.AmazonWebsite.Repo;


import com.TTN.AmazonWebsite.Entity.User.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends CrudRepository<User,Integer> {

    Optional<User> findByEmail(String name);

    @Query("from User where user_type='CUSTOMER'")
    public List<User> findAllCustomer();


    @Query("from User where user_type='SELLER'")
    public List<User> findAllSeller();


    public Optional<User> findById(int id);







}
