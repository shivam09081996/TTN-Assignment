package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Worker {

    private Random random = new Random();
    private List<Integer> list1 = new ArrayList<Integer>();
    private List<Integer> list2 = new ArrayList<Integer>();

    Object lock1 = new Object();
    Object lock2 = new Object();

//  rather than locking the shared object itself, its better to create a different lock object and use that.
//  its a good practice. otherwise u may get confusion or java may create problem while optimising also.
//  thats why we make synchronised block.

    public void process(){
        for(int i=0; i<1000; i++){
            stageOne();
            stageTwo();
        }
    }

    //    public synchronized void stageOne(){
    public void stageOne(){
        synchronized(lock1){
            try{
                Thread.sleep(1);
            }catch(InterruptedException ie){
                ie.printStackTrace();
            }

            list1.add(random.nextInt());
        }
    }

    //    public synchronized void stageTwo(){
    public void stageTwo(){
        synchronized(lock2){
            try{
                Thread.sleep(1);
            }catch(InterruptedException ie){
                ie.printStackTrace();
            }

            list2.add(random.nextInt());
        }
    }

    public void main() {

        System.out.println("Starting ...");

        long start = System.currentTimeMillis();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                process();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                process();
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

        long end = System.currentTimeMillis();

        System.out.println("time taken - " + (end - start));

        System.out.println("list 1 size - " + list1.size());
        System.out.println("list 2 size - " + list2.size());
    }
}

/*
 * an awesome thing is that, if i make the 2 methods synchronised here, then the thread will acquire
 * intrinsic lock on the whole worker object. so, if one thread is using the stageOne() then other
 * thread cant use stageTwo() also even though they are using the different data objects - list1-2.
 *
 * so, that's why we provide different locks to both the methods by using synchronised block.
 * now, no 2 threads can use the same function simultaneously but they can access the 2 different
 * functions together.
 *
 *
 * its really awesome!!!!........
 * */


public class SynchronisedBlocks {

    public static void main(String[] args) {

        new Worker().main();
    }
}
