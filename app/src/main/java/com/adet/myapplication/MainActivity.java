package com.adet.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    EditText etEmail, etPassword;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail=findViewById(R.id.editTextTextEmailAddress);
        etPassword=findViewById(R.id.editTextTextPassword);
        login=findViewById(R.id.button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //add functions after clicking the button here

                String email, password, name, logEmail, logPassword;

                email=getIntent().getStringExtra("Email");
                password=getIntent().getStringExtra("Password");
                name= getIntent().getStringExtra("Fname");

                logEmail=etEmail.getText().toString().trim();
                logPassword=etPassword.getText().toString().trim();

                if (logEmail.equals(email) && logPassword.equals(password)){
                    Intent i= new Intent(getApplicationContext(), homepage.class);
                    i.putExtra("Name", name);
                    i.putExtra("Email", email);
                    startActivity(i);
                }else{
                    //Toast.makeText(getApplicationContext(), "Wala ka pang account!", Toast.LENGTH_LONG).show();

                    Snackbar.make(view, "Wala ka pang account!", Snackbar.LENGTH_INDEFINITE)
                            .setAction("REGISTER NA!", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    //add function for the snackbar action here

                                    Intent intent= new Intent(getApplicationContext(), register.class);
                                    startActivity(intent);
                                }
                            })
                            .show();

                }
            }
        });

    }

    public void register(View view){

        Intent intent= new Intent(getApplicationContext(), register.class);
        startActivity(intent);
    }


}