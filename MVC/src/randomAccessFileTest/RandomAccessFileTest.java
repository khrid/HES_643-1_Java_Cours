package randomAccessFileTest;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
    public static void main(String[] args) throws IOException {

        // Pour changer le look de la fenêtre et appliquer le style par défaut du système
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }

        // Création du tableau de personne
        Person[] people = new Person[] {
                new Person(1, "David", "Crittin"),
                new Person(2, "Emily", "Raboud"),
                new Person(3, "Sylvain", "Meyer"),
                new Person(4, "Louise", "Bretz"),
        };

        // Taille des colonnes
        int[]  columnSize = new int[] {4,15,15};
        // écriture dans le fichier test.bin
        writeFile(new File("test.bin"), people, columnSize);

        // Model pour la JTable
        TableModel model = new TableModelFromRandomAccessFile(new File("test.bin"), columnSize);

        // Création de la fenêtre
        JFrame sample = new SampleFrame(model);
        // Affichage
        sample.setVisible(true);

        // Exercice du 15.05, affichage du fichier dans la console
        // readFile(new File("test.bin"), columnSize);
    }

    private static void writeFile(File file, Person[] people, int[] columnSize) throws IOException {
        RandomAccessFile r = new RandomAccessFile(file, "rw");
        int recordLength = columnSize[0]+columnSize[1]+columnSize[2];
        for (int i = 0; i < people.length; i++) {
            System.out.println("current pos " + i*recordLength);
            r.seek(i*recordLength);

            // ecriture de l'id
            r.writeInt(people[i].getId());

            // écriture du firstname
            //r.seek(i*recordLength+columnSize[0]);
            r.writeBytes(people[i].getFirstname());
            r.write(new byte[columnSize[1]-people[i].getFirstname().length()]);

            r.seek(i*recordLength+columnSize[0]+columnSize[1]);
            r.writeBytes(people[i].getLastname());
            r.write(new byte[columnSize[2]-people[i].getLastname().length()]);
        }
        r.close();
    }

    private static void readFile(File file, int[] columnSize) throws IOException {
        RandomAccessFile r = new RandomAccessFile(file, "r");
        int recordLength = columnSize[0]+columnSize[1]+columnSize[2];
        int n = (int) r.length() / recordLength;
        System.out.println("nombre d'enregistrements : " + n);
        byte [] buffer = new byte[15]; // buffer = taille le plus grand
        for (int i = 0; i < n; i++) {
            System.out.print(r.readInt());
            r.read(buffer); // on avance de 15 caractères
            System.out.print(new String(buffer));

            r.read(buffer); // on avance de 15 caractères
            System.out.println(new String(buffer));
        }
        r.close();
    }
}
