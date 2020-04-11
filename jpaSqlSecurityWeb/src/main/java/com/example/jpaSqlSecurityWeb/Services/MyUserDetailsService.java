package com.example.jpaSqlSecurityWeb.Services;

import com.example.jpaSqlSecurityWeb.Entity.MyUserDetails;
import com.example.jpaSqlSecurityWeb.Entity.User;
import com.example.jpaSqlSecurityWeb.UserRepo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {


    @Autowired
    UserRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user=userRepo.findByUserName(username);
        user.orElseThrow(()->new UsernameNotFoundException("User NOt Found"+username));
        return user.map(MyUserDetails::new).get();
    }
}
