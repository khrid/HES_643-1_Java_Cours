public class ThreadInterruptedDormeur {
    public static void main(String[] args) {
        Thread bob = new Thread(new Dormeur());
        Thread reveil = new Thread(new Reveil(bob, 10000));

        bob.start();
        reveil.start();
    }
}
