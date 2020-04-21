package com.TTN.AmazonWebsite.Entity.Product;

import com.TTN.AmazonWebsite.Entity.User.Seller;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String cancellable;
    private String returnable;
    private String brand;
    private boolean active;

    @ManyToOne(optional = true)
    @JoinColumn(name = "user_seller_id")
    private Seller productseller;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy ="product",cascade = CascadeType.ALL)
    private Set<ProductVariation> productVariationSet;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    public Set<ProductReview> productReviewSet;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Set<ProductVariation> getProductVariationSet() {
        return productVariationSet;
    }

    public void setProductVariationSet(Set<ProductVariation> productVariationSet) {
        this.productVariationSet = productVariationSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Seller getProductseller() {
        return productseller;
    }

    public void setProductseller(Seller productseller) {
        this.productseller = productseller;
    }

    public Set<ProductReview> getProductReviewSet() {
        return productReviewSet;
    }

    public void setProductReviewSet(Set<ProductReview> productReviewSet) {
        this.productReviewSet = productReviewSet;
    }

    public String getCancellable() {
        return cancellable;
    }

    public void setCancellable(String cancellable) {
        this.cancellable = cancellable;
    }

    public String getReturnable() {
        return returnable;
    }

    public void setReturnable(String returnable) {
        this.returnable = returnable;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
