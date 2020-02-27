package collections;

/*
AIM -
Write Java code to define List . Insert 5 floating point numbers in List, and using an iterator,
find the sum of the numbers in List.
*/

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Question1{

    public static void main(String[] args) {

        List<Float> list = new ArrayList<>();
        Scanner inputFloat=new Scanner(System.in);
        System.out.println("Enter 5 float numbers");

        for(int i=0;i<5;i++)

        {
            float number=inputFloat.nextFloat();
            list.add(number); // filling list

        }



        Iterator<Float> it = list.iterator();
        Float sum = 0f;  list.add(1.112f);

        while(it.hasNext()){
            Float val = it.next();
//            System.out.println(val);
            sum+=val;
        }

        System.out.println("sum = " + sum);



    }
}
