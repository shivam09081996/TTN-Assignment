package com.TTN.AmazonWebsite.Entity.Order;

import javax.persistence.*;

@Entity
public class Order_Status {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne
    @JoinColumn(name = "order_product_id")
    private Order_Product order_product;

    private String from_status;
    private String to_status;

    private String transition_notes_comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order_Product getOrder_product() {
        return order_product;
    }

    public void setOrder_product(Order_Product order_product) {
        this.order_product = order_product;
    }

    public String getFrom_status() {
        return from_status;
    }

    public void setFrom_status(String from_status) {
        this.from_status = from_status;
    }

    public String getTo_status() {
        return to_status;
    }

    public void setTo_status(String to_status) {
        this.to_status = to_status;
    }

    public String getTransition_notes_comment() {
        return transition_notes_comment;
    }

    public void setTransition_notes_comment(String transition_notes_comment) {
        this.transition_notes_comment = transition_notes_comment;
    }
}
