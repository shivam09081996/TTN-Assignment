package com.TTN.AmazonWebsite.Entity.Product;

import com.TTN.AmazonWebsite.Entity.Order.Cart;

import javax.persistence.*;

@Entity
public class ProductVariation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int quantityavailable;
    private int price;
    private String details;
    private String imagename;

    @OneToOne(mappedBy = "productVariationCart",cascade = CascadeType.ALL)
    private Cart variationCart;

    @ManyToOne(optional = true)
    @JoinColumn(name = "product_id")
    private Product product;

    public Cart getVariationCart() {
        return variationCart;
    }

    public void setVariationCart(Cart variationCart) {
        this.variationCart = variationCart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantityavailable() {
        return quantityavailable;
    }

    public void setQuantityavailable(int quantityavailable) {
        this.quantityavailable = quantityavailable;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
