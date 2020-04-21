package com.TTN.AmazonWebsite.Entity.Product;

import com.TTN.AmazonWebsite.Entity.User.User;

import javax.persistence.*;

@Entity
public class ProductReview {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;

    private String review;


    private int rating;

    @OneToOne
    @JoinColumn(name = "custumerid")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;




    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
