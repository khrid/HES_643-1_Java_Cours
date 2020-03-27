import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

public class SimpleHashTable {
    public static void main(String[] args) {
        //Map m = new Hashtable<>(); // hashtable = clef pas null + valeur inconnue = null
        //Map m = new TreeMap(); // treemap = clef pas null
        Map<String, String>  m = new HashMap<String, String>();

        m.put("Lundi", "Montag");
        m.put("Mardi", "Dienstag");
        m.put("Mercredi", "Mittwoch");
        m.put("Sylvain", "Meyer");
        m.put("test2", null);

        System.out.println(m.get("Lundi"));
        System.out.println(m.get("Mardi"));
        System.out.println(m.get("Mercredi"));
        System.out.println(m.get("Sylvain"));
        System.out.println(m.get("Dimanche")); // clef inconnue
        System.out.println(m.get("test2")); // valeur null

    }
}
