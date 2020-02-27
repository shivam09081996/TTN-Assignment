package multithreading;

import java.util.Scanner;

class Processor extends Thread{
    private volatile boolean running = true;

    public void run(){

        while(running){
            System.out.println("HELLO");

            try{
                Thread.sleep(100);
            }catch(InterruptedException ie){
                ie.printStackTrace();
            }
        }
    }

    public void shutdown(){
        running = false;
        System.out.println("processor terminated");
    }
}

public class Volatile {

    public static void main(String[] args) {
        Processor p1 = new Processor();
        p1.start();

        System.out.println("press enter to stop.");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        p1.shutdown();
    }
}

/* the concept here is that, here the while loop will run till the value of running is true.
* we call shutdown function to change its value and stop the thead.
* but in some scenarios where java tries to optimise the execution of threads because of
* some special situation, or may be in some distibutions of java, or where there are multiple
* threads. so, the thread caches the value of the running variable. and never sees the updated
* value. so never stops.
* the thread sees that nobody else is going to modify the value of a variable and it itself
* is not changing it, so it assumes that value will always be the same and never checks it again.
* this can be one scenario. if the thread itself is modifying the value, then there will be no issue.
* therefore we need the volatile keyword.
* by using volatile, we can say that this code is guaranteed to work. */
