package com.example.gsb;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gsb.entite.Etudiant;
import com.example.gsb.entite.Promotion;
import com.example.gsb.rest.IServiceRest;
import com.example.gsb.rest.ServiceRest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListEtudiantsActivity  extends AppCompatActivity  {

    private String TAG = "ListEtudiantsActivity";
    private IServiceRest serviceRest;
    private List<Etudiant> etudiants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        serviceRest = ServiceRest.getInstance();
        setContentView(R.layout.activity_listetudiant);

        etudiants = (ArrayList<Etudiant>) getIntent().getSerializableExtra("etudiants");
        Log.i(TAG,"Etudiants  = "+ etudiants);


        ListView etudiantListView = findViewById(R.id.listView);
        etudiantListView.setAdapter(new ListEtudiantItemAdapter(this,  etudiants));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, Menu.NONE, "Accueil");
        menu.add(0, 2, Menu.NONE, "Voir toutes les promotions");
        menu.add(0, 3, Menu.NONE, "Ajouter un étudiant");
        return true;
    }

    // Process clicks on Options Menu items
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        Log.i(TAG, "itemId=" + itemId);
        if(itemId == 1){
            Intent intent = new Intent(ListEtudiantsActivity.this, MainActivity.class);
            startActivity(intent);
            return true;
        }
        else if(itemId == 2){
            Log.i(TAG, "Voir toutes les promotions");
            serviceRest.getPromotions().enqueue(new Callback<List<Promotion>>() {
                @Override
                public void onResponse(Call<List<Promotion>> call, Response<List<Promotion>> response) {

                    if (response.isSuccessful()) {
                        List<Promotion> promotions = response.body();
                        Log.i(TAG,"promotions=" + promotions);
                        Intent intent = new Intent(ListEtudiantsActivity.this, PromotionActivity.class);
                        intent.putExtra("promotions", (Serializable) promotions);
                        startActivity(intent);
                    }

                }
                @Override
                public void onFailure(Call<List<Promotion>> call, Throwable t) {
                    Log.i(TAG,"ERREUR - getPromotions");
                }

            });
            return true;
        }
        else if(itemId == 3) {
            Log.i(TAG, "Ajouter un étudiant");
            Intent intent = new Intent(ListEtudiantsActivity.this, EtudiantActivity.class);
            startActivity(intent);
            return true;
        }
        else return false;
    }

}
