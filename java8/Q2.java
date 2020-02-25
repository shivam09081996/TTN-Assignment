package lambdas;

import java.util.InputMismatchException;
import java.util.Scanner;

//Q2
//Create a functional interface whose method takes 2 integers and return one integer.
@FunctionalInterface
interface Adder
{
    int add(int a, int b);
}

public class Q2
{
    public static void main(String[] args) {

        int a = 0, b = 0;
        Scanner obj = new Scanner((System.in));
        try
        {
            a = obj.nextInt();
            b = obj.nextInt();
            Adder A = (x,y)-> y;
            int z= A.add(a,b);
            System.out.println(z);

        }
        catch(NumberFormatException nf)
        {
            System.out.println("You might have entered a non-integer.");
            nf.printStackTrace();
        }
        catch (InputMismatchException im)
        {
            System.out.println("the token\n" +
                    " * retrieved does not match the pattern for the expected type");
            im.printStackTrace();
        }

    }
}
