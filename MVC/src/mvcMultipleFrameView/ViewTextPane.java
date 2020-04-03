package mvcMultipleFrameView;

import javax.swing.*;
import javax.swing.text.Document;
import javax.swing.text.StyledDocument;
import java.awt.*;

public class ViewTextPane extends JFrame {
    JTextPane jTextPane;
    public ViewTextPane(Document model)  {
        // Pour stopper l'application au clic sur Close
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Titre de la fenêtre
        setTitle("ViewTextPane");

        jTextPane = new JTextPane((StyledDocument) model);
        add(jTextPane);
        pack();
    }

}
