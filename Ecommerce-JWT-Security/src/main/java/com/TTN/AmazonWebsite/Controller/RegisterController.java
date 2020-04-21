package com.TTN.AmazonWebsite.Controller;

import com.TTN.AmazonWebsite.DaoService.RegisterDao;
import com.TTN.AmazonWebsite.Entity.User.Customer;
import com.TTN.AmazonWebsite.Entity.User.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController {

    @Autowired
    private RegisterDao registerDao;

    @RequestMapping(value="/register/customer", method = RequestMethod.POST)
    public String registerCustomerUser(@RequestBody Customer user)
    {
        return registerDao.registerCustomerUser(user);
    }


    @RequestMapping(value="/register/seller", method = RequestMethod.POST)
    public String registerSellerUser(@RequestBody Seller user)
    {
        return registerDao.registerSellerUser(user);
    }


    @RequestMapping(value="/activate", method= {RequestMethod.PUT})
    public String confirmUserAccount(@RequestParam("token")String confirmationToken)
    {
        return registerDao.confrimAccount(confirmationToken);
    }

    @PostMapping("/resendActivationlink")
    public String resendAccount(@RequestParam("email") String eamils){
        return registerDao.resendActivationToken(eamils);
    }

}
