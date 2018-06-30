package com.example.gabri.afinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    Button btn;
    Spinner spinner;
    ArrayAdapter adapter;
    ListView listView;

    EditText tempo;
    EditText velocidade;

    Atividade a;
    int num = 0;

    ArrayList<Atividade> atividadeArrayList;
    String nome;
    int peso;
    double altura;
    double IMC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intentStart = getIntent();
        nome = intentStart.getStringExtra("nome");
        peso = Integer.valueOf(intentStart.getStringExtra("peso"));
        altura = Double.valueOf(intentStart.getStringExtra("altura"));
        altura = altura/100;
        atividadeArrayList = new ArrayList<Atividade>();

        listView = (ListView) findViewById(R.id.listView1);
        tempo = (EditText) findViewById(R.id.editText);
        velocidade = (EditText)findViewById(R.id.editText2);

        spinner = (Spinner) findViewById(R.id.spinner);

       ArrayAdapter<CharSequence> adp;
       adp = ArrayAdapter.createFromResource(this, R.array.spinner, android.R.layout.simple_spinner_item);
       adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       spinner.setAdapter(adp);

       listView.setOnItemClickListener(this);

       btn = (Button)findViewById(R.id.button);
       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               call();
           }
       });
    }

    public void call(){
        adapter = new AtividadeAdapter(this, addAtividade());
        listView.setAdapter(adapter);
    }

    private ArrayList<Atividade> addAtividade(){

        num = atividadeArrayList.size();
         a = new Atividade(spinner.getSelectedItem().toString(), Integer.valueOf(tempo.getText().toString()), Integer.valueOf(velocidade.getText().toString()), num + 1);
        atividadeArrayList.add(a);

        return atividadeArrayList;
    }

    public String IMCcalc(int peso, double altura){
        IMC = peso/(altura*altura);
        DecimalFormat df =  new DecimalFormat("0.##");
        String s = df.format(IMC);
        return s;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(MainActivity.this, this.getString(R.string.nome)+":"+nome+", IMC:"+String.valueOf(IMCcalc(peso,altura))+","+atividadeArrayList.get(position).getTipo(), Toast.LENGTH_SHORT).show();
    }
}
