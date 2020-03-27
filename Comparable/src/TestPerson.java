import java.util.Arrays;

public class TestPerson {
    public static void main(String[] args) {
        Person [] people = new Person[5];
        people[0] = new Person("david", "crittin");
        people[1] = new Person("sylvain", "meyer");
        people[2] = new Person("robin", "gallay");
        people[3] = new Person("samuel", "wenger");
        people[4] = new Person("albain", "dufils");

        System.out.println("Unsorted");
        System.out.println("-------------------");

        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i]);
        }

        Arrays.sort(people, new SortPersonByFirstname());
        System.out.println("Sorted");
        System.out.println("-------------------");

        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i]);
        }
    }
}
