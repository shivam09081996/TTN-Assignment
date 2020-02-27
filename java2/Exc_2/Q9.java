package java2.Exc_2;//9.  Design classes having attributes for furniture where there are wooden chairs and tables, metal chairs and tables.
// There are stress and fire tests for each products.

enum Fire_resistance
{
    HIGH, MEDIUM, LOW
}

enum Stress_resistance
{
    HIGH, MEDIUM, LOW
}


enum Furniture_type
{
    metal, wood
}

abstract class Furniture
{
    String color;
    Fire_resistance f;
    Stress_resistance s;

    abstract String fire_test();
    abstract String stress_test();

}

class Table extends Furniture
{
    String color;
    Fire_resistance f;
    Stress_resistance s;
    Furniture_type type;

    @Override
    String fire_test() {

        if(f == Fire_resistance.HIGH)
            return "Very resistive.";
        else if(f == Fire_resistance.MEDIUM)
            return "A little ressistive.";
        else
            return "Not at all resistive.";

    }

    @Override
    String stress_test()
    {
        if(s == Stress_resistance.HIGH)
            return "Very resistive.";
        else if(s == Stress_resistance.MEDIUM)
            return "A little ressistive.";
        else
            return "Not at all resistive.";
    }

    public String typeof()
    {
        return type.toString();
    }
}

class Chair extends Furniture
{
    String color;
    Fire_resistance f;
    Stress_resistance s;
    Furniture_type type;

    @Override
    String fire_test() {
        if(f == Fire_resistance.HIGH)
            return "Very resistive.";
        else if(f == Fire_resistance.MEDIUM)
            return "A little ressistive.";
        else
            return "Not at all resistive.";

    }

    @Override
    String stress_test() {

        if(s == Stress_resistance.HIGH)
            return "Very resistive.";
        else if(s == Stress_resistance.MEDIUM)
            return "A little ressistive.";
        else
            return "Not at all resistive.";
    }

    public String typeof()
    {
        return type.toString();
    }
}


public class Q9
{
    //driver code.
    public static void main(String[] args)
    {

    }
}
