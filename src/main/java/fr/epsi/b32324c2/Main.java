package fr.epsi.b32324c2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class Main {
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
            System.out.println(cnx);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
