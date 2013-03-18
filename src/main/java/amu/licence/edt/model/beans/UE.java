package amu.licence.edt.model.beans;

import java.awt.Color;

//@Entity
public class UE {

//    @Id
//    @GeneratedValue
    private int id;
    private String libelle;
    private Color couleur;

    public UE() {}
    public UE(String libelle, Color couleur) {
        this.libelle = libelle;
        this.couleur = couleur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

}
