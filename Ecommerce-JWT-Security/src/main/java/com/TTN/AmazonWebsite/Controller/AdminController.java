package com.TTN.AmazonWebsite.Controller;

import com.TTN.AmazonWebsite.DaoService.AdminDao;
import com.TTN.AmazonWebsite.Entity.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private AdminDao adminDao;

    @GetMapping("/all_customers")
    public List<User> find_Customer(){
        return adminDao.findCustomers();
    }



    @GetMapping("/all_sellers")
    public List<User> find_Seller(){
        return adminDao.findSeller();
    }


    @PostMapping("/activateByAdmin")
    public String Activate(@RequestParam("id")int id){
        return adminDao.ActivateUser(id);
    }

    @PostMapping("/deActivateByAdmin")
    public String DeActivate(@RequestParam("id")int id){
        return adminDao.DeActivateUser(id);
    }

}
