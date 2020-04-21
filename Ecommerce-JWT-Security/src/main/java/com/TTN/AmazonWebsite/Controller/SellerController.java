package com.TTN.AmazonWebsite.Controller;

import com.TTN.AmazonWebsite.Entity.User.Address;
import com.TTN.AmazonWebsite.Entity.User.Seller;
import com.TTN.AmazonWebsite.DaoService.SellerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SellerController {
    @Autowired
    private SellerDao sellerDao;


    @GetMapping("/sellerprofile")
    public Seller viewProfile(){
       return sellerDao.viewProfileSeller();
    }


    @PutMapping("/updatesellerprofile")
    public String updateSellerProfile(@RequestBody Seller seller){
        return sellerDao.updateProfile(seller);
    }


    @PutMapping("/updateSellerpassword")
    public String updatepassword(@RequestParam("new") String newpassword,@RequestParam("confirm") String confirmpassword){
        return sellerDao.updatePassword(newpassword,confirmpassword);
    }


    @PutMapping("/updateSellerAddress")
    public String updateAddress(@RequestBody Address address){
        return sellerDao.updateaddress(address);
    }

}
