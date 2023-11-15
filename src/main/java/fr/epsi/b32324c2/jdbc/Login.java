package fr.epsi.b32324c2.jdbc;

import fr.epsi.b32324c2.jdbc.dal.impl.UtilisateurDAOImpl;
import fr.epsi.b32324c2.jdbc.entites.Utilisateur;

import java.sql.SQLException;
import java.util.Scanner;

public class Login {

    public static void main(String[] args) {
        System.out.println("***** Bienvenue dans l'App *****");

        System.out.println("* Merci de vous identifier...");

        Scanner scanner = new Scanner(System.in);
        System.out.print("* Entrez votre login : ");
        String loginSaisi = scanner.nextLine();
        System.out.print("* Entrez votre mot de passe : ");
        String mdpSaisi = scanner.nextLine();

        UtilisateurDAOImpl dao = new UtilisateurDAOImpl();
        try {
            Utilisateur user = dao.securedLogin(loginSaisi, mdpSaisi);
            if (null != user) {
                System.out.printf("* Bienvenue à toi %s%n ", user.getLogin());
            } else {
                System.out.println("* Erreur d'authentification...");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
