package java2.Exc_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

//6. WAP showing try, multi-catch and finally blocks.

public class Q6
{
    public static void main(String[] args) throws Exception
    {

        try
        {
            File file = new File("file.txt");

            if (file.createNewFile())
            {
                System.out.println("File created: " + file.getName());
            }
            else
                System.out.println("File already exists.");

        }
        catch(FileNotFoundException fn)
        {
            fn.printStackTrace();
        }
        catch(IOException ioe)
        {
            System.out.println("IOException caught");
        }
        catch(Exception e)
        {
            System.out.println("Exception raised..");
        }

        finally
        {
            System.out.println("Try catch ended. Finally..");
        }
    }
}
