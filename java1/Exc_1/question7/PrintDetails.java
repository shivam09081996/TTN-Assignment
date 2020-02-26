package java1.Exc_1.question7;

// Q7. Write a program to print your Firstname,LastName & age using static block,static method & static variable respectively
 class PrintDetails {
        static{
                String fname="Shivam";


                System.out.println("first name is "+fname);


        }
        static int age =21;
        public static void lname(String name)
        {
                System.out.println("last name is "+name);
        }

        public static void main(String[] args) {
                PrintDetails.lname("Garg");
                System.out.println("Age is "+PrintDetails.age);
        }


}
