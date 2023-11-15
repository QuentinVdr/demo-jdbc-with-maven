package fr.epsi.b32324c2.jdbc.dal.impl;

import fr.epsi.b32324c2.jdbc.dal.IUtilisateurDAO;
import fr.epsi.b32324c2.jdbc.entites.Utilisateur;

import java.sql.*;

import static fr.epsi.b32324c2.Main.*;

public class UtilisateurDAOImpl implements IUtilisateurDAO {

    private static final String LOGIN_QUERY = "SELECT * FROM utilisateur WHERE LOGIN = '%s' AND PASSWORD = '%s'";
    private static final String SECURED_LOGIN_QUERY = "SELECT * FROM utilisateur WHERE LOGIN = ? AND PASSWORD = ?";

    @Override
    public Utilisateur login(String login, String pwd) throws SQLException {
        Utilisateur utilisateur = null;
        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PW);
             Statement st = cnx.createStatement();
             ResultSet rs = st.executeQuery(String.format(LOGIN_QUERY, login, pwd))) {
            if (rs.next()) {
                int id = rs.getInt("ID");
                String identifiant = rs.getString("LOGIN");
                String password = rs.getString("PASSWORD");
                utilisateur = new Utilisateur(id, identifiant, password);
            }
        }
        return utilisateur;
    }

    @Override
    public Utilisateur securedLogin(String login, String pwd) throws SQLException {
        Utilisateur utilisateur = null;
        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PW);
             PreparedStatement pst = cnx.prepareStatement(SECURED_LOGIN_QUERY);) {
            pst.setString(1, login);
            pst.setString(2, pwd);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("ID");
                    String identifiant = rs.getString("LOGIN");
                    String password = rs.getString("PASSWORD");
                    utilisateur = new Utilisateur(id, identifiant, password);
                }
            }
        }
        return utilisateur;
    }
}
