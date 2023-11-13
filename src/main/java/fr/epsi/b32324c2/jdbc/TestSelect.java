package fr.epsi.b32324c2.jdbc;

import fr.epsi.b32324c2.jdbc.dal.IFournisseurDAO;
import fr.epsi.b32324c2.jdbc.dal.impl.FournisseurDAOImpl;

public class TestSelect {

    public static void main(String[] args) {
        IFournisseurDAO fournisseurDAO = new FournisseurDAOImpl();
        try {
            System.out.println(fournisseurDAO.getById(7).toString());
            System.out.println(fournisseurDAO.getAll().toString());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
