package java2.Exc_2;//4. WAP to create singleton class.

class Singleton
{
    private static Singleton s_instance = null;
    public String s = null;
    private Singleton()
    {
        s = "This is a Singleton class.";
    }

    public static Singleton get_instance()
    {
        if(s_instance == null)
            s_instance = new Singleton();

        return s_instance;
    }

}

public class Q4
{
    public static void main(String[] args)
    {
        Singleton x = Singleton.get_instance();
        Singleton y = Singleton.get_instance();
        x.s = x.s.toLowerCase();
        y.s = y.s.toLowerCase();
        System.out.println("Instance x of Singleton says: "+ x.s);
        System.out.println("Instance y of Singleton says: "+ y.s);
    }
}
