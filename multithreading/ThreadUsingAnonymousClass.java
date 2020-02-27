package multithreading;

public class ThreadUsingAnonymousClass {

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<10; i++){
                    System.out.println("HELLO " + i + " -- from thread 1");
                    try{
                        Thread.sleep(500);
                    }catch(InterruptedException ie){
                        ie.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<10; i++){
                    System.out.println("HELLO " + i + " -- from thread 2");
                    try{
                        Thread.sleep(500);
                    }catch(InterruptedException ie){
                        ie.printStackTrace();
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }
}
