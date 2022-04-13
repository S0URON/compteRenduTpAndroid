package com.example.tp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    float height;
    float weight;
    float imc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button calculer = (Button) findViewById(R.id.calculer);
        final EditText height_value = (EditText) findViewById(R.id.taille);
        final EditText weight_value = (EditText) findViewById(R.id.poid);
        final TextView result = (TextView) findViewById(R.id.resultat);
        height_value.setInputType(android.text.InputType.TYPE_CLASS_NUMBER);
        weight_value.setInputType(android.text.InputType.TYPE_CLASS_NUMBER);
        calculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(height_value.getText().length() > 0 && weight_value.getText().length() > 0){
                        height = Float.parseFloat(height_value.getText().toString());
                        weight = Float.parseFloat(weight_value.getText().toString());
                        imc = CalculerIMC(weight, height);

                        if(imc < 16){
                            result.setText("Votre IMC est:" + imc + " Vous étes trop maigre!");
                        }else if(imc < 18.5){
                            result.setText("Votre IMC est:" + imc + " Vous étes maigre!");
                        }else if(imc < 25){
                            result.setText("Votre IMC est:" + imc + " Vous étes normal!");
                        }else if(imc < 30){
                            result.setText("Votre IMC est:" + imc + " Vous étes gros(se)!");
                        }else{
                            result.setText("Votre IMC est:" + imc + " Vous étes obèse!");
                        }
                    }
                }catch(Exception e){
                    result.setText("error occured " + e.getMessage().substring(17));
                }
            }
        });
    }

    static float CalculerIMC(float weight, float height){
        return weight / height;
    }
}