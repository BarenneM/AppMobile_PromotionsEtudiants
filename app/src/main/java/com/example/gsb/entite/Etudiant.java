package com.example.gsb.entite;

import java.io.Serializable;

public class Etudiant implements Serializable {
    private Long id;
    private String nom;
    private String prenom;
    private int nbRetard;
    private int nbAbsence;
    public Etudiant() {}
    public Etudiant(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public int getNbRetard() {
        return nbRetard;
    }
    public void setNbRetard(int nbRetard) {
        this.nbRetard = nbRetard;
    }
    public int getNbAbsence() {
        return nbAbsence;
    }
    public void setNbAbsence(int nbAbsence) {
        this.nbAbsence = nbAbsence;
    }
    @Override
    public String toString() {
        return "Etudiant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", nbRetard="
                + nbRetard + ", nbAbsence=" + nbAbsence + "]";
    }
}
