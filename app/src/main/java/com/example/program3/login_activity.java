package com.example.program3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class login_activity extends AppCompatActivity {

    Button lsignin;
    EditText lusername, lpassword;

    int counter = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        lusername = findViewById(R.id.editTextTextPersonName2);
        lpassword = findViewById(R.id.editTextTextPassword2);

        lsignin = findViewById(R.id.button2);

        lsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle b = getIntent().getExtras();
                String suser = b.getString("usern");
                String spass = b.getString("pass");

                if(suser.equals(lusername.getText().toString()) && spass.equals(lpassword.getText().toString()))
                {
                    Intent it = new Intent(getBaseContext(), success.class);
                    startActivity(it);
                }
                else
                {
                    Toast.makeText(getBaseContext(),"LOGIN FAILED",Toast.LENGTH_LONG).show();
                }

                counter--;

                if(counter == 0)
                {
                    Toast.makeText(getBaseContext(),"FAILED LOGIN ATTEMPTS",Toast.LENGTH_LONG).show();
                    lsignin.setEnabled(false);
                }
            }
        });


    }
}