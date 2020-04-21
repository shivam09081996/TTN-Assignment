package com.TTN.AmazonWebsite.Entity.User;
import com.TTN.AmazonWebsite.Entity.Order.Cart;
import com.TTN.AmazonWebsite.Entity.Order.MyOrder;

import javax.persistence.*;

@Entity
@DiscriminatorValue("customer")
public class Customer extends User {

    public Customer() {
    }

    private int contact;


    @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Cart cart;

    @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private MyOrder myorder;

    public Customer(int contact) {
        this.contact = contact;
    }


    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public MyOrder getMyorder() {
        return myorder;
    }

    public void setMyorder(MyOrder myorder) {
        this.myorder = myorder;
    }
}
