package com.TTN.AmazonWebsite.Entity.Order;

import com.TTN.AmazonWebsite.EnumOrderStatus.Fromstatus;

import javax.persistence.*;
@Entity
public class Order_Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @OneToOne(mappedBy = "order_product",cascade = CascadeType.ALL)
    private Order_Status order_status;

    @OneToOne(optional = true)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne(optional = false)
    @JoinColumn(name = "order_id")
    private MyOrder myOrder;


    @Enumerated(EnumType.STRING)
    private Fromstatus status;

    public MyOrder getMyOrder() {
        return myOrder;
    }

    public void setMyOrder(MyOrder myOrder) {
        this.myOrder = myOrder;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Order_Status getOrder_status() {
        return order_status;
    }

    public void setOrder_status(Order_Status order_status) {
        this.order_status = order_status;
    }

    public Fromstatus getStatus() {
        return status;
    }

    public void setStatus(Fromstatus status) {
        this.status = status;
    }
}
