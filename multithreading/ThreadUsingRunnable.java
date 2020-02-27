package multithreading;

class RunnerUp implements Runnable{
    static int count = 0;
    int id;

    RunnerUp(){
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

public class ThreadUsingRunnable {

    public static void main(String[] args) {

        // start is a method oof thread class, not runnable.
        // we cant call it on RunnerUp object here.
        // so we need to create an obj of Thread class always if we use Runnable.

        Thread t1 = new Thread(new RunnerUp());
        Thread t2 = new Thread(new RunnerUp());

        t1.start();
        t2.start();
    }
}
