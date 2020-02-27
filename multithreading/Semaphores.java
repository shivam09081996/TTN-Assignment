package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class Connection{
    private static Connection instance = new Connection();
    private int connections = 0;
    // we want only 10 connections to be handles at a time.
    private static Semaphore sem = new Semaphore(10);

    private Connection(){
        // private contsructor
    }

    public static Connection getInstance(){
        return instance;
    }

    public void connect(){

        try {
            // if eligible to make connection.
            sem.acquire();
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        try {
            // make the connection
            doConnect();
        } finally {
            // work completed, release the connection.
            sem.release();
        }
    }

    public void doConnect(){

        synchronized (this) {
            connections++;
            System.out.println("Current connections: " + connections);
        }

        // doing some work with the connection....
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        synchronized (this) {
            connections--;
            System.out.println("released lock on connection");
        }
    }
}
public class Semaphores {

    public static void main(String[] args) throws InterruptedException {

//        Semaphore sem = new Semaphore(1);

        ExecutorService executor = Executors.newCachedThreadPool();

        for(int i=0; i<200; i++){
            executor.submit(new Runnable() {
                @Override
                public void run() {
                        Connection.getInstance().connect();
                }
            });
        }

        executor.shutdown();
        System.out.println("all threads submitted");

        executor.awaitTermination(1, TimeUnit.DAYS);
        System.out.println("all threads completed");

    }
}
