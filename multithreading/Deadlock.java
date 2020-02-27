package multithreading;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Account{
    private int balance = 10000;

    public void deposit(int amount){
        balance += amount;
    }

    public void withdraw(int amount){
        balance -= amount;
    }

    public int getBalance(){
        return balance;
    }

    public static void transfer(Account a1, Account a2, int amount){
        a1.withdraw(amount);
        a2.deposit(amount);
    }
}

class Runner2{
    private Account acc1 = new Account();
    private Account acc2 = new Account();
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    public void acquireLocks(Lock firstLock, Lock secondLock) throws InterruptedException {

        while(true){
            boolean gotFirstLock = false;
            boolean gotSecondLock = false;

            try{
                gotFirstLock = firstLock.tryLock();
                gotSecondLock = secondLock.tryLock();

            }finally{
                if(gotFirstLock && gotSecondLock)
                    return;

                else if(gotFirstLock)
                    firstLock.unlock();

                else if(gotSecondLock)
                    secondLock.unlock();
            }
            // locks not acquired
            Thread.sleep(1);
        }
    }

    public void firstThread() throws InterruptedException{
        // transfer from acc1 to acc2
//        lock1.lock();
//        lock2.lock();


        acquireLocks(lock1,lock2);

        try{
            Random random = new Random();
            for(int i=0; i<10; i++)
                Account.transfer(acc1, acc2, random.nextInt(100));
        }finally {
            lock2.unlock();
            lock1.unlock();
        }
    }

    public void secondThread() throws InterruptedException{

        // transfer from acc2 to acc1
//        ======= TO CRETE DEADLOCK, USE THIS CODE =======
//        lock2.lock();
//        lock1.lock();

        // WE NEED TO ACQUIRE THE LOCKS IN SAME ORDER IN BOTH THREADS TO AVOID DEADLOCK.
//        lock1.lock();
//        lock2.lock();

        acquireLocks(lock2, lock1);

        try{
            Random random = new Random();
            for(int i=0; i<10; i++)
                Account.transfer(acc2, acc1, random.nextInt(100));
        }finally {
            lock2.unlock();
            lock1.unlock();
        }
    }

    public void finished(){
        System.out.println("Account 1 balance - " + acc1.getBalance());
        System.out.println("Account 2 balance - " + acc2.getBalance());
        System.out.println("Total balance - " + (acc1.getBalance() + acc2.getBalance()));
    }
}

public class Deadlock {


    public static void main(String[] args) throws Exception {

        final Runner2 runner = new Runner2();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    runner.firstThread();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    runner.secondThread();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        runner.finished();
    }
}
