package com.TTN.AmazonWebsite.Controller;

import com.TTN.AmazonWebsite.Entity.User.Address;
import com.TTN.AmazonWebsite.Entity.User.Customer;
import com.TTN.AmazonWebsite.DaoService.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class  CustomerController {

    @Autowired
    private CustomerDao customerDao;

    @GetMapping("/profile")
    public String DetailsProfile(){
       return customerDao.profileDetails();
    }

    @GetMapping("/address")
    public Set DetailsAddress(){
        return customerDao.viewAddress();
    }

    @PutMapping("/updateprofile")
    public String profileUpdate(@RequestBody Customer customer){
        return customerDao.updateProfile(customer);
    }

    @PutMapping("/updatepassword")
    public String passwordUpdate(@RequestParam("new")String newpass,@RequestParam("confirm")String confirmpass){
        return customerDao.updatePassword(newpass,confirmpass);
    }


    @PostMapping("/newaddress")
    public String Newaddress(@RequestBody Address address){
        return customerDao.newAddress(address);
    }



    @DeleteMapping("/deleteaddress")
    public String addressDeleted(@RequestParam("id")int id){
        return customerDao.deleteAddress(id);
    }

    @PutMapping("/updateaddress")
    public String Addressupdate(@RequestBody Address address){
        return customerDao.updateaddress(address);
    }


}
