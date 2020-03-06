package com.springframework.tr2demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Tea implements HotDrink{

    @Override
    public void prepareDrink() {
        System.out.println("Preparing Tea");
    }
}
