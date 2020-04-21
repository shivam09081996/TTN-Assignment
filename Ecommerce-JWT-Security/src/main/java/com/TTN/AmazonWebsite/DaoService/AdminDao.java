package com.TTN.AmazonWebsite.DaoService;

import com.TTN.AmazonWebsite.Entity.User.User;
import com.TTN.AmazonWebsite.Repo.ConfirmationTokenRepository;
import com.TTN.AmazonWebsite.Repo.UserRepository;
import com.TTN.AmazonWebsite.EmailVerify.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdminDao {

    String messagesent2,messagesent;

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public List<User> findCustomers(){
        List<User> userList=userRepository.findAllCustomer();
        return userList;
    }

    public List<User> findSeller(){
        List<User> userList=userRepository.findAllSeller();
        return userList;
    }

    public String ActivateUser(int id){

        User user=userRepository.findById(id).get();
        if(user!=null)
        {
            user.setActive(true);
            userRepository.save(user);
            messagesent="user is activated";
        }

        else
            messagesent="user not  found";

        return messagesent;
    }

    public String DeActivateUser(int id){

        User user=userRepository.findById(id).get();
        if(user!=null)
        {
            user.setActive(false);
            userRepository.save(user);
            messagesent="user is DeActivated";
        }

        else
            messagesent="user not  found";

        return messagesent;
    }
}
