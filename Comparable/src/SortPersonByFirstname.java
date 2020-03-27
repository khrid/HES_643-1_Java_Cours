import java.util.Comparator;

public class SortPersonByFirstname implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        int r;
        if((r = p1.nom.compareTo(p2.nom)) == 0) {
            if((r = p1.prenom.compareTo(p2.prenom)) == 0) {
                return 0;
            }
        }
        return r;
    }
}
