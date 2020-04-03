package mvcMultipleFrameView;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.*;

public class ViewTextArea extends JFrame {
    JTextArea jTextArea;
    public ViewTextArea(Document model) {
        Container pane = getContentPane();
        // Pour stopper l'application au clic sur Close
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Titre de la fenêtre
        setTitle("ViewTextArea");
        setLayout(new BorderLayout());

        jTextArea = new JTextArea("Hello");
        jTextArea.setDocument(model);
        pane.add(jTextArea, BorderLayout.CENTER);
        pack();
    }

}
