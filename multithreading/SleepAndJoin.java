package multithreading;

public class SleepAndJoin {

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("started runnning 1");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("ended thread 1");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("started runnning 2");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("ended thread 2");
            }
        });

        t1.start();
        t2.start();

//        try {
//            t1.join();
            System.out.println("finished thread 1");
//            t2.join();
            System.out.println("finished thread 2");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

}
