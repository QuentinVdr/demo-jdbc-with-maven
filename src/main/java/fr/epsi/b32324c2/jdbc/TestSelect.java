package fr.epsi.b32324c2.jdbc;

import fr.epsi.b32324c2.jdbc.entites.Fournisseur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TestSelect {
    public static final String DB_URL;
    public static final String DB_USER;
    public static final String DB_PW;

    static {
        ResourceBundle dbConf = ResourceBundle.getBundle("database");
        DB_URL = dbConf.getString("database.URL");
        DB_USER = dbConf.getString("database.USER");
        DB_PW = dbConf.getString("database.PW");
    }

    public static void main(String[] args) {
        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PW)) {
            try (Statement statement = cnx.createStatement()) {
                ResultSet cursor = statement.executeQuery("SELECT * FROM FOURNISSEUR");

                List<Fournisseur> fournisseurs = new ArrayList<>();
                while (cursor.next()) {
                    int id = cursor.getInt("ID");
                    String nom = cursor.getString("NOM");
                    fournisseurs.add(new Fournisseur(id, nom));
                }
                fournisseurs.forEach(System.out::println);
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
