package com.TTN.AmazonWebsite.DaoService;


import com.TTN.AmazonWebsite.EmailVerify.ConfirmationToken;
import com.TTN.AmazonWebsite.Repo.UserRepository;
import com.TTN.AmazonWebsite.EmailVerify.EmailSenderService;
import com.TTN.AmazonWebsite.Entity.User.User;
import com.TTN.AmazonWebsite.Repo.ConfirmationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ForgotPassword {

    String messagesent2,messagesent;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public String forgotPassword(String email){
        User user=userRepository.findByEmail(email).get();

        confirmationTokenRepository.deleteByUserId(user.getId());

        ConfirmationToken confirmationToken = new ConfirmationToken(user);
        confirmationTokenRepository.save(confirmationToken);
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);
        mailMessage.setSubject("Reset Password!");
        mailMessage.setFrom("ilyk2rock@gmail.com");
        mailMessage.setText("To Reset Password, please click here : "
                +"http://localhost:8080/confirmpassword?token="+confirmationToken.getConfirmationToken());

        emailSenderService.sendEmail(mailMessage);
        messagesent2="password link is sent";
        return messagesent2;
    }




    public String confrimPassword(String confirmationToken,String password){
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

        if(token != null)
        {
            User user = userRepository.findByEmail(token.getUser().getEmail()).get();
            user.setPassword(bCryptPasswordEncoder.encode(password));
            userRepository.save(user);
            messagesent="your passsword is changed";
        }
        else
        {
            messagesent=("message"+"The link is invalid or broken!");

        }

        return messagesent;
    }

}
