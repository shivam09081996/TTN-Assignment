package java1.question2;

import java.util.*;

        public class DuplicateWords {

        void duplicate(String s1)
        {

        String arr[] = s1.split(" ");
        Map<String,Integer> m=new HashMap<>();
        for (String s : arr) {
        Integer count=m.get(s);
        if(count==null)
        {
        m.put(s,1);

        }
        else
        {
        count++;
        m.put(s,count);
        }
        }
        Set<Map.Entry<String,Integer>> es=m.entrySet();
        for(Map.Entry<String,Integer> me:es)
        {
        if(me.getValue()>1)
        {
        System.out.println(me.getKey());
        }
        }
        }

        public static void main(String[] args) {
        // your code goes here
        Scanner s= new Scanner(System.in);
        System.out.println("Enter a string");
        String s1=s.nextLine();
        DuplicateWords d=new DuplicateWords();
        d.duplicate(s1);

        }
        }




