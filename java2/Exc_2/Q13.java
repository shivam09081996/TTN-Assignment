package java2.Exc_2;//Q13. Create a custom exception that do not have any stack trace.

import java.util.Scanner;

class CustomException extends Exception
{
    CustomException(String s)
    {
        System.out.println(s);
        this.printStackTrace();
    }

    @Override
    public void printStackTrace()
    {
        //commented this code so no stack trace is found even if we try to print it.
        //super.printStackTrace();
    }
}


public class Q13
{
    public static void main(String[] args) throws CustomException {
        Scanner obj = new Scanner(System.in);
        //enter anything
        if(obj.next() != "-1")
        {
            throw new CustomException("This is my own exception");
        }
    }
}
