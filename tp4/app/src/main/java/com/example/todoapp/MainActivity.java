package com.example.todoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mShowDialog = (Button) findViewById(R.id.loginBtn);

        Button btn = (Button) findViewById(R.id.mainBtn);

        registerForContextMenu(btn);

        mShowDialog.setOnClickListener((view -> {
            AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
            View mView = getLayoutInflater().inflate(R.layout.dialog_login, null);
            final TextInputLayout mEmail = (TextInputLayout) mView.findViewById(R.id.emailField);
            final TextInputLayout mPassword = (TextInputLayout) mView.findViewById(R.id.passField);
            Button mLogin = (Button) mView.findViewById(R.id.loginBtn);
            Button mCancel = (Button) mView.findViewById(R.id.cancelBtn);
            mLogin.setOnClickListener(view1 -> {
                if (!mEmail.getEditText().getText().toString().isEmpty() && !mPassword.getEditText().getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, R.string.success_login_msg, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, R.string.error_login_msg, Toast.LENGTH_SHORT).show();
                }
            });

            mBuilder.setView(mView);
            AlertDialog dialog = mBuilder.create();
            dialog.show();
            mCancel.setOnClickListener(view1 -> {
                dialog.dismiss();
            });
        }));

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, v.getId(), 0, "liste de taches");
        menu.add(0, v.getId(), 0, "nombre total");
        menu.add(0, v.getId(), 0, "plus ..");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getTitle() == "liste de taches") {
            Intent in = new Intent(MainActivity.this, ListeTache.class);
            startActivity(in);
        } else if (item.getTitle() == "nombre total") {
            Toast.makeText(MainActivity.this, "0 Rien", Toast.LENGTH_LONG).show();
        } else if (item.getTitle() == "plus ..") {
            Uri webpage = Uri.parse("https://www.google.com");
            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

            startActivity(intent);

        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inf = getMenuInflater();
        inf.inflate(R.menu.menu_res_file, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(this, "you have selected item 1", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Toast.makeText(this, "you have selected item 2", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:
                Toast.makeText(this, "you have selected item 3", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item4:
                Toast.makeText(this, "you have selected item 4", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item5:
                Toast.makeText(this, "you have selected item 5", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item6:
                Toast.makeText(this, "you have selected item 6", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item7:
                Toast.makeText(this, "you have selected item 7", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item8:
                Toast.makeText(this, "you have selected item 8", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item9:
                Toast.makeText(this, "you have selected item 9", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item10:
                Toast.makeText(this, "you have selected item 10", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}