public class Person implements Comparable<Person>{
    public String nom;
    public String prenom;

    public Person(String prenom, String nom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return nom + '\t'  + prenom;
    }

    @Override
    public int compareTo(Person p) {
        int r;
        if((r = this.nom.compareTo(p.nom)) == 0) {
            if((r = this.prenom.compareTo(p.prenom)) == 0) {
                return 0;
            }
        }
        return r;
    }

    public String getPrenom() {
        return prenom;
    }
}
