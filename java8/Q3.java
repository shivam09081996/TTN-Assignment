package lambdas;
//Q3
//Using (instance) Method reference create and apply add and
//subtract method and using (Static) Method reference create and
// apply multiplication method for the functional interface created.

@FunctionalInterface
interface Constructable
{
    int method(int a, int b);
}

public class Q3
{
    static int mul(int x, int y)
    {
        return x*y;
    }

    int add(int x, int y)
    {
        return x+y;
    }

    int sub(int x, int y)
    {
        return x-y;
    }

    public static void main(String[] args) {

        Q3 ob = new Q3();

        //assigning instance method reference of Q3 class to reference variable of Constructable interface.
        Constructable constructable = ob::add;
        System.out.println(constructable.method(10,20));

        constructable = ob::sub;
        System.out.println(constructable.method(10, 20));

        //since mul(a,b) is a static method, it can be directly referred to using class name.
        constructable = Q3::mul;
        System.out.println(constructable.method(10,20));
    }
}
