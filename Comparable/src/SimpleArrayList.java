import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SimpleArrayList {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("david", "crittin"));
        list.add(new Person("sylvain", "meyer"));
        list.add(new Person("louise", "bretz"));
        list.add(new Person("robin", "gallay"));
        list.add(new Person("samuel", "wenger"));

        Collections.sort(list);

        System.out.println("Current size "+list.size());
        Person p = list.get(4);
        System.out.println(p);
        list.remove(p);
        System.out.println("Current size "+list.size());

        for (Object pers :
                list) {
            Person pe = (Person) pers;
            System.out.println(pe.getPrenom());
        }


    }
}
