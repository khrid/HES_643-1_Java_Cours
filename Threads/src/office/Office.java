package office;

public class Office {
    public static void main(String[] args) throws InterruptedException {
        CopyMachine cm = new CopyMachine();
        Staff angie, pete, john, tracy;
        Thread tAngie, tPete, tJohn, tTracy;


        angie = new Staff("angie", cm, 4);
        tAngie = new Thread(angie);
        pete = new Staff("pete", cm, 4);
        tPete = new Thread(pete);
        john = new Staff("john", cm, 4);
        tJohn = new Thread(john);
        tracy = new Staff("tracy", cm, 4);
        tTracy = new Thread(tracy);

        System.out.println("The office opens");

        tAngie.start();
        tPete.start();
        tJohn.start();
        tTracy.start();

        /*tAngie.join();
        tPete.join();
        tJohn.join();
        tTracy.join();*/

        System.out.println("the office closes");
    }
}
