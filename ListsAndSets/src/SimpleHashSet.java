import java.util.HashSet;
import java.util.Set;

public class SimpleHashSet {
    public static void main(String[] args) {

        Set s = new HashSet();

        Person hannibal = new Person("Hannibal", "Lecter");
        s.add(new Person("David", "Crittin"));
        s.add(new Person("Sylvain", "Meyer"));
        s.add(new Person("Albain", "Dufils"));
        s.add(new Person("Louise", "Bretz"));
        s.add(new Person("Robin", "Gallay"));
        s.add(new Person("Samuel", "Wenger"));
        s.add(hannibal);
        s.add(hannibal);

        System.out.println("Current size : "+s.size()+", not 8.");

        for (Object p :
                s) {
            System.out.println(p);
        }
    }
}
