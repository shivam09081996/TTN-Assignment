package lambdas;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//Q10. Sum all the numbers greater than 5 in the integer list.
public class Q10
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
                    .filter(e -> e > 5)
                    .mapToInt(Integer::valueOf).sum()
        );
    }
}
