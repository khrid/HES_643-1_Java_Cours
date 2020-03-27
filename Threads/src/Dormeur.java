public class Dormeur implements Runnable {
    @Override
    public void run() {
        System.out.println("Dormeur : je m'endors .... Zzzz....");
            try {
                while (true) {
                    System.out.println("Dormeur : Zzzzzz.....zzzzz....");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("Dormeur : Le réveil sonne !");
                System.out.println("Dormeur : Je me réveille !");
            }
        }
    }
