package com.springframework.tr2demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Restaurant {

//    @Autowired
    private HotDrink hotDrink;


//  we don't require @Autowired in constructor injection. It happens automatically. But we may/ should apply
    @Autowired
    Restaurant(HotDrink hotDrink){
        System.out.println("constructor invoked");
        this.hotDrink = hotDrink;
    }

    public HotDrink getHotDrink() {
        System.out.println("getter invoked");
        return hotDrink;
    }

//    @Autowired
    public void setHotDrink(HotDrink hotDrink) {
        System.out.println("setter invoked");
           this.hotDrink = hotDrink;
    }
}
