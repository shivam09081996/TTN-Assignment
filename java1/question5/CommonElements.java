package java1.question5;// Q5. Find common elements between two arrays.
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

class CommonElements {

        void common(int n1,int n2,int a1[],int a2[])
        {
                Arrays.sort(a1);
                Arrays.sort(a2);


                HashSet<Integer> s1=new HashSet<>();
                for(int i=0;i<n1;i++)
                {
                        for(int j=0;j<n2;j++)
                        {
                                if(a1[i]==a2[j])
                                {
                                        s1.add(a1[i]);
                                }
                        }
                }
                for(Integer number:s1)
                {
                        System.out.println(number);
                }
        }
        public static void main(String args[])
        {
                Scanner s =new Scanner(System.in);

                System.out.println("Enter no. of elements you want in array1:");
                int n1=s.nextInt();
                System.out.println("Enter no. of elements you want in array1:");
                int n2=s.nextInt();
                System.out.println("enter the elements of array1");
                int[] a1 = new int[n1];
                for(int i=0;i<n1;i++)
                {
                        a1[i] = s.nextInt();
                }
                System.out.println("enter the elements of array2");
                int[] a2 = new int[n2];
                for(int i=0;i<n2;i++)
                {
                        a2[i] = s.nextInt();
                }
                CommonElements d=new CommonElements();

                d.common(n1,n2,a1,a2);
        }
}
