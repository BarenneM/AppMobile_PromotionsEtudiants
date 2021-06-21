package com.example.gsb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.gsb.entite.Promotion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PromotionActivity extends AppCompatActivity  {

  //  private ArrayAdapter<String> adapter;
  private static String TAG= "PromotionActivity";
  private Boolean downloaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion);

        ArrayList<Promotion> promotions = (ArrayList<Promotion>) getIntent().getSerializableExtra("promotions");

        // Liste des promotions
        //List<Promotion> promotions = new ArrayList<Promotion>();
        //promotions.add(new Promotion("CDA", "Concepteur developpeur"));
        //promotions.add(new Promotion("DWWM", "Developpeur web et web mobil"));

        ListView promotionListView = findViewById(R.id.listView);
        promotionListView.setAdapter(new PromotionItemAdapter(this,  promotions));

        Log.i(TAG,"Promotions  = "+ promotions);


        //setContentView(R.layout.adapter_item);
        //Button listEtudiant = (Button)findViewById(R.id.listEtudiant);
        //listEtudiant.setOnClickListener(this);


        /*
        // On cree l'ArrayAdapter
        ArrayAdapter<String> listDataAdapter = new ArrayAdapter<String>(this, R.layout.activity_list_rapport_row, R.id.listRowTextView, listData);

        // On set cet adapter sur l'objet ListView interne
        this.setListAdapter(listDataAdapter);
         */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, Menu.NONE, "Accueil");
        menu.add(0, 2, Menu.NONE, "Voir toutes les promotions");
        menu.add(0, 3, Menu.NONE, "Voir tous les étudiants");
        menu.add(0, 4, Menu.NONE, "Ajouter un étudiant");
        return true;
    }

    // Process clicks on Options Menu items
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        Log.i(TAG, "itemId=" + itemId);
        if(itemId == 1){
            Intent intent = new Intent(PromotionActivity.this, MainActivity.class);
            startActivity(intent);
            return true;
        }
        else if(itemId == 2){
            Log.i(TAG, "Voir toutes les promotions");
            return true;
        }
        else if(itemId == 3) {
            Log.i(TAG, "Voir tous les étudiants");
            return true;
        }
        else if(itemId == 4) {
            Log.i(TAG, "Ajouter un étudiant");
            Intent intent = new Intent(PromotionActivity.this, EtudiantActivity.class);
            startActivity(intent);
            return true;
        }
        else return false;
    }

    /*
    @Override
    public void onClick(View v) {
        //ouverture d'une nouvelle IHM Dynamique qui affichera la liste des étudiants de la promotion
        Intent intent = new Intent(PromotionActivity.this, ListEtudiantsActivity.class);
        //intent.putExtra("acronyme", acronyme);
        startActivity(intent);
    }*/


}