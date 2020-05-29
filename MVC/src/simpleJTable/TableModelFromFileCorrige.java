package simpleJTable;

import javax.swing.table.AbstractTableModel;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * <p>Title: DŽmonstration d'une JTable avec Mod\uFFFDle</p>
 * <p>Description: DŽmonstration d'une JTable avec un Mod\uFFFDle avec des donnŽes statiques</p>
 * <p>Company: </p>
 *
 * @version 1.0
 */

public class TableModelFromFileCorrige extends AbstractTableModel {
    private String fileName;
    private String delimiter;
    private String columnName[];
    private BufferedReader file = null;
    private int columnCount = 0;
    private int rowCount = 0;
    private int current = 0;
    private String currentLine;

    public TableModelFromFileCorrige(String fileName,
                                     String delimiter,
                                     String columnName[]) throws java.io.
            FileNotFoundException, java.io.IOException {
        this.fileName = fileName;
        this.delimiter = delimiter;
        this.columnName = columnName;

        open();
    }

    public int getColumnCount() {
        return columnCount;
    }

    public int getRowCount() {
        return rowCount;
    }

    public String getColumnName(int col) {
        /* TODO : option : mettre le nom des colonnes sur la 1\uFFFDre ligne du fichier. */
        /* Si le tableau columnName ne contient pas toutes les ent\uFFFDtes de
         * colonnes returne un blanc.
         */
        if (col >= columnName.length)
            return " ";

        return columnName[col];
    }

    /**
     * JTable appelle cette fonction uniquement pour les ŽlŽments visibles,
     * elle g\uFFFDre le fetch. Attention, cette mŽthode est appelŽe ˆ chaque fois
     * que la table se rafra”chit !
     *
     * @param row int
     * @param col int
     * @return Object
     */
    public Object getValueAt(int row, int col) {
        try {
            /* si on est sur la ligne courante, on sort. */
            if (current == row)
                return currentLine.split(delimiter)[col];

            int forward;

            forward = row - current;

            if (forward < 0) {
                reopen();  // current is at -1

                forward = row - current;
            }

            /* tant qu'on doit avancer - 1, on passera la ligne qui doit \uFFFDtre lue ˆ la fonction getColumnValueAt.*/
            while (forward > 1) {
                file.readLine();

                forward--;
            }

            currentLine = file.readLine();

            current = row;  //System.out.println((System.currentTimeMillis()-start) + " ");

            String[] tab = currentLine.split(delimiter);

            return tab[col];
        } catch (java.io.IOException e) {
            return "[Error:getValueAt(int row, int col)]";
        }
    }

    public Class getColumnClass(int c) {
        return getValueAt(current, c).getClass();
    }

    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public void setValueAt(Object value, int row, int col) {
    }

    private void open() throws java.io.
            FileNotFoundException, java.io.IOException {
        file = new BufferedReader(new FileReader(fileName));

        /* TODO : ! si le fichier est vide. ce code présuppose que le fichier
         * contient au moins 1 ligne.
         */

        currentLine = file.readLine();

        rowCount = 1;

        columnCount = currentLine.split(delimiter).length;

        while (file.readLine() != null)
            rowCount++;

        /* si la premi\uFFFDre ligne contient le nom des colonnes, on peut ne pas se
         * placer au dŽbut du fichier, cette fonction permetterait d'initialiser
         * le titre des colonnes.
         */
        reopen();
    }

    private String getColumnValueAt(int col, String line) {
        //return line.split(delimiter)[col] ;

        String[] tab = line.split(delimiter);

        return tab[col];
    }

    private void reopen() throws java.io.IOException, java.io.FileNotFoundException {
        /* Pas trouvŽ comment on se place au dŽbut d'un BufferedReader
         * je dŽcide donc de le fermer et de l'ouvrir.
         *
         * ! Si nom des colonnes sur la premi\uFFFDre ligne du fichier, se placer sur
         * la deuxi\uFFFDme pour ne pas les relire une 2\uFFFDme fois.
         */
        file.close();

        file = new BufferedReader(new FileReader(fileName));

        current = -1;
    }
}
