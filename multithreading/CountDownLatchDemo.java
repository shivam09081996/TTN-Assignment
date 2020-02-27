package multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor2 implements Runnable{
    private int id;
    private CountDownLatch latch;

    Processor2(CountDownLatch latch, int id){
        this.latch = latch;
        this.id = id;
    }

    public void run(){
        System.out.println("Starting Thread " + id);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Completed Thread "+ id);
        latch.countDown();  // decrement the value of latch

    }
}

public class CountDownLatchDemo {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        CountDownLatch latch = new CountDownLatch(3);

        for(int i=0; i<3; i++){
            executor.submit(new Processor2(latch, i));
        }

        System.out.println("all threads submitted");


        try {
            latch.await();
            // Causes the current thread to wait until the latch has counted down to zero,
            // unless the thread is interrupted, or the specified waiting time elapses.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("completed");
    }
}
