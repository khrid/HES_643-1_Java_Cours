package randomAccessFileTest;

import javax.swing.table.AbstractTableModel;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class TableModelFromRandomAccessFile extends AbstractTableModel {


    private int rowCount;
    private int columnCount;
    private RandomAccessFile rFile;
    private int recordLength = 0;
    private int current = -1;
    private Person person;

    public TableModelFromRandomAccessFile(File file, int[] columnSize) throws IOException {
        // le nombre de colonnes à afficher
        columnCount = columnSize.length;
        // ouverture du fichier en lecture seule
        rFile = new RandomAccessFile(file, "r");
        // on va calculer la longueur d'une ligne
        for (int i = 0; i < columnSize.length; i++) {
            recordLength += columnSize[i];
        }
        // calcul du nombre de lignes (taille du fichier divisé par la longueur d'une ligne)
        rowCount = (int) rFile.length() / recordLength;
    }

    @Override
    public int getRowCount() {
        // on retourne le rowCount calculé dans le constructeur (=> fait 1x)
        return rowCount;
    }

    @Override
    public int getColumnCount() {
        // on retourne le columnCount calculé dans le constructeur (=> fait 1x)
        return columnCount;
    }

    @Override
    public Object getValueAt(int row, int column) {
        try {
            // si on est pas sur la ligne courante (si on est dans la même, les infos sont déjà dans l'objet "Person"
            if (current != row) {
                // on se positionne au début de la ligne voulue
                rFile.seek(row * recordLength);
                // on lit l'id en position 1
                int id = rFile.readInt();
                // "bloc" pour le déplacement (15 par 15)
                byte[] b = new byte[15];
                // on lit les blocs 2 -> 16
                rFile.read(b);
                // on stocke ça, c'est le prénom
                String firstname = new String(b);
                // on avance de nouveau de 15
                rFile.read(b);
                // ce qui correspond au lastname
                String lastname = new String(b);
                // on stocke ça dans un objet Person
                person = new Person(id, firstname, lastname);
                // on mets à jour la ligne courante
                current = row;
            }

            // en fonction de la colonne en cours, on va retourner la bonne info de "Person"
            switch (column) {
                case 0: // colonne 0, l'id
                    return person.getId();
                case 1: // colonne 1, le prénom
                    return person.getFirstname();
                case 2: // colonne 2, le nom
                    return person.getLastname();
                default: // ne devrait pas arriver, mais on retourne qqch si on est > 2
                    return "Err";
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        // on ne devrait jamais arriver là, mais bon...
        return null;
    }

}
