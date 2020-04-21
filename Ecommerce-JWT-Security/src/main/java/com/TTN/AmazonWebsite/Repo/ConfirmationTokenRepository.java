package com.TTN.AmazonWebsite.Repo;

import com.TTN.AmazonWebsite.EmailVerify.ConfirmationToken;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken, Integer> {
    ConfirmationToken findByConfirmationToken(String confirmationToken);


    @Transactional
    @Modifying
    @Query("delete from ConfirmationToken where user_id=:id")
    public void deleteByUserId(int  id);

}
