package fr.epsi.b32324c2.jdbc.entites;

import java.sql.ResultSet;
import java.util.List;

public class Fournisseur {
    private int id;
    private String nom;

    public Fournisseur() {
    }
    public Fournisseur(int id) {
        this.id = id;
    }

    public Fournisseur(String nom) {
        this.nom = nom;
    }

    public Fournisseur(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Fournisseur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
