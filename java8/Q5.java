package lambdas;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


//Q5. Implement following functional interfaces from java.util.function using lambdas:
//(1) Consumer
//(2) Supplier
//(3) Predicate
//(4) Function

public class Q5
{
    public static void main(String[] args) {

        //accept method in Consumer interface as per-defined by java takes no arguments and has void return type
        Consumer<String> consumer = x ->{
            System.out.println(x);
        };
        consumer.accept("Hello World");

        //Supplier interface has a get() method that takes no arguments but has a return type.
        Supplier<String> supplier = () ->{
            System.out.println("Hello World");
            return null;
        };
        supplier.get();

        //Predicate interface has a test method that tests certain functionalities.
        //here I'm checking if the object passed to test function is of type Employee or not.
        Predicate<Employee> predicate = x ->{

            return x instanceof Employee;
        };
        Employable emp = Employee::new;
        Employee e = emp.details("Rohit", 22, "Noida");
        System.out.println(predicate.test(e));


        //apply() in Function takes an Object argument and returns some value of some type as specified.
        Function fn = (Object a) ->{
            return a;
        };
        fn.apply(e.name = "Varun");
        System.out.println(e.name+" "+e.city);

        Function<Integer, Double> half = x-> x/2.0;
        System.out.println(half.apply(10));
    }
}
