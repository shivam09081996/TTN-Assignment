package collections;

/*
Aim :
    Design a Data Structure SpecialStack that supports all the stack operations like
    push(), pop(), isEmpty(), isFull() and an additional operation getMin() which should
    return minimum element from the SpecialStack. (Expected complexity ­ O(1))
*/


//class SpecialStack{
//
//    Stack<Integer> stk = new Stack<Integer>();
//    TreeMap<Integer, Integer> mp = new TreeMap<>();
//
//    public void push(int val){
//        stk.push(val);
//        mp.put(val, 0);
//    }
//
//    public void pop(){
//        try{
//            stk.pop();
//        }catch (EmptyStackException e){
//            System.out.println("stack empty");
//        }
//    }
//
//    public Integer top(){
//        return stk.peek();
//    }
//
//    public boolean isEmpty(){
//        return stk.empty();
//    }
//
//    public boolean isFull(){
//
//    }
//
//    public Integer getMin(){
//        return mp.firstKey();
//    }
//
//}

import com.sun.source.tree.Tree;

import java.util.Scanner;
import java.util.TreeMap;

class SpecialStack{
    int arr[];
    int top;
    int size;
    TreeMap<Integer, Integer> mp = new TreeMap<>();

    SpecialStack(){
        top=-1;
        size = 20;
        arr = new int[20];
    }

    SpecialStack(int size){
        this.size = size;
        top = -1;
        arr = new int[size];
    }

    public void push(int val){
        if(isFull())
            System.out.println("cannot push into stack - already full");
        else{
            arr[++top] = val;

            if(mp.containsKey(val)){
                int count = mp.get(val);
                mp.put(val, ++count);
            }
            else{
                mp.put(val, 1);
            }
        }
    }


    public int pop() {
        if (isEmpty()) {
            System.out.println("stack empty");
            return -99999999;
        }
        else {
            top--;
            size--;
            int val = arr[top + 1];

            if(mp.get(val)==1){
                mp.remove(val);
            }
            else{
                int count = mp.get(val);
                mp.put(val, --count);
            }

            return val;
        }
    }

    public boolean isEmpty(){
        return top==-1;
    }


    public boolean isFull(){
        return top==size-1;
    }

    public int getMin(){
        if(isEmpty()){
            System.out.println("stack is empty");
            return -99999999;
        }

        return mp.firstKey();
    }
}

public class Question8 {

    public static void main(String[] args) {

        SpecialStack s = new SpecialStack(5);
        Scanner sc = new Scanner(System.in);
        int val;
        int choice=0;

        do{
            System.out.println("------ MENU ------");
            System.out.println("1. PUSH");
            System.out.println("2. POP");
            System.out.println("3. GET MINIMUM ELEMENT");
            System.out.println("0. EXIT");

            choice = sc.nextInt();

            switch (choice){
                case 0: break;

                case 1:
                    System.out.println("enter a value - ");
                    val = sc.nextInt();
                    s.push(val);
                    break;

                case 2:
                    val = s.pop();
                    System.out.println("value popped is - " + val);
                    break;

                case 3:
                    System.out.println(s.getMin());
                    break;

                default:
                    System.out.println("invalid input");
            }

        }while(choice!=0);

        sc.close();
    }
}
