package lambdas;

import java.util.InputMismatchException;
import java.util.Scanner;
//Question:
//Write the following a functional interface and implement it using lambda:
//(1) First number is greater than second number or not         Parameter (int ,int ) Return boolean
//(2) Increment the number by 1 and return incremented value    Parameter (int) Return int
//(3) Concatination of 2 string                                 Parameter (String , String ) Return (String)
//(4) Convert a string to uppercase and return .                Parameter (String) Return (String)

//for part 1
@FunctionalInterface
interface Compare
{
    boolean comp(int a, int b);
}

//part 2
@FunctionalInterface
interface Incrementor
{
    int increment(int n);
}

//part 3 of the question
@FunctionalInterface
interface Concatenator
{
    String join(String a, String b);
}

//part 4 of he question
@FunctionalInterface
interface CaseConvertor
{
    String toUpperCase(String s);
}

public class Q1
{

    public static void main(String[] args) {

        int n=0;
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter two numbers.");
        try
        {
            int a = obj.nextInt();
            int b = obj.nextInt();

            //Part 1. comparing two integers.

            Compare c = (x,y)-> x > y ? true:false;
            System.out.println("The greater element is: "+ c.comp(a,b));


            //Part 2. Increment number by one and return incremented value
            Incrementor inc = x-> x++;
            System.out.println(inc.increment(a));


            //Part 3. Concatenation of two Strings
            Concatenator con = (x,y) -> x+y;
            System.out.println(con.join("Rohit ", "Kapoor"));


            //Part 4.. Convert a String to UpperCase and Return.
            CaseConvertor convert = x -> x.toUpperCase();
            System.out.println(convert.toUpperCase("To The New"));

        }
        catch(NumberFormatException nf)
        {
            System.out.println("You might have entered a non-integer.");
            nf.printStackTrace();
        }
        catch(InputMismatchException im)
        {
            System.out.println("the token\n" +
                    " * retrieved does not match the pattern for the expected type");
            im.printStackTrace();
        }
        catch(NullPointerException np)
        {
            System.out.println("The string entered is null.");
            np.printStackTrace();
        }

    }

}
