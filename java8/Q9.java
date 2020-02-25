package lambdas;

import java.util.*;
import java.util.stream.Collectors;

//Q9. Collect all the even numbers from an integer list.
public class Q9
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
                list.stream()
                    .filter(e-> e%2 == 0)
                    .collect(Collectors.toList())
        );
    }
}
