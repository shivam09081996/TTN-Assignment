package multithreading;


import java.util.Scanner;

class Processor4{

    public void producer() throws InterruptedException {

        synchronized (this) {
            System.out.println("producer running");
            wait();
            // wait method is a method of the Object class. every object has this method.
            // it can be called only from inside a synchronised block.
            // we can give the time interval also.
            System.out.println("producer resumed");
        }
    }

    public void consumer() throws InterruptedException {

        Scanner sc = new Scanner(System.in);
        Thread.sleep(2000);

        synchronized (this){
            System.out.println("consumer running");
            System.out.println("waiting for return key pressed");
            sc.nextLine();
            System.out.println("return key pressed");
            notify();
            // notify can also be called only from inside a synchronised block.
            // notify informs the other thread that it can start now but actually it cant start untill
            // this block is completed and we release the lock. so, it will wait for another 5 sec for
            // the lock and then other thread acquires the lock and starts.
            Thread.sleep(5000);
        }
    }

}

public class WaitAndNotify {

    public static void main(String[] args) {

        Processor4 pc = new Processor4();


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
