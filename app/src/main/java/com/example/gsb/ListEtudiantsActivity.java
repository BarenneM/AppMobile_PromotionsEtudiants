package com.example.gsb;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

    private IServiceRest serviceRest;
    private String TAG = "ListEtudiantsActivity";
    private List<Etudiant> etudiants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listetudiant);
        //List<Etudiant> etudiants;
        

        //String acronyme = (String) getIntent().getSerializableExtra("acronyme");
        etudiants = (ArrayList<Etudiant>) getIntent().getSerializableExtra("etudiants");
        Log.i(TAG,"Etudiants  = "+ etudiants);

        //serviceRest = ServiceRest.getInstance();

        /*serviceRest.getEtudiant(acronyme).enqueue(new Callback<List<Etudiant>>() {
            

            @Override
            public void onResponse(Call<List<Etudiant>> call, Response<List<Etudiant>> response) {

                if (response.isSuccessful()) {
                    etudiants = response.body();
                    Log.i(TAG,"Etudiants  = "+ etudiants);
                }

            }
            @Override
            public void onFailure(Call<List<Etudiant>> call, Throwable t) {
                Log.i(TAG,"ERREUR - getListEtudiant");
            }

        });*/

        ListView etudiantListView = findViewById(R.id.listView);
        etudiantListView.setAdapter(new ListEtudiantItemAdapter(this,  etudiants));

    }

}
