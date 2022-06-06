package com.adet.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class homepage extends AppCompatActivity {

    TextView displayName, displayEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        displayName= findViewById(R.id.textView3);
        displayEmail= findViewById(R.id.textView4);

        String name, email;

        name=getIntent().getStringExtra("Name");
        email=getIntent().getStringExtra("Email");

        displayName.setText(name);
        displayEmail.setText(email);

    }
}