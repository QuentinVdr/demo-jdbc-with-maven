package fr.epsi.b32324c2.jdbc;

import fr.epsi.b32324c2.jdbc.dal.IFournisseurDAO;
import fr.epsi.b32324c2.jdbc.dal.impl.FournisseurDAOImpl;
import fr.epsi.b32324c2.jdbc.entites.Fournisseur;

public class TestUpdate {

    public static void main(String[] args) {
        IFournisseurDAO fournisseurDAO = new FournisseurDAOImpl();
        try {
            fournisseurDAO.update(new Fournisseur(6, "Epsi"));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
