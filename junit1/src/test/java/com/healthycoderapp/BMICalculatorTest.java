package com.healthycoderapp;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BMICalculatorTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("before all");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("after all");
    }

    @Test
    void Should_ReturnTrue_when_Diet_is_Recomanded(){
        //given
        double weight=89.0;
        double height=1.50;

        //when
        boolean recommended=BMICalculator.isDietRecommended(weight,height);

        //then
        assertTrue(recommended);
    }

    @Test
    void Should_ReturnFalse_when_Diet_is_Recomanded(){
        //given
        double weight=50.0;
        double height=1.50;

        //when
        boolean recommended=BMICalculator.isDietRecommended(weight,height);

        //then
        assertFalse(recommended);
    }
    @Test
    void Should_Return_ArethmeticException_when_Height_is_zero(){
        //given
        double weight=50.0;
        double height=0.0;

        //when
        Executable executable= ()->BMICalculator.isDietRecommended(weight,height);

        //then
        assertThrows(ArithmeticException.class,executable);
    }

    @Test
    void Should_Return_CoderWithWorstBMI(){
        //given
        List<Coder> coders=new ArrayList<>();
        coders.add(new Coder(1.80,60.0));
        coders.add(new Coder(1.82,98.0));
        coders.add(new Coder(1.82,64.7));

        //when
        Coder coderWorstBMI=BMICalculator.findCoderWithWorstBMI(coders);
        //then
        assertAll(
                ()->assertEquals(1.82,coderWorstBMI.getHeight()),
                ()->assertEquals(98.0,coderWorstBMI.getWeight())

        );
    }

    @Test
    void Should_Return_Null_CoderWithWorstBMI_IsEmpty(){
        //given
        List<Coder> coders=new ArrayList<>();

        //when

        Coder coderWorstBMI=BMICalculator.findCoderWithWorstBMI(coders);
        //then

        assertNull(coderWorstBMI);
    }

    @Test
    void shouldReturnCorrectBMIScoreArrayWhenCoderListIsNotEmpty() {
        // given
        List<Coder> coders = new ArrayList<>();
        coders.add(new Coder(1.89, 60.0));
        coders.add(new Coder(1.82, 98.0));
        coders.add(new Coder(1.82, 64.7));
        double[] expected = {16.8,29.59,19.53};

        // when
        double[] bmiScores = BMICalculator.getBMIScores(coders);
        System.out.println("hello");
        for (double b : bmiScores) {
            System.out.println(b);
        }

        // then
        assertArrayEquals(expected,bmiScores);
    }
}