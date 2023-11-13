package fr.epsi.b32324c2.jdbc;

import fr.epsi.b32324c2.jdbc.dal.IFournisseurDAO;
import fr.epsi.b32324c2.jdbc.dal.impl.FournisseurDAOImpl;
import fr.epsi.b32324c2.jdbc.entites.Fournisseur;

public class TestInsertion {

    public static void main(String[] args) {
        IFournisseurDAO fournisseurDAO = new FournisseurDAOImpl();
        try {
            fournisseurDAO.insert(new Fournisseur("EPSI"));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
