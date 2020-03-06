package java1.question4;// Q4. Calculate the number & Percentage Of Lowercase Letters,Uppercase Letters, Digits And Other Special Characters In A String

import java.util.Scanner;

class Number {

        void num(String input)
        {
                int lowerCase=0,upperCase=0,specialChar=0,digits=0;
                int length = input.length();
                for(int i=0;i<length;i++)
                {
                        char ch = input.charAt(i);
                        if((int)ch>=97 && (int)ch<=122)lowerCase+=1;
                        else if((int)ch>=65 && (int)ch<=90)upperCase+=1;
                        else if((int)ch>=48 && (int)ch<=57)digits+=1;
                        else if(ch!=' ')specialChar+=1;

                }
                double lo;
                System.out.println("Lower case characters are : "+lowerCase);
                System.out.println("Upper case characters are : "+upperCase);
                System.out.println("Digits are : "+digits);
                System.out.println("Special characters are : "+specialChar);
                System.out.println("Percentage of Lower case characters are : "+ (lowerCase *100.0/length));
                System.out.println("Percentage of Upper case characters are : "+ (upperCase *100.0/length));
                System.out.println("Percentage of Digits are : "+ (digits *100.0/length));
                System.out.println("Percentage of Special characters are : "+ (specialChar *100.0 /length));
        }

        public static void main (String[] args)
        {
                // your code goes here
                Scanner s= new Scanner(System.in);
                System.out.println("Enter a string");
                String input=s.nextLine();
                Number n=new Number();
                n.num(input);

        }
}

