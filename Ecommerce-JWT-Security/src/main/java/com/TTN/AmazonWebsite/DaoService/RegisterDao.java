package com.TTN.AmazonWebsite.DaoService;

import com.TTN.AmazonWebsite.EmailVerify.ConfirmationToken;
import com.TTN.AmazonWebsite.Entity.User.Customer;
import com.TTN.AmazonWebsite.Entity.User.Role;
import com.TTN.AmazonWebsite.Entity.User.Seller;
import com.TTN.AmazonWebsite.Entity.User.User;
import com.TTN.AmazonWebsite.Repo.ConfirmationTokenRepository;
import com.TTN.AmazonWebsite.Repo.RoleRepo;
import com.TTN.AmazonWebsite.Repo.UserRepository;
import com.TTN.AmazonWebsite.EmailVerify.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class RegisterDao{

    String messagesent2,messagesent;

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private RoleRepo roleRepo;


    public String registerCustomerUser(Customer user){

        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if(existingUser.isPresent())
        {
            messagesent2=("message"+"This email already exists!");

        }

        else
        {
            Role role=new Role();
            role.setAuthority("CUSTOMER");
            Set<User> userSet=new HashSet<>();
            userSet.add(user);
            role.setUsersSet(userSet);
            roleRepo.save(role);
             Set<Role> roleSet=new HashSet<>();
             roleSet.add(role);
             user.setRoleSet(roleSet);
             user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userRepository.save(user);

            ConfirmationToken confirmationToken = new ConfirmationToken(user);

            confirmationTokenRepository.save(confirmationToken);

            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(user.getEmail());
            mailMessage.setSubject("Complete Registration!");
            mailMessage.setFrom("ilyk2rock@gmail.com");
            mailMessage.setText("To confirm your account, please click here : "
                    +"http://localhost:8080/activate?token="+confirmationToken.getConfirmationToken());

            emailSenderService.sendEmail(mailMessage);

            messagesent2="Succesful registration";
        }

        return messagesent2;
    }

    public String confrimAccount(String confirmationToken){
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

        if(token != null)
        {
            User user = userRepository.findByEmail(token.getUser().getEmail()).get();
            user.setEnabled(true);
            userRepository.save(user);
            messagesent="you are activated";
        }
        else
        {
            messagesent=("message"+"The link is invalid or broken!");

        }

        return messagesent;
    }


    public String resendActivationToken(String email){

        User user=userRepository.findByEmail(email).get();

        confirmationTokenRepository.deleteByUserId(user.getId());

        ConfirmationToken confirmationToken = new ConfirmationToken(user);
        confirmationTokenRepository.save(confirmationToken);
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);
        mailMessage.setSubject("Complete Registration!");
        mailMessage.setFrom("ilyk2rock@gmail.com");
        mailMessage.setText("To confirm your account, please click here : "
                +"http://localhost:8080/activate?token="+confirmationToken.getConfirmationToken());

        emailSenderService.sendEmail(mailMessage);
        messagesent2="new Activation token is sent";
        return messagesent2;
    }

    public String registerSellerUser(Seller user){

        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if(existingUser.isPresent())
        {
            messagesent2=("message"+"This email already exists!");

        }

        else
        {
            Role role=new Role();
            role.setAuthority("SELLER");
            Set<User> userSet=new HashSet<>();
            userSet.add(user);
            role.setUsersSet(userSet);
            roleRepo.save(role);
            Set<Role> roleSet=new HashSet<>();
            roleSet.add(role);
            user.setRoleSet(roleSet);
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userRepository.save(user);

            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(user.getEmail());
            mailMessage.setSubject("Account Registration!");
            mailMessage.setFrom("ilyk2rock@gmail.com");
            mailMessage.setText("your accounnt has been created  waiting for approval");
            emailSenderService.sendEmail(mailMessage);
            messagesent2="Succesful registration";
        }

           return messagesent2;
    }




}
