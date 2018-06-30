package com.example.gabri.afinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AtividadeAdapter extends ArrayAdapter<Atividade> {

private final Context context;
private final ArrayList<Atividade> elementos;

public AtividadeAdapter(Context context, ArrayList<Atividade> elementos){
    super(context, R.layout.row, elementos);

    this.context = context;
    this.elementos = elementos;
}

@Override
    public View getView(int position, View convertView, ViewGroup parent){
    LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

    View rowView = inflater.inflate(R.layout.row, parent, false);

    TextView tipo = (TextView) rowView.findViewById(R.id.textView3);
    TextView tempo = (TextView) rowView.findViewById(R.id.textView2);
    TextView km = (TextView) rowView.findViewById(R.id.textView4);
    TextView num = (TextView) rowView.findViewById(R.id.textView);

    tipo.setText(elementos.get(position).getTipo());
    tempo.setText(String.valueOf(elementos.get(position).getTempo())+" " +context.getString(R.string.minutos));
    km.setText(String.valueOf(elementos.get(position).getKm())+" km/h");
    num.setText(String.valueOf(elementos.get(position).getNum()));

    return rowView;
}

}
