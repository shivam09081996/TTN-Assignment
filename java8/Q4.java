package lambdas;

//Create an Employee Class with instance variables (String) name, (Integer)age, (String)city
// and get the instance of the Class using constructor reference
interface Employable
{
    Employee details(String s, int a, String c);
}

class Employee
{
    String name;
    int age;
    String city;

    Employee(String s, int a, String c)
    {
        name = s;
        age = a;
        city = c;
    }

    String getDetails()
    {
        return this.name+" "+this.age+" "+this.city;
    }
}

public class Q4
{
    public static void main(String[] args) {

        Employable emp = Employee::new;

        //this is the default technique we apply
        /*Employee e1 = new Employee("Rohit", 22, "Chandigarh");
        Employee e2 = new Employee("Naveen", 25, "New Delhi");
        */

        //here we are using constructor reference, in that we are calling a method of the interface
        //that is compatible with the constructor type defined in Employee class
        Employee e3 = emp.details("Rohit", 22, "Chandigarh");
        Employee e4 = emp.details("Naveen", 25, "New Delhi");

        System.out.println(e4.getDetails());
        System.out.println(e3.getDetails());

    }
}
