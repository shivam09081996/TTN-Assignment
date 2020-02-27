package java2.Exc_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

//2. WAP to sorting string without using string Methods?.
public class Q2
{
    //

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a word");
        String sentence = input.nextLine();

        char c[] = sentence.toCharArray();
        Arrays.sort(c);
        String output = new String(c);
        System.out.println(output);
    }
}
