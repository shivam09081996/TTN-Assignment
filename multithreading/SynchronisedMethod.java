package multithreading;

public class SynchronisedMethod {

    private int count = 0;

    public synchronized void increment(){
        count++;
    }

    public void doWork(){

        Thread t1 = new Thread( new Runnable(){
            public void run()
            {
                for(int i=0; i<10000; i++){
                    increment();
                }
            }
        });

        Thread t2 = new Thread( new Runnable(){
            public void run()
            {
                for(int i=0; i<10000; i++){
                    increment();
                }
            }
        });

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }catch(InterruptedException ie){
            ie.printStackTrace();
        }

        System.out.println("count = " + count);
    }

    public static void main(String[] args) {

        SynchronisedMethod sv = new SynchronisedMethod();

        sv.doWork();
    }

}

/*
here there are 2 threads running simultaneously and accessing the same value.
the step count++ actually is count = count+1 which involves 3 steps -
see the current value of count
increment it
and then write it again.
but, one thread reads the value 100 and increments it. before it writes it, another thread also reads it 100
several times and make it to be 110. now the previous thread makes it 101 again when its turn comes.
so, they overwrite each other's work. so we dont get the proper output. sometimes, we get.

so, the solution is to make this count++ operation atomic.

we can do this by using synchronised keyword with a function.
volatile will not work here, because caching is not the problem. the problem is interleaving of threads.

we convert the count++ statement into a function and makes that synchronised.
so, while one thread is executing the function, another thread could not and will
have to wait for that.

every object in java has an intrinsic lock or mutex. synchronised acquires that lock and
releases on exiting the method increment. so, its done.

so, synchronised method can be called by only one thread at a time.
*/

