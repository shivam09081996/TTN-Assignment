package java2.Exc_2;

import java.util.Scanner;

//7. WAP to convert seconds into days, hours, minutes and seconds.
public class Q7
{
    public static void main(String[] args)
    {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter seconds to convert into days,hours,minutes");
        long secs = obj.nextLong();

        System.out.println("Seconds converted into days -->");
        System.out.println((secs/3600)/24);

        System.out.println("Seconds converted into hours -->");
        System.out.println(secs/3600);

        int min_rem=0;
        System.out.println("Seconds converted into minutes and seconds -->");
        if(secs % 60 != 0)
            min_rem = (int)secs%60;

        System.out.println(secs/60 + " minutes and " + min_rem + " seconds.");

    }
}
