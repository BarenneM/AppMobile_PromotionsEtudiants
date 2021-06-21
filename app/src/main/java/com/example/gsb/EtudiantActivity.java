package com.example.gsb;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gsb.entite.Promotion;
import com.example.gsb.rest.IServiceRest;
import com.example.gsb.rest.ServiceRest;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EtudiantActivity extends AppCompatActivity implements View.OnClickListener {

    public String TAG = "EtudiantActivity";
    public String TAGnom = "EditText";
    public String TAGprenom = "EditText";
    private EditText nom;
    private EditText prenom;
    private TextView resultatTexte;
    private IServiceRest serviceRest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etudiant);

        serviceRest = ServiceRest.getInstance();
        nom = (EditText)findViewById(R.id.nom);
        prenom = (EditText)findViewById(R.id.prenom);
        resultatTexte = (TextView)findViewById(R.id.result);

        Button submit = (Button)findViewById(R.id.submit);
        submit.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, Menu.NONE, "Voir toutes les promotions");
        menu.add(0, 2, Menu.NONE, "Voir tous les étudiants");
        menu.add(0, 3, Menu.NONE, "Ajouter une promotions");
        return true;
    }

    // Process clicks on Options Menu items
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        Log.i(TAG, "itemId=" + itemId);
        if(itemId == 1){
            Log.i(TAG, "Voir toutes les promotions");
            serviceRest.getPromotions().enqueue(new Callback<List<Promotion>>() {
                @Override
                public void onResponse(Call<List<Promotion>> call, Response<List<Promotion>> response) {

                    if (response.isSuccessful()) {
                        List<Promotion> promotions = response.body();
                        Log.i(TAG,"promotions=" + promotions);
                        Intent intent = new Intent(EtudiantActivity.this, PromotionActivity.class);
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
        else if(itemId == 2) {
            Log.i(TAG, "Voir tous les étudiants");
            return true;
        }
        else if(itemId == 3) {
            Log.i(TAG, "Ajouter une promotions");
            return true;
        }
        else return false;
    }

    @Override
    public void onClick(View v) {
        Log.i(TAGnom,"Nom = "+nom.getText().toString());
        Log.i(TAGprenom,"Prénom = "+prenom.getText().toString());
        resultatTexte.setText(nom.getText().toString() + " " + prenom.getText().toString());
    }
}
