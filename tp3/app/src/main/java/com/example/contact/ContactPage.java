package com.example.contact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.BundleCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ContactPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_page);

        TextView contactName = (TextView) findViewById(R.id.contactName);
        TextView contactEmail = (TextView) findViewById(R.id.contactEmail);
        TextView contactPhone = (TextView) findViewById(R.id.contactPhone);
        TextView contactWebsite = (TextView) findViewById(R.id.contactWebsite);

        Bundle extras = getIntent().getExtras();
        if(extras == null){
            return;
        }

        ContactObject co = (ContactObject) getIntent().getSerializableExtra("Object");
        contactName.setText(co.getName());
        contactEmail.setText(co.getMail());
        contactPhone.setText(co.getPhone());
        contactWebsite.setText(co.getWeb());

        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String url = contactWebsite.getText().toString();

                Uri webpage = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

                if(intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }else{
                    Log.d("ImplicitIntents", "cant handle intent!");
                }
            }
        });


    }
}