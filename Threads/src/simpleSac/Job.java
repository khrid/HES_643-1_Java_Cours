package simpleSac;

public class Job implements Runnable {
    Sac sac;
    public Job(Sac sac) {
        this.sac = sac;
    }

    @Override
    public void run() {
        sac.add();
    }
}
