package randomAccessFileTest;

import javax.swing.*;
import javax.swing.table.TableModel;

public class SampleFrame extends JFrame {

    JTable table = new JTable();
    private JScrollPane scroll;

    public SampleFrame(TableModel model) {
        // Fermeture quand on clic
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Titre
        setTitle("SimpleJTableModel with data from RandomAccessFile");

        // Configuration du modèle
        table.setModel(model);
        // Scrollpane avec la JTable à l'intérieur
        scroll = new JScrollPane(table);
        // Ajout du scrollpane dans la frame
        add(scroll);
        // resize de la frame en fonction de ce qu'il y a dedans
        pack();
    }
}
