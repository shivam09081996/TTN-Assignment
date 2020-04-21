package com.TTN.AmazonWebsite.Entity.Order;

import com.TTN.AmazonWebsite.Entity.User.Customer;

import javax.persistence.*;
import java.util.Set;

@Entity
public class MyOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int amount_paid;

    private String paymentMethod;

    @OneToOne
    @JoinColumn(name="user_id")
    private Customer customer;


    @OneToMany(mappedBy = "myOrder",cascade = CascadeType.ALL)
    private Set<Order_Product> order_productsSet;


    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Set<Order_Product> getOrder_productsSet() {
        return order_productsSet;
    }

    public void setOrder_productsSet(Set<Order_Product> order_productsSet) {
        this.order_productsSet = order_productsSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount_paid() {
        return amount_paid;
    }

    public void setAmount_paid(int amount_paid) {
        this.amount_paid = amount_paid;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
