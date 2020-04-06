package com.im;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FirstTest {


    First first=new First();
    @Test
    void should_return_replaced_String(){
        //given
        String mainString="shivam";
        String subString="shi";
        String replacementString="top";

        //when
        String actual=first.replaceSubString(mainString,subString,replacementString);
        String expected="topvam";

        //Then
        assertEquals(expected,actual);
    }

    @Test
    void should_return_main_String(){
        //given
        String mainString="shivam";
        String subString=null;
        String replacementString="top";

        //when
        String actual=first.replaceSubString(mainString,subString,replacementString);
        String expected="shivam";

        //Then
        assertEquals(expected,actual);
    }
    @Test
    void should_return_odd_list(){
        List<Integer> list=new ArrayList<>();
        //Given
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        //when
        List<Integer> actual=first.filterEvenElements(list);

        //then
        List<Integer> expected= Arrays.asList(1,3);
        assertEquals(expected,actual);

    }




    //this test case will fail  because we expected even number in list and it return only odd number
    @Test

    void should_return_Even_list_Check(){
        List<Integer> list2=new ArrayList<>();
        //Given
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);

        //when
        List<Integer> actual=first.filterEvenElements(list2);

        //then
        List<Integer> expected= Arrays.asList(2,4);
        assertEquals(expected,actual);

    }


    @Test
    public void should_Calculate_Corect_Average(){
//given
        List<BigDecimal> list=new ArrayList<>();
        list.add(BigDecimal.valueOf(1));
        list.add(BigDecimal.valueOf(2));
        list.add(BigDecimal.valueOf(3));
        list.add(BigDecimal.valueOf(4));
        list.add(BigDecimal.valueOf(5));


//when
        BigDecimal actual = first.calculateAverage(list);
        BigDecimal expected = new BigDecimal(3);
//then
        assertEquals(expected,actual);
    }
    @Test
    public void should_return_true_isPallindrome( ){
//given
        String str = "aba";
//when
        boolean output = first.isPallindrome(str);
//then

        assertTrue(output);
    }


}