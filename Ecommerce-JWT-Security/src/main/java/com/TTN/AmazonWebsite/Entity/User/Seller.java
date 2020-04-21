package com.TTN.AmazonWebsite.Entity.User;

import com.TTN.AmazonWebsite.Entity.Product.Product;

import javax.persistence.*;
import java.util.Set;

@Entity
@DiscriminatorValue("seller")
public class Seller extends User {
    private int gst;
    private int company_contact;
    private String company_name;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "productseller",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Product> productsellerSet;

    public int getGst() {
        return gst;
    }
    public void setGst(int gst) {
        this.gst = gst;
    }

    public int getCompany_contact() {
        return company_contact;
    }

    public void setCompany_contact(int company_contact) {
        this.company_contact = company_contact;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Product> getProductsellerSet() {
        return productsellerSet;
    }

    public void setProductsellerSet(Set<Product> productsellerSet) {
        this.productsellerSet = productsellerSet;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "id=" + getId() +
                ", email='" + getEmail() + '\'' +
                ", first_name='" + getFirst_name() + '\'' +
                ", middle_name='" + getMiddle_name() + '\'' +
                ", last_name='" + getLast_name() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", deleted=" + isDeleted() +
                ", active=" + isActive() +
                ", isEnabled=" + isEnabled() +
                ", addresseSet=" + getAddresseSet() +
                ", roleSet=" + getRoleSet() +
                "gst=" + gst +
                ", company_contact=" + company_contact +
                ", company_name='" + company_name + '\'' +
                ", user=" + user +
                '}';
    }


}
