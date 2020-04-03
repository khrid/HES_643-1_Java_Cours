package office;

public class Staff implements Runnable {
    String name;
    CopyMachine cm;
    int pageToPrint;

    public Staff(String name, CopyMachine cm, int pageToPrint) {
        this.name = name;
        this.cm = cm;
        this.pageToPrint = pageToPrint;
    }

    @Override
    public void run() {
        System.out.println("Starting "+name);
        cm.print(pageToPrint);
        System.out.println("End "+name);

    }
}
