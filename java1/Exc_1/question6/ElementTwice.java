package java1.Exc_1.question6;

import java.util.Scanner;

// Q6. There is an array with every element repeated twice except one. Find that element
 class ElementTwice {

         void twice(int a1[],int n1)
         {
                 int output=a1[0];
                 for(int i=1;i<n1;i++)
                 {
                         output = output ^ a1[i];
                 }
                 System.out.println(output);
         }
        public static void main(String[] args) {
                Scanner s=new Scanner(System.in);

                System.out.println("Enter no. of elements:");
                int n1=s.nextInt();
                System.out.println("Enter the elements of array");
                int[] a1 = new int[n1];
                for(int i=0;i<n1;i++)
                {
                        a1[i] = s.nextInt();
                }

                ElementTwice e=new ElementTwice();
                e.twice(a1,n1);
        }
}
