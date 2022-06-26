package com.example.claudyasalim_sesi2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button login, toRegister;
    EditText loginEmail, loginPassword;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.btn_login);
        toRegister = findViewById(R.id.btn_toRegister);
        loginEmail = findViewById(R.id.et_login_email);
        loginPassword = findViewById(R.id.et_login_password);
        sharedPref = getSharedPreferences("account", MODE_PRIVATE);
        ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);

        login.setOnClickListener(view -> {
            if(!loginEmail.getText().toString().equals(sharedPref.getString("account_email", ""))){
                Toast.makeText(LoginActivity.this, "Email invalid", Toast.LENGTH_SHORT).show();
            } else if(!loginPassword.getText().toString().equals(sharedPref.getString("account_password", ""))){
                Toast.makeText(LoginActivity.this, "Password invalid", Toast.LENGTH_SHORT).show();
            } else if(loginEmail.getText().toString().equals(sharedPref.getString("account_email", ""))
                    && loginPassword.getText().toString().equals(sharedPref.getString("account_password", ""))) {

                progressDialog.show();
                Toast.makeText(LoginActivity.this, "Logged in!", Toast.LENGTH_SHORT).show();

                Intent toMainIntent = new Intent(LoginActivity.this, MainActivity.class);
                toMainIntent.putExtra("account_username", sharedPref.getString("account_username", ""));
                startActivity(toMainIntent);
            }
        });

        toRegister.setOnClickListener(v-> {
            Intent toRegisterIntent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(toRegisterIntent);
        });
    }
}