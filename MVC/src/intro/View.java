package intro;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.*;

public class View extends JFrame {

    JTextArea jTextArea;

    static int cpt = 1;

    public View (Document m) {
        // Pour stopper l'application au clic sur Close
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Titre de la fenêtre
        setTitle(""+cpt);
        // Taille de l'écran
        setSize(new Dimension(400, 600));
        // Pour ne pas pouvoir redimensionner
        setResizable(false);
        cpt++;

        jTextArea = new JTextArea("Hello");
        jTextArea.setDocument(m);
        add(jTextArea);
    }
}
