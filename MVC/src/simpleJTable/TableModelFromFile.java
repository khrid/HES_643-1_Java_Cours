package simpleJTable;

import javax.swing.table.AbstractTableModel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TableModelFromFile extends AbstractTableModel {
    String filename;
    String[] columnName;
    String[][] cache;
    int rows = -1;
    BufferedReader br;

    public TableModelFromFile(String filename, String[] columnName) {
        this.filename = filename;
        this.columnName = columnName;
        rows = getRowCount();
        cache = new String[rows][columnName.length];

        //while(cache.size() < getRowCount()) cache.add(new ArrayList<>());

        br = new BufferedReader(new InputStreamReader(
                this.getClass().getResourceAsStream(this.filename)));
    }

    public String getColumnName(int index) {
        return columnName[index];
    }

    @Override
    public int getRowCount() {
        if(rows < 0) {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    this.getClass().getResourceAsStream(this.filename)));
            int lines = 0;
            try {
                while (br.readLine() != null) {
                    lines++;
                }
                br.close();
            } catch (IOException e) {

            }
            return lines;
        } else {
            return rows;
        }
    }

    @Override
    public int getColumnCount() {
        return columnName.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        String lineAt = "";
        //System.out.println(i+"/"+i1);

        if (cache[i][i1] != null) {
            System.out.println("Got "+(i+1)+"/"+i1+" from cache");
            return cache[i][i1];
        } else {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        this.getClass().getResourceAsStream(this.filename)));
            /*while ((currentLine = br.readLine()) != null) {
                System.out.println(currentLine);
            }*/
                for (int j = 0; j <= i; j++) {
                    //System.out.println("dans boucle for");
                    lineAt = br.readLine();
                    //System.out.println(lineAt);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        /*System.out.println(lineAt);
        System.out.println(lineAt.split(";").length);
        System.out.println(lineAt.split(";")[0]+"/"+lineAt.split(";")[1]+"/"+lineAt.split(";")[2]);*/

            cache[i][i1] = lineAt.split(";")[i1];
            System.out.println("Got "+(i+1)+"/"+i1+" from buffer");
            return lineAt.split(";")[i1];
        }
    }
}
