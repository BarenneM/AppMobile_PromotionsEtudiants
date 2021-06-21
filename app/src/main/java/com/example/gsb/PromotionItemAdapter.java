package com.example.gsb;

import android.content.Context;
import android.content.DialogInterface;
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

import java.io.Serializable;
import java.util.List;

public class PromotionItemAdapter extends BaseAdapter {

    private Context context;
    private List<Promotion> promotions;
    private LayoutInflater inflater;
    private IServiceRest serviceRest;

    // constructeur
    public PromotionItemAdapter(Context context, List<Promotion> promotions) {
        this.context = context;
        this.promotions = promotions;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return promotions.size();
    }

    @Override
    public Promotion getItem(int position) {
        return promotions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        view = inflater.inflate(R.layout.adapter_item, null);

        //Recuperer le infos de l'objet courrant
        Promotion currentPromotion = getItem(i);
        String itemAcronyme = currentPromotion.getAcronyme();
        String itemIntitule = currentPromotion.getIntitule();
        List<Etudiant> etudiants = currentPromotion.getEtudiants();

        //On recupere le champs dans lequel on doit positionner le motif et le bilan
        TextView itemMotifView = view.findViewById(R.id.item_acronyme);
        itemMotifView.setText(itemAcronyme);
        TextView itemBilanView = view.findViewById(R.id.item_intitule);
        itemBilanView.setText(itemIntitule);

        //holder.line = (LinearLayout) v.findViewById(R.id.line_);
        Button listEtudiant = (Button) view.findViewById(R.id.listEtudiant);

        listEtudiant.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, ListEtudiantsActivity.class);
                //intent.putExtra("acronyme", itemAcronyme);
                intent.putExtra("etudiants", (Serializable) etudiants);
                context.startActivity(intent);
            }
        });

        return view;
    }
}
