package intro;

import org.hsqldb.ExpressionPeriod;

import javax.xml.transform.Result;
import java.sql.*;

public class HSQLDBIntro {

    // Pour la connexion à la db
    private Connection con;
    // Pour exécuter les requêtes
    private Statement stmt;

    public HSQLDBIntro() throws Exception {
        // configuration de la db
        Class.forName("org.hsqldb.jdbcDriver"); // chargement du driver
        String url = "jdbc:hsqldb:file:C:/tmp/hsqldb_file"; // url de la db /!\ le chemin "C:\tmp" doit exister
        con = DriverManager.getConnection(url, "sa", ""); // connexion à la db
        System.out.println("Connection successful !"); // si c'est OK

        // établissement de la connexion
        stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);

        // requête à exécuter
        stmt.execute("create table personne (pers_id integer not null," +
                "pers_prenom varchar(25) not null," +
                "pers_nom varchar(25) not null," +
                "primary key (pers_id))");
        System.out.println("Table personne created successfuly");

        // insert de lignes dans la db
        stmt.execute("insert into personne(pers_id, pers_prenom, pers_nom) " +
                "values(-1, 'Steve', 'Jobs')");
        stmt.execute("insert into personne(pers_id, pers_prenom, pers_nom) " +
                "values(-2, 'Bill', 'Gates')");
        stmt.execute("insert into personne(pers_id, pers_prenom, pers_nom) " +
                "values(-3, 'Mickey', 'Mouse')");
        System.out.println("Values inserted successfuly");
        // affichage après insert
        print();

        // suppression d'une ligne
        stmt.execute("delete from personne where pers_nom = 'Jobs'");
        System.out.println("Record deleted successfuly");
        // affichage après delete
        print();

        // update d'une ligne
        stmt.execute("update personne set pers_nom = 'Rourke' where pers_id = -3");
        System.out.println("Record updated successfuly");
        // affichage après update
        print();

        /* update 2.0 */
        Statement stmt_updatable = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
        stmt_updatable.execute("select pers_id, pers_prenom, pers_nom from personne");
        ResultSet r = stmt_updatable.getResultSet();
        while (r.next()) {
            r.updateString("pers_prenom", "update");
                // ^ updateString gère l'échappement des caractères. Tant qu'on a une chaîne valide pour Java c'est OK
                // par exemple pour les ' , pas besoin des les échapper avec \ ou de les doubler
            r.updateRow(); // = commit
        }
        stmt_updatable.close();
        print();


        /* delete 2.0 */
        Statement stmt_deletable = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
        stmt_deletable.execute("select pers_id, pers_prenom, pers_nom from personne");
        r = stmt_deletable.getResultSet();
        while (r.next()) {
            if(r.getString("pers_nom").equals("Gates")) {
                r.deleteRow();
            }
        }
        stmt_deletable.close();
        print();


        /* insert 2.0 */
        /*Statement stmt_insertable = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
        stmt_insertable.execute("select pers_id, pers_prenom, pers_nom from personne");
        r = stmt_insertable.getResultSet();
        int id = r.getInt("pers_id")-1;
        r.moveToInsertRow(); // on se déplace sur la dernière ligne
        r.updateInt("pers_id", id); // id
        r.updateString("pers_prenom", "David"); // prenom
        r.updateString("pers_nom", "Crittin"); // nom
        r.insertRow(); // on insère la ligne
        stmt_insertable.close(); // fermeture du statement
        print();*/

        /* prepared statement */
        PreparedStatement prepInsert = con.prepareStatement("insert into personne(pers_id, pers_prenom, pers_nom) values(?,?,?)");
        prepInsert.setInt(1, -5);
        prepInsert.setString(2, "Test");
        prepInsert.setString(3, "123");
        prepInsert.execute();
        prepInsert.setInt(1, -6);
        prepInsert.setString(2, "Abc");
        prepInsert.setString(3, "Def");
        prepInsert.execute();
        print();

        PreparedStatement prepUpdate = con.prepareStatement("update personne set pers_prenom = ? where pers_id = ?");
        prepUpdate.setString(1, "L'hirondelle");
        prepUpdate.setInt(2, -5);
        prepUpdate.execute();
        print();

        PreparedStatement prepDelete = con.prepareStatement("delete from personne where pers_id = ?");
        prepDelete.setInt(1, -5);
        prepDelete.execute();
        print();
    }


    /* TYPE_SCROLL_SENSTIVE => pour voir les modifs de tout le monde */

    public void print() throws SQLException {
        System.out.println("-----------------------");
        // établissement de la connexion
        stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        // requête
        stmt.execute("select pers_id, pers_prenom, pers_nom from personne order by pers_id");
        // récupération du retour de la requête
        ResultSet r = stmt.getResultSet();
        // tant qu'on a des résultats
        while (r.next()) {
            // on affiche les informations que l'on souhaite
            System.out.println(r.getInt("pers_id") +
                    "\t" + r.getString("pers_prenom") +
                    "\t" + r.getString("pers_nom"));
        }
        System.out.println("\n");
        // fermeture de la connexion
        //stmt.close();
    }
}
