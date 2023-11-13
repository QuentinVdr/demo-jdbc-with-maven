package fr.epsi.b32324c2.jdbc;

import fr.epsi.b32324c2.jdbc.dal.IFournisseurDAO;
import fr.epsi.b32324c2.jdbc.dal.impl.FournisseurDAOImpl;
import fr.epsi.b32324c2.jdbc.entites.Fournisseur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestDelete {

    public static void main(String[] args) {
        IFournisseurDAO fournisseurDAO = new FournisseurDAOImpl();
        try {
            fournisseurDAO.delete(new Fournisseur(6));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
