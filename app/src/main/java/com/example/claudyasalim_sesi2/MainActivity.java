package com.example.claudyasalim_sesi2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button logout;
    TextView user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logout = findViewById(R.id.btn_logout);
        user = findViewById(R.id.tv_user);

        Intent mainIntent = getIntent();
        String name = mainIntent.getStringExtra("account_username");

        user.setText(name);

        logout.setOnClickListener(v-> {
            Toast.makeText(MainActivity.this, "You are logged out!", Toast.LENGTH_SHORT).show();
            Intent toLoginIntent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(toLoginIntent);
        });
    }
}