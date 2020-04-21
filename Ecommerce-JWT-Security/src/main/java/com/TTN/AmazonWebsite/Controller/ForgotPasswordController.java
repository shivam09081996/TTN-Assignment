package com.TTN.AmazonWebsite.Controller;

import com.TTN.AmazonWebsite.DaoService.ForgotPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForgotPasswordController {
    @Autowired
    private ForgotPassword forgotPassword;

    @PostMapping("/forgotpassword")
    public String resetPass(@RequestParam("email") String email){
        return forgotPassword.forgotPassword(email);
    }

    @PostMapping("/confirmpassword")
    public String confirmPass(@RequestParam("token") String token,@RequestParam("password") String password){
        return forgotPassword.confrimPassword(token,password);
    }
}
