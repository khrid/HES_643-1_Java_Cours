package office;

public class CopyMachine {
    public void print(int pageToPrint) {
        try {
            Thread.sleep(pageToPrint*500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
