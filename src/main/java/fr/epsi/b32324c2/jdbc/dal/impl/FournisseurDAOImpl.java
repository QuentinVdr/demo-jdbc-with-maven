package fr.epsi.b32324c2.jdbc.dal.impl;

import fr.epsi.b32324c2.jdbc.dal.IFournisseurDAO;
import fr.epsi.b32324c2.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static fr.epsi.b32324c2.Main.*;

public class FournisseurDAOImpl implements IFournisseurDAO {

    private static final String INSERT_QUERY = "INSERT INTO FOURNISSEUR (nom) VALUES ('%s')";
    private static final String UPDATE_QUERY = "UPDATE FOURNISSEUR SET nom ='%s' WHERE id=%d";
    private static final String DELETE_QUERY = "DELETE FROM FOURNISSEUR WHERE id='%d'";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM FOURNISSEUR";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM FOURNISSEUR WHERE id='%d'";

    @Override
    public void insert(Fournisseur fournisseur) throws SQLException {
        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PW)) {
            try (Statement statement = cnx.createStatement()) {
                statement.executeQuery(String.format(INSERT_QUERY, fournisseur.getNom()));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void update(Fournisseur fournisseur) throws SQLException {
        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PW)) {
            try (Statement statement = cnx.createStatement()) {
                statement.executeUpdate(String.format(UPDATE_QUERY, fournisseur.getNom(), fournisseur.getId()));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void delete(Fournisseur fournisseur) throws SQLException {
        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PW)) {
            try (Statement statement = cnx.createStatement()) {
                statement.executeQuery(String.format(DELETE_QUERY, fournisseur.getId()));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public Fournisseur getById(int id) throws SQLException {
        Fournisseur fournisseur = new Fournisseur();
        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PW)) {
            try (Statement statement = cnx.createStatement()) {
                ResultSet cursor = statement.executeQuery(String.format(SELECT_BY_ID_QUERY, id));
                int idFournisseur = cursor.getInt("ID");
                String nomFournisseur = cursor.getString("NOM");
                fournisseur.setId(idFournisseur);
                fournisseur.setNom(nomFournisseur);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return fournisseur;
    }

    @Override
    public List<Fournisseur> getAll() throws SQLException {
        List<Fournisseur> fournisseurs = new ArrayList<>();
        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PW)) {
            try (Statement statement = cnx.createStatement()) {
                ResultSet cursor = statement.executeQuery(String.format(SELECT_ALL_QUERY));

                while (cursor.next()) {
                    int id = cursor.getInt("ID");
                    String nom = cursor.getString("NOM");
                    fournisseurs.add(new Fournisseur(id, nom));
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return fournisseurs;
        }
    }
}
