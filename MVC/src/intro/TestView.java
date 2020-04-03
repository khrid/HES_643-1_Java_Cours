package intro;

import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;

public class TestView {
    public static void main(String[] args) {

        Document model = new DefaultStyledDocument();

        View v1 = new View(model);
        View v2 = new View(model);
        View v3 = new View(model);
        v1.setVisible(true);
        v2.setVisible(true);
        v3.setVisible(true);
    }
}
