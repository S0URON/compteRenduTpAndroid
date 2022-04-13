package com.example.contact;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = findViewById(R.id.listView1);

        final ArrayList<ContactObject> listObject = new ArrayList<ContactObject>();

        listObject.add(new ContactObject("foulen ben foulen", "https://www.google.com", "sousse, chatt meriem", "52045911", "example@email.com"));
        listObject.add(new ContactObject("foulen ben foulen", "http://google.com", "sousse, chatt meriem", "52045911", "example@email.com"));
        listObject.add(new ContactObject("foulen ben foulen", "http://google.com", "sousse, chatt meriem", "52045911", "example@email.com"));

        List<String> listName = new ArrayList<String>();

        for(int i=0;i<listObject.size();i++){
            listName.add(listObject.get(i).getName());
        }

        ArrayAdapter<String> ad = new ArrayAdapter<String>(MainActivity.this,R.layout.activity_main, R.id.textView1,listName);
        lv.setAdapter(ad);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent in = new Intent(MainActivity.this, ContactPage.class);
                in.putExtra("Object",listObject.get(i));
                startActivity(in);
            }
        });
    }
}