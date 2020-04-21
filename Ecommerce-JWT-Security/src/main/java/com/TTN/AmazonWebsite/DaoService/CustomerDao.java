package com.TTN.AmazonWebsite.DaoService;

import com.TTN.AmazonWebsite.Entity.User.Address;
import com.TTN.AmazonWebsite.Entity.User.Customer;
import com.TTN.AmazonWebsite.Repo.AddressRepo;
import com.TTN.AmazonWebsite.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CustomerDao {


    String message;
    @Autowired
    DefaultTokenServices tokenServices;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public String profileDetails(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email= (String) auth.getPrincipal();
        Customer customer= (Customer) userRepository.findByEmail(email).get();
       String details= "Id  :"+customer.getId()
               +"\n"+ "First Name  :"+customer.getFirst_name()
        +"\n"+"Last  Name  :"+customer.getLast_name()
        +"\n"+ "Contact info  :"+customer.getContact()
        +"\n"+"Image Name  :"+customer.getImageName()
        +"\n"+"Active Status  :"+customer.isActive();

       return details;
    }

     public Set viewAddress(){
         Authentication auth = SecurityContextHolder.getContext().getAuthentication();
         String email=(String)auth.getPrincipal();
        Customer customer=(Customer)userRepository.findByEmail(email).get();
        return customer.getAddresseSet() ;
        }

        public String updateProfile(Customer user){
           userRepository.save(user);
         return "Success";
        }


        public String updatePassword(String newpassword,String confirmpassword) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String email = (String) auth.getPrincipal();
            Customer customer = (Customer) userRepository.findByEmail(email).get();

            if (newpassword.equals(confirmpassword)) {
                customer.setPassword(bCryptPasswordEncoder.encode(confirmpassword));
                userRepository.save(customer);
                message = "your password is updated";
            } else
                message = "password mismatch";

            return message;
           }


           public String newAddress(Address address){
               Authentication auth = SecurityContextHolder.getContext().getAuthentication();
               String email = (String) auth.getPrincipal();
               Customer customer = (Customer) userRepository.findByEmail(email).get();
               address.setUser(customer);
               addressRepo.save(address);
               return "new Address updated";
               }


               public String deleteAddress(int id){
                addressRepo.deleteAddress(id);
                return "address deleted";
               }


               public String updateaddress(Address address){
                  addressRepo.save(address);
                  return "Address updated";
               }


}
