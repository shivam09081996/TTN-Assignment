package com.TTN.AmazonWebsite.Config;

import org.springframework.security.core.GrantedAuthority;

public class GrantAuthority implements GrantedAuthority {

    String authority;
    public GrantAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}