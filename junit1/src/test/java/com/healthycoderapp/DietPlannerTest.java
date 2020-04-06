package com.healthycoderapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DietPlannerTest {

    private DietPlanner dietPlanner;

    @BeforeEach
    void setup(){
        this.dietPlanner=new DietPlanner(20,30,50);
    }
    @AfterEach
    void aftereach(){
        System.out.println("A unit test is finished");
    }



    @Test
        //given
    void  should_returnCorrectDietplan_when_correctCoder(){
        Coder coder=new Coder(1.82,75.0,26,Gender.MALE);
        DietPlan expected=new DietPlan(2202,110,73,275);

        //when
        DietPlan actual=dietPlanner.calculateDiet(coder);

        //then
        Assertions.assertAll(
                ()->assertEquals(expected.getCalories(),actual.getCalories()),
                ()->assertEquals(expected.getProtein(),actual.getProtein()),
                ()->assertEquals(expected.getFat(),actual.getFat()),
                ()->assertEquals(expected.getCarbohydrate(),actual.getCarbohydrate())
        );



    }
}