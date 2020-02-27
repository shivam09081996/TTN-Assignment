package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class EvenThread implements Runnable{

    public void run(){
        System.out.println("Starting an even Thread ");

        for(int i=0; i<=20; i+=2){
            System.out.println(i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Completed an even Thread ");
    }
}

class OddThread implements Runnable{

    public void run(){
        System.out.println("Starting an odd Thread ");

        for(int i=1; i<20; i+=2){
            System.out.println(i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Completed an odd Thread ");
    }
}

public class Question4threadPool {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
//      executor starts his own separate thread to manage the thread pool.

        for(int i=0; i<3; i++){
            executor.submit(new OddThread());
            executor.submit(new EvenThread());
        }

        executor.shutdown();
        // this method prevents the submission of new tasks and allows the already submitted ones to
        // complete.
        System.out.println("all threads submitted ");

        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
            // blocks until all the threads have completed execution or the timeout occurs.
            // or if any thread is interrupted.

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("all threads completed");

    }
}

/*
the use of thread pool is to save the overhead. starting a new thread gives an overhead.
To minimize this overhead, we limit the number of threads that can run simultaneously.
this is used by .. for ex - amazon during mobile sale.
every user gets his own thread but during sale the number of threads will go to lakhs and the
server would choke down. so they limit the number of threads by using a thread pool. and now
only a fixed number of threads are created and executed on first come first serve basis.
rest keep waiting for their turn.

this is awesome.
*/