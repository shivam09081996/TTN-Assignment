package java1.question8;// Q8. Write a program to reverse a string and remove character from index 4 to index 9 from the reversed string using String Buffer

import java.util.Scanner;

class ReverseAndRemove {
        public static void main(String[] args) {
                Scanner s1 =new Scanner(System.in);
                System.out.println("Enter a string");
                String s=s1.nextLine();
                StringBuffer input = new StringBuffer(s);
                input = input.reverse();
                input = input.delete(4,9);
                System.out.println(input);
        }
}
