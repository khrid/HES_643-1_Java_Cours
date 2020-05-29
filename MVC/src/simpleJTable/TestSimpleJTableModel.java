package simpleJTable;

import javax.swing.*;

public class TestSimpleJTableModel {
    public static void main(String[] args) {

        // Pour changer le look de la fenêtre et appliquer le style par défaut du système
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }
        //FakeTableModel model = new FakeTableModel();
        TableModelFromFile model = new TableModelFromFile("data.csv", new String[]{"id", "prenom","nom"});
        SimpleJTableModel simpleJTableModel = new SimpleJTableModel(model);
        simpleJTableModel.setVisible(true);
    }
}
