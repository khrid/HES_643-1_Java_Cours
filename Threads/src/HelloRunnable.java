public class HelloRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+" | count: " + i);
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        System.out.println("Starting main");
        Thread t1 = new Thread(new HelloRunnable());
        Thread t2 = new Thread(new HelloRunnable());
        Thread t3 = new Thread(new HelloRunnable());
        //Thread t4 = new Thread(new HelloRunnable());
        t1.start();
        t2.start();
        t3.start();
        //t4.start();

        // le thread courant va attendre sur celui qu'on join
        // le main va attendre sur t1
        //try {
            //t1.join();
            //t2.join();
            //t3.join();
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
        System.out.println("end.");
    }
}
