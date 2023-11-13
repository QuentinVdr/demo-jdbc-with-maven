package fr.epsi.b32324c2.jdbc.dal;

import fr.epsi.b32324c2.jdbc.entites.Fournisseur;

import java.sql.SQLException;
import java.util.List;

public interface IFournisseurDAO {

    /**
     * Insert a fournisseur into the database
     * @param fournisseur the fournisseur to insert
     */
    void insert(Fournisseur fournisseur) throws SQLException;

    /**
     * Update a fournisseur in the database
     * @param fournisseur the fournisseur to update
     */
    void update(Fournisseur fournisseur) throws SQLException;

    /**
     * Delete a fournisseur from the database
     * @param fournisseur the fournisseur to delete
     */
    void delete(Fournisseur fournisseur) throws SQLException;

    /**
     * Get a fournisseur from the database
     * @param id the id of the fournisseur to get
     * @return the fournisseur
     */
    Fournisseur getById(int id) throws SQLException;

    /**
     * Get all fournisseurs from the database
     * @return the list of fournisseurs
     */
    List<Fournisseur> getAll() throws SQLException;
}
