package simpleJTable;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class FakeTableModel extends AbstractTableModel {

    @Override
    public int getRowCount() {
        return 100;
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        System.out.println("line "+i);
        return i+"/"+i1;
    }
}
