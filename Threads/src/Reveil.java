public class Reveil implements Runnable {
    Thread thread;
    int duration;
    public Reveil(Thread _thread, int _duration) {
        thread = _thread;
        duration = _duration;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(duration);
            System.out.println("Reveil : Driiiiiiiiiiing");
            thread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("Réveil : Le réveil sonne !");
        }
    }
}
