package com.example.gsb.entite;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class Promotion implements Serializable {
    private String acronyme;
    private String intitule;
    private List<Etudiant> etudiants;
    public Promotion() {}
    public Promotion(String acronyme, String titre) {
        System.out.println("Promotion - constructeur");
        this.intitule = titre;
        this.acronyme = acronyme;
        etudiants = new ArrayList<Etudiant>();
    }
    public void addEtudiant(Etudiant etudiant) {
        etudiants.add(etudiant);
    }
    public String getAcronyme() {
        return acronyme;
    }
    public void setAcronyme(String acronyme) {
        this.acronyme = acronyme;
    }
    public String getIntitule() {
        return intitule;
    }
    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }
    public List<Etudiant> getEtudiants() {
        return etudiants;
    }
    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }
    @Override
    public String toString() {
        return "Promotion [acronyme=" + acronyme + ", intitule=" + intitule + ", etudiants=" + etudiants + "]";
    }
}
