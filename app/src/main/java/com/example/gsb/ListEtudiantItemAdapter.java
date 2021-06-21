package com.example.gsb;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.gsb.entite.Etudiant;
import com.example.gsb.entite.Promotion;
import com.example.gsb.rest.IServiceRest;

import java.util.List;

public class ListEtudiantItemAdapter extends BaseAdapter {

    private Context context;
    private List<Etudiant> etudiants;
    private LayoutInflater inflater;

    // constructeur
    public ListEtudiantItemAdapter(Context context, List<Etudiant> etudiants) {
        this.context = context;
        this.etudiants = etudiants;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return etudiants.size();
    }

    @Override
    public Etudiant getItem(int position) {
        return etudiants.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        view = inflater.inflate(R.layout.adapter_itemsetudiant, null);

        //Recuperer le infos de l'objet courrant
        Etudiant currentEtudiant = getItem(i);
        //Long itemId = currentEtudiant.getId();
        String itemNom = currentEtudiant.getNom();
        String itemPrenom = currentEtudiant.getPrenom();
        //int itemNbRetard = currentEtudiant.getNbRetard();
        //int itemNbAbs = currentEtudiant.getNbAbsence();


        //On recupere le champs dans lequel on doit positionner les attributs
        TextView itemNomView = view.findViewById(R.id.item_nom);
        itemNomView.setText(itemNom);
        TextView itemPrenomView = view.findViewById(R.id.item_prenom);
        itemPrenomView.setText(itemPrenom);
        /*TextView itemNbRetardView = view.findViewById(R.id.item_nbRetard);
        itemNbRetardView.setText(itemNbRetard);
        TextView itemNbAbsView = view.findViewById(R.id.item_nbAbs);
        itemNbAbsView.setText(itemNbAbs);*/

        return view;
    }
}

