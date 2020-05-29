package simpleJTable;

import javax.swing.*;
import javax.swing.table.TableModel;

public class SimpleJTableModel extends JFrame {

    JTable table = new JTable();
    private JScrollPane scroll;

    public SimpleJTableModel(TableModel tableModel) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("SimpleJTableModel with fake data");

        table.setModel(tableModel);
        scroll = new JScrollPane(table);
        add(scroll);
        pack();
    }
}
