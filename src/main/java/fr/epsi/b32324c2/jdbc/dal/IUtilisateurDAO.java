package fr.epsi.b32324c2.jdbc.dal;

import fr.epsi.b32324c2.jdbc.entites.Utilisateur;

import java.sql.SQLException;

public interface IUtilisateurDAO {
    Utilisateur login(String login, String password) throws SQLException;
    Utilisateur securedLogin(String login, String password) throws SQLException;
}
