package java1.Exc_1.question1;//Q1. Write a program to replace a substring inside a string with other string ?

import java.util.Scanner;

public class Replace
{
    void replaceString(String s1,String s2, String s3)
    {
        String s4 = s1.replace(s2,s3);
        System.out.println(s4);

    }
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter a string");
        String s1=s.nextLine();
        System.out.println("Enter a substring to be replace");
        String s2=s.nextLine();
        System.out.println("Enter a substring to be replace with");
        String s3=s.nextLine();

        Replace r=new Replace();

        r.replaceString(s1,s2,s3);
    }

}
