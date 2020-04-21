package com.TTN.AmazonWebsite.Repo;

import com.TTN.AmazonWebsite.Entity.User.Address;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface AddressRepo extends CrudRepository<Address,Integer> {

    @Transactional
    @Modifying
    @Query("delete from Address where user_id=:id")
       public void deleteAddress(int id);
}
