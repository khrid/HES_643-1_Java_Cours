package mvcMultipleFrameView;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.*;

public class ViewTextField extends JFrame {
    JTextField jTextField;
    public ViewTextField(Document model) {
        // Pour stopper l'application au clic sur Close
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Titre de la fenêtre
        setTitle("ViewTextField");

        jTextField = new JTextField("Hello");
        jTextField.setDocument(model);
        add(jTextField);
        pack();
    }
}
