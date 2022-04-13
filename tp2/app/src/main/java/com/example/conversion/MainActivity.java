package com.example.conversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button convert = (Button) findViewById(R.id.convertir);
        final EditText input = (EditText) findViewById(R.id.input);
        final RadioButton radioBtn1 = (RadioButton) findViewById(R.id.radio1);
        final RadioButton radioBtn2 = (RadioButton) findViewById(R.id.radio2);
        final TextView result = (TextView) findViewById(R.id.resultat);
        try {
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float in = Float.parseFloat(input.getText().toString());
                if(radioBtn1.isChecked()) {
                    result.setText("result: " + euroToDinar(in));
                }else if(radioBtn2.isChecked()){
                    result.setText("result: " + dinarToEuro(in));
                }else{
                    result.setText("dazdza");
                }
            }
        });
        }catch (Exception e){
            result.setText(e.getMessage());
        }
    }

    private float euroToDinar(float valeurEuro){
        return (float)(valeurEuro * 2.95);
    }
    private float dinarToEuro(float valeurDinar){
        return (float)(valeurDinar * 0.34);
    }
}