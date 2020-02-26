package collections;

/*
Aim : Write a program to sort Employee objects based on highest salary using Comparator.
Employee class{ Double Age; Double Salary; String Name
*/

import java.util.*;

class Employee{
    // data members
    double age;
    double salary;
    String name;

    // parameterised cTor
    Employee(double age, double salary, String name){
        this.age = age;
        this.salary = salary;
        this.name = name;
    }

    double getSalary(){
        return this.salary;
    }

    String print(){
        return name + " " + age + " " + salary;
    }

}

// custom comparator
class myCompare implements Comparator<Employee>{

    public int compare(Employee a, Employee b){
        if(a.getSalary() > b.getSalary())
            return -1;
        else if(a.getSalary() < b.getSalary())
            return 1;
        else
            return 0;
    }
}

public class Question5 {

    public static void main(String[] args) {

        List<Employee> emp = new ArrayList<>();

        // add objects in list
        emp.add(new Employee(20.4, 20000, "aman"));
        emp.add(new Employee(21.4, 200000, "sujata"));
        emp.add(new Employee(22.4, 3100, "sunanda"));
        emp.add(new Employee(23.4, 989000, "faizan"));
        emp.add(new Employee(24.4, 200, "kamal"));
        emp.add(new Employee(25.4, 77870, "meena"));

        Collections.sort(emp, new myCompare());

        // print the sorted list now
        Iterator<Employee> it = emp.iterator();

        while(it.hasNext()){
            System.out.println(it.next().print());
        }

    }
}
