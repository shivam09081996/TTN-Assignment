package collections;

/*
Aim:
Write a method that takes a string and returns the number of unique characters in the string.
*/

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Question2 {

    public static int getUniqueChars(String s){
        // count the unique characters from a string and return it.

        // because we want unique characers, so use set.
        Set<Character> charSet = new HashSet<>();

        for(int i=0; i<s.length(); i++){
            charSet.add(s.charAt(i));
        }

        return charSet.size();

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println(getUniqueChars(s));

        sc.close();
    }
}
