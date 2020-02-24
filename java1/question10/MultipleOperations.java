package java1.question10;/*Q10.Write a single program for following operation using overloading
        A) Adding 2 integer number
        B) Adding 2 double
        C) multiplying 2 float
        D) multiplying 2 int
        E) concate 2 string
        F) Concate 3 String*/

import java.util.Scanner;

class MultipleOperations {
        public static void main(String[] args) {



                Scanner s=new Scanner(System.in);
                System.out.println("A) Adding 2 integer number\n" +
                        "B) Adding 2 double\n" +
                        "C) multiplying 2 float\n" +
                        "D) multiplying 2 int\n" +
                        "E) concate 2 string\n" +
                        "F) Concate 3 String");
                char ch = s.next().charAt(0);


                        switch(ch)
                {
                        case 'A':
                                System.out.println("Enter two numbers");
                                 int a=s.nextInt();
                                 int b=s.nextInt();
                                addinteger(a,b);

                                break;
                        case 'B':
                                System.out.println("Enter two numbers");
                                double c=s.nextDouble();
                                double d=s.nextDouble();
                                adddouble(c,d);
                                break;
                        case 'C':
                                System.out.println("Enter two numbers");
                                float e=s.nextFloat();
                                float f=s.nextFloat();
                                Multiplyfloat(e,f);
                                break;
                        case 'D':
                                System.out.println("Enter two numbers");
                                int g=s.nextInt();
                                int h=s.nextInt();
                                Multiplyint(g,h);
                                break;
                        case 'E':
                                System.out.println("Enter two numbers");
                                String ab=s.nextLine();
                                String ba=s.nextLine();
                                conCat2(ab,ba);
                                break;
                        case 'F':
                                System.out.println("Enter two numbers");
                                String abc=s.nextLine();
                                String bac=s.nextLine();
                                String aa =s.nextLine();
                                conCat3(abc,bac,aa);
                                break;

                }
        }

        public static void addinteger(int a, int b)
        {
                System.out.println(a+b);
        }
        public static void adddouble(double a, double b)
        {
                System.out.println(a+b);
        }
        public static void Multiplyfloat(float a, float b)
        {
                System.out.println(a*b);
        }
        public static void Multiplyint(int a, int b)
        {
                System.out.println(a*b);
        }
        public static void conCat2(String a, String b)
        {
                System.out.println(a.concat(b));
        }
        public static void conCat3(String a, String b, String c)
        {
                System.out.println((a.concat(b)).concat(c));
        }
}
