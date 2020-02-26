package collections;

/*
Aim : Write a program to sort the Student objects based on Score ,
if the score are same then sort on First Name .
Class Student{ String Name; Double Score; Double Age
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student{
    String name;
    double score;
    double age;

    Student(String name, double score, double age){
        this.name = name;
        this.score = score;
        this.age = age;
    }

    public double getScore(){
        return score;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return " name - " + name + ", age - " + age + ", score - " + score;
    }
}

class studentCompare implements Comparator<Student> {

    public int compare(Student a, Student b){

        if(a.getScore() > b.getScore())
            return 1;

        else if(a.getScore() < b.getScore())
            return -1;

        else{
            // if 2 students have same score.
            return a.getName().compareTo(b.getName());
        }
    }
}

public class Question6 {

    public static void main(String[] args) {

        List<Student> list = new ArrayList<Student>();

        // add elements to array
        list.add(new Student("kapil", 90.50, 21));
        list.add(new Student("sonam", 44.90, 21));
        list.add(new Student("chaman", 90.50, 22));
        list.add(new Student("kamal", 67.78, 25));
        list.add(new Student("kandy", 90.50, 22));

        System.out.println("before sorting");
        for(Student s : list){
            System.out.println(s.toString());
        }

        Collections.sort(list, new studentCompare());

        System.out.println("after sorting");
        for(Student s : list){
            System.out.println(s.toString());
        }

    }
}



