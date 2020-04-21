package com.TTN.AmazonWebsite.Config;

import com.TTN.AmazonWebsite.UserDetailsAndServices.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Autowired
    MyUserDetailsService userDetailsService;

    public ResourceServerConfiguration() {
        super();
    }

    @Bean
    public static BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public AuthenticationProvider authenticationProvider() {
        final DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
        return authenticationProvider;
    }

    @Autowired
    public void configureGlobal(final AuthenticationManagerBuilder authenticationManagerBuilder) {
        authenticationManagerBuilder.authenticationProvider(authenticationProvider());
    }

    @Override
    public void configure(final HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").anonymous()
                .antMatchers("/activate").permitAll()
                .antMatchers("/redendActivationlink").permitAll()
                .antMatchers("/register/customer").permitAll()
                .antMatchers("/register/seller").permitAll()
                .antMatchers("/forgotpassword").permitAll()
                .antMatchers("/confirmpassword").permitAll()



              /*  .antMatchers("/profile").permitAll()
                .antMatchers("/address").permitAll()
                .antMatchers("/updateprofile").permitAll()
                .antMatchers("/updatepassword").permitAll()
                .antMatchers("/newaddress").permitAll()
                .antMatchers("/deleteaddress").permitAll()
                .antMatchers("/updateaddress").permitAll()
                .antMatchers("/sellerprofile").permitAll()
                .antMatchers("/updateSellerpassword").permitAll()
                .antMatchers("/updatesellerprofile").permitAll()
                .antMatchers("/updateSellerAddress").permitAll()
                .antMatchers("/search_all_seller").permitAll()
                .antMatchers("/search_all_customer").permitAll()
                .antMatchers("/activateByAdmin").permitAll()
                .antMatchers("/deActivateByAdmin").permitAll()
                .antMatchers("/addmetadata").permitAll()
                .antMatchers("/findallmetadata").permitAll()
                .antMatchers("/addcategory").permitAll()*/








                .antMatchers("/profile").hasRole("CUSTOMER")
                .antMatchers("/address").hasRole("CUSTOMER")
                .antMatchers("/updateprofile").hasRole("CUSTOMER")
                .antMatchers("/updatepassword").hasRole("CUSTOMER")
                .antMatchers("/newaddress").hasRole("CUSTOMER")
                .antMatchers("/deleteaddress").hasRole("CUSTOMER")
                .antMatchers("/updateaddress").hasRole("CUSTOMER")
                .antMatchers("/sellerprofile").hasRole("SELLER")
                .antMatchers("/updateSellerpassword").hasRole("SELLER")
                .antMatchers("/updatesellerprofile").hasRole("SELLER")
                .antMatchers("/updateSellerAddress").hasRole("SELLER")
                .antMatchers("/search_all_seller").hasRole("ADMIN")
                .antMatchers("/search_all_customer").permitAll()
                .antMatchers("/activateByAdmin").hasRole("ADMIN")
                .antMatchers("/deActivateByAdmin").hasRole("ADMIN")
                .antMatchers("/addmetadata").permitAll()
                .antMatchers("/findallmetadata").permitAll()
                .antMatchers("/addcategory").permitAll()


                .antMatchers("/categoryfindByid").hasAnyRole("ADMIN","CUSTOMER","SELLER")
                .antMatchers("/listofcategory").hasAnyRole("ADMIN","CUSTOMER","SELLER")
                .antMatchers("/updatecategory").permitAll()
                .antMatchers("/metadataforcategory").permitAll()
                .antMatchers("/updatevaluesforfield").permitAll()

                .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);


    }
}