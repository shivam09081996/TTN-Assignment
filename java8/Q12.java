package lambdas;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

//Q12. Find the first even number in the integer list which is greater than 3.
public class Q12
{
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int n;
        try
        {
            n = obj.nextInt();
            for(int i=0; i< n; i++)
            {
                list.add(obj.nextInt());
            }

        }
        catch(NumberFormatException nf)
        {
            nf.printStackTrace();
        }
        catch(InputMismatchException im)
        {
            im.printStackTrace();
        }

        System.out.println(
                list
                .stream()
                .filter(e -> e%2 == 0)
                .findFirst()
        );
    }
}
