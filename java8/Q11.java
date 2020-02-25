package lambdas;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

//Q11. Find average of the number inside integer list after doubling it.
public class Q11
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
                .map(e -> e*2)
                .mapToInt(Integer::intValue)
                .average()
        );
    }
}
