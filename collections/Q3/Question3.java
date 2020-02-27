package collections;


/*
Aim: Write a method that takes a string and print the number of occurrence of each character
     characters in the string.
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Question3 {

    public static void uniqueCharCount(String s){

        // unique characters as the key, count as value.
        Map<Character, Integer> charMap = new HashMap<>();

        for(int i=0; i<s.length(); i++){

            Character ch = s.charAt(i);

            // if char exists, increment the count
            if(charMap.containsKey(ch)){
                Integer value = charMap.get(ch);
                value++;
                charMap.replace(ch, value);
            }
            // else insert into the map
            else
                charMap.put(s.charAt(i), 1);
        }

        System.out.println(charMap);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        uniqueCharCount(s);

        sc.close();

    }
}
