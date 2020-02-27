package multithreading;

import javax.management.relation.RoleUnresolved;

class Runner extends Thread{
    static int count = 0;
    int id;

    Runner(){
        id = ++count;
    }

    public void run(){
        for(int i=0; i<10; i++){
            System.out.println("HELLO " + i + " -- from thread " + id);
            try{
                Thread.sleep(500);
            }catch(InterruptedException ie){
                ie.printStackTrace();
            }
        }
    }
}

public class ThreadUsingThreadClass {

    public static void main(String[] args) {
        Runner r1 = new Runner();
        Runner r2 = new Runner();

        // we call start method because it runs the run method in a nee thread
        // if we call run directly, it calls the run method in the main thread itself.

        r1.start();
        r2.start();
        // i observed that, i started r1 first but still r2 can start early.
        // this is awesome. 
    }
}
