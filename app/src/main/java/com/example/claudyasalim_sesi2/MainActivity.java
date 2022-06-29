package com.example.claudyasalim_sesi2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    Button logout, toUser;
    TextView user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logout = findViewById(R.id.btn_logout);
        toUser = findViewById(R.id.btn_toUser);
        user = findViewById(R.id.tv_user);

        Intent mainIntent = getIntent();
        String name = mainIntent.getStringExtra("account_username");

        user.setText(name);

        toUser.setOnClickListener(v-> {
            Intent toUserIntent = new Intent(MainActivity.this, UserActivity.class);
            startActivity(toUserIntent);
        });

        logout.setOnClickListener(v-> {
            Toast.makeText(MainActivity.this, "You are logged out!", Toast.LENGTH_SHORT).show();
            Intent toLoginIntent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(toLoginIntent);
        });
    }

}