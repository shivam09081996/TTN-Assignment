package java1.question3;

import java.util.Scanner;

// Q3. Write a program to find the number of occurrences of a character in a string without using loop?
class NumberOfOccurrences {
        void replace(String s1,String c)
        {

                int count=s1.length() - s1.replace(c, "").length();
                System.out.println(count);
        }
        public static void main(String args[])
        {
                Scanner s=new Scanner(System.in);
                System.out.println("Enter a string");
                String s1=s.nextLine();
                System.out.println("Enter a character");
                String c=s.nextLine();
                NumberOfOccurrences num=new NumberOfOccurrences();
                num.replace(s1,c);


        }
}

