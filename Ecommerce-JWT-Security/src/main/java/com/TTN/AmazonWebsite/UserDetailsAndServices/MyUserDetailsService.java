package com.TTN.AmazonWebsite.UserDetailsAndServices;

import com.TTN.AmazonWebsite.Entity.User.User;
import com.TTN.AmazonWebsite.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepo;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user=userRepo.findByEmail(email);
        user.orElseThrow(()->new UsernameNotFoundException("User NOt Found"+email));
        return user.map(MyUserDetails::new).get();
    }


}
