package lambdas;

//Q9.  Implement multiple inheritance with default method inside  interface.
interface i1
{
    default void greetings()
    {
        System.out.println("Method of interface i1");
    }
}

interface i2
{
    default void greetings()
    {
        System.out.println("Method of interface i2");
    }
}

public class Q8 implements i1, i2
{
    //since this method is overriding the same method signature from two different interfaces,
    //java requires this method to be public.
    @Override
    public void greetings()
    {
        System.out.println("Overridden Method of the class");
    }

    public static void main(String[] args)
    {
        Q8 obj = new Q8();
        obj.greetings();
    }
}
