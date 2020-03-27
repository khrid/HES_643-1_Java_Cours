import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ExerciceFinal {

    public static void main(String[] args) {
        Map<Person, Set<Animal>> tab = new HashMap<Person, Set<Animal>>();
        Set<Animal> animaux = new HashSet<>();
        Person p = new Person("David", "Crittin");
        animaux.add(new Animal("chat", "Flaam"));
        animaux.add(new Animal("chat", "Nephtys"));
        tab.put(new Person("David", "Crittin"), animaux);

        System.out.println(tab.get(p));
    }
}
