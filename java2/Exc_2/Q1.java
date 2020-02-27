package java2.Exc_2;//1. Create Java classes having suitable attributes for Library management system.
// Use OOPs concepts in your design.Also try to use interfaces and abstract classes.

abstract class Books
{
    public String name;
    public int book_id;
    public String author_name;

    abstract String getName();
    abstract String getAuthorName();
    abstract int getBookId();

}

class Novels extends Books
{
    private String name;
    private String author_name;
    private int book_id;

    public Novels(String n, String an, int b_id)
    {
         name = n;
         author_name = an;
         book_id = b_id;
    }
    public String getName()
    {
        return this.name;
    }
    public String getAuthorName()
    {
        return this.author_name;
    }
    public int getBookId()
    {
        return this.book_id;
    }
}


class ReferenceBooks extends Books
{
    private String name;
    private String author_name;
    private int book_id;

    public ReferenceBooks(String n, String an, int b_id)
    {
        this.name = n;
        this.author_name = an;
        this.book_id = b_id;
    }
    public String getName()
    {
        return this.name;
    }
    public String getAuthorName()
    {
        return this.author_name;
    }
    public int getBookId()
    {
        return this.book_id;
    }
}


interface Person
{
    String shifts = null;

    abstract String get_department();

}

class Employee implements Person
{
    String dept;
    int e_id;

    public Employee(String d,  int id)
    {
        dept = d;
        e_id = id;
    }

    @Override
    public String get_department()
    {
        return dept;
    }
}

class Student implements Person
{

    String dept;
    int s_id;
    public Student(String d, int id)
    {
        dept = d;
        s_id = id;
    }


    public String get_department()
    {
        return dept;
    }
}

public class Q1
{
    public static void main(String[] args) {

    }
}
