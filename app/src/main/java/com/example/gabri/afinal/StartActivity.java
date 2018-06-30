package com.example.gabri.afinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {
    Button button;
    EditText nome;
    EditText idade;
    EditText peso;
    EditText altura;
    RadioButton radio;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        button =  (Button)  findViewById(R.id.button);
        nome = (EditText) findViewById(R.id.nome);
        idade = (EditText) findViewById(R.id.idade);
        peso = (EditText) findViewById(R.id.peso);
        altura = (EditText) findViewById(R.id.altura);
        radioGroup = (RadioGroup)findViewById(R.id.radioGrupo);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioGroup.setSelected(true);
                if(nome.getText().toString().equals("")){
                    Toast.makeText(StartActivity.this, "Insira um nome !", Toast.LENGTH_SHORT).show();
                }else  if(idade.getText().toString().equals("")){
                    Toast.makeText(StartActivity.this, "Insira uma idade", Toast.LENGTH_SHORT).show();
                }else if(peso.getText().toString().equals("")){
                    Toast.makeText(StartActivity.this, "Insira um peso", Toast.LENGTH_SHORT).show();
                }else if (altura.getText().toString().equals("")){
                    Toast.makeText(StartActivity.this, "Insira uma altura", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(StartActivity.this, MainActivity.class);
                    intent.putExtra("nome", nome.getText().toString());
                    intent.putExtra("idade", idade.getText().toString());
                    intent.putExtra("peso", peso.getText().toString());
                    intent.putExtra("altura", altura.getText().toString());


                    int Selected = radioGroup.getCheckedRadioButtonId();
                    radio = (RadioButton) findViewById(Selected);

                    //Toast.makeText(MainActivity.this, radio.getText(), Toast.LENGTH_SHORT).show();

                    intent.putExtra("genero", radio.getText());

                    intent.putExtra("tipo",1);

                    startActivity(intent);
                }




            }
        });

    }
}
