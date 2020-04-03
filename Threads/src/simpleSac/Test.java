package simpleSac;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Sac sac = new Sac();
        Thread j1 = new Thread(new Job(sac));
        Thread j2 = new Thread(new Job(sac));

        j1.start();
        j2.start();

        j1.join();
        j2.join();

        System.out.println("terminé. " +sac.size());
    }
}
