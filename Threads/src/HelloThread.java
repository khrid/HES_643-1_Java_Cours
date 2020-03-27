public class HelloThread extends Thread {

    public static void main(String[] args) {
        Thread t = new HelloThread();
        t.run();

        System.out.println("end.");
    }

    @Override
    public void run() {
        System.out.println("Hello from a thread");
    }
}
