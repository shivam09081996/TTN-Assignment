package com.example.jpaSqlSecurityWeb.UserRepo;

import com.example.jpaSqlSecurityWeb.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepo extends CrudRepository<User,Integer> {

      Optional<User> findByUserName(String userName);
}
