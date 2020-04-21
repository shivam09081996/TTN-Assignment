package com.TTN.AmazonWebsite.DaoService;

import com.TTN.AmazonWebsite.Entity.User.Address;
import com.TTN.AmazonWebsite.Entity.User.Seller;
import com.TTN.AmazonWebsite.Repo.AddressRepo;
import com.TTN.AmazonWebsite.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SellerDao {

    String message;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private AddressRepo addressRepo;

    public Seller viewProfileSeller(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email= (String) auth.getPrincipal();
        Seller seller= (Seller) userRepository.findByEmail(email).get();
        return seller;
    }

    public String updateProfile(Seller user){
        userRepository.save(user);
        return "Success";
    }

    public String updatePassword(String newpassword,String confirmpassword) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = (String) auth.getPrincipal();
        Seller seller = (Seller) userRepository.findByEmail(email).get();

        if (newpassword.equals(confirmpassword)) {
            seller.setPassword(bCryptPasswordEncoder.encode(confirmpassword));
            userRepository.save(seller);
            message = "your password is updated";
        } else
            message = "password mismatch";

        return message;
    }

    public String updateaddress(Address address){
        addressRepo.save(address);
        return "Address updated";
    }

}
