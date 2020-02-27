package java2.Exc_2;//5. WAP to show object cloning in java using cloneable and copy constructor both.

class A implements Cloneable
{
    String s;
    int d;

    public A(String s, int d)
    {
        this.s = s;
        this.d = d;
    }

    public A(A ob)
    {
        System.out.println("copy constructor called.");
        this.s = ob.s;
        this.d = ob.d;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }

    void display()
    {
        System.out.println("This is class A.");
    }
}


public class Q5
{
    public static void main(String[] args) throws CloneNotSupportedException
    {
        A a1 = new A("To The New", 2020);

        // down-casting as clone() return type is Object
        A a2 = (A)a1.clone();

        System.out.println(a2.d);
        System.out.println(a2.s);

        //using copy constructor.
        A a3 = new A(a1);

        System.out.println(a3.s);
        System.out.println(a3.d);


    }
}
