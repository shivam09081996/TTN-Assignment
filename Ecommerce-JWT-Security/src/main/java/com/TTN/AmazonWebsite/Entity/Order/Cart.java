package com.TTN.AmazonWebsite.Entity.Order;

import com.TTN.AmazonWebsite.Entity.User.Customer;
import com.TTN.AmazonWebsite.Entity.Product.ProductVariation;

import javax.persistence.*;



@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int quantity;

    @OneToOne(optional = true)
    @JoinColumn(name = "customer_user_id")
    private Customer customer;


    @OneToOne(optional = true)
    @JoinColumn(name = "product_variation_id")
    private ProductVariation productVariationCart;

    @OneToOne(mappedBy = "cart",cascade = CascadeType.ALL)
    private Order_Product order_product;

    public Order_Product getOrder_product() {
        return order_product;
    }

    public void setOrder_product(Order_Product order_product) {
        this.order_product = order_product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProductVariation getProductVariationCart() {
        return productVariationCart;
    }

    public void setProductVariationCart(ProductVariation productVariationCart) {
        this.productVariationCart = productVariationCart;
    }
}

