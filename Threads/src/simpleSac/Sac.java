package simpleSac;

import java.util.ArrayList;

public class Sac {

    ArrayList<Integer> objets;

    public Sac() {
        objets = new ArrayList<>();
    }

    synchronized public void add() {
        for (int i = 0; i < 1000000; i++) {
            objets.add(i);
        }
    }

    public int size() {
        return objets.size();
    }
}
