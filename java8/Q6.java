package lambdas;

//Q6. Create and access default and static method of an interface.
interface demo
{
    default void display()
    {
        System.out.println("This is the default method in the interface");
    }
    static void method()
    {
        System.out.println("Static method of the interface.");
    }
}
public class Q6 implements demo
{
    public static void main(String[] args) {

        demo d = new Q6();  //assigning an object reference of Q6 type to reference variable of demo interface.
        d.display();
        demo.method();

    }
}

//Q7. Override the default method of the interface.
class Q7 implements demo
{
    //since this class implements demo interface, it can override it's default method
    @Override
    public void display() {
        System.out.println("Overridden method of the interface in the class");
    }

    public static void main(String[] args) {

        Q7 q7 = new Q7();
        q7.display();
    }
}
