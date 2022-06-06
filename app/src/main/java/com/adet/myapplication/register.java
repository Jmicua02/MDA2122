package com.adet.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class register extends AppCompatActivity {

    EditText etID, etFname, etLname, etEmail, etPassword;
    Button btnRegister;
    //TextView testDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etID= findViewById(R.id.editTextNumber);
        etFname=findViewById(R.id.editTextTextPersonName);
        etLname=findViewById(R.id.editTextTextPersonName2);
        etEmail=findViewById(R.id.editTextTextEmailAddress);
        etPassword=findViewById(R.id.editTextTextPassword);

        btnRegister=findViewById(R.id.button);
        //testDisplay=findViewById(R.id.textView5);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String strID, strFname, strLname, strEmail, strPassword, allString;

                strID= etID.getText().toString().trim();
                strFname= etFname.getText().toString().trim();
                strLname= etLname.getText().toString().trim();
                strEmail= etEmail.getText().toString().trim();
                strPassword= etPassword.getText().toString().trim();

                allString= strID+"\n"+strFname+" "+strLname+"\n"+strEmail;
                //testDisplay.setText(strID+", "+strFname+", "+strLname+", "+strEmail+", "+strPassword);

                MaterialAlertDialogBuilder builder= new MaterialAlertDialogBuilder(view.getContext());
                builder.setTitle("Review account credentials");
                builder.setMessage(allString);
                builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //add functions after confirmation

                        Intent intent= new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("ID", strID);
                        intent.putExtra("Fname", strFname);
                        intent.putExtra("Lname", strLname);
                        intent.putExtra("Email", strEmail);
                        intent.putExtra("Password",strPassword);
                        startActivity(intent);
                    }
                });
                builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //add here functions for cancel
                    }
                });
                builder.show();





            }
        });

    }
}