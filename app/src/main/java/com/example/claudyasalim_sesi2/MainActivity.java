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

//    Button logout;
//    TextView user;
    TabLayout tab;
    ViewPager2 viewPager2;
    PageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tab = findViewById(R.id.tab);
        viewPager2 = findViewById(R.id.view_pager);

        setViewPager2(viewPager2);

        new TabLayoutMediator(tab, viewPager2, ((tab, position)-> {
            tab.setText(pageAdapter.getTitle(position));
        })).attach();

//        logout = findViewById(R.id.btn_logout);
//        user = findViewById(R.id.tv_user);
//
//        Intent mainIntent = getIntent();
//        String name = mainIntent.getStringExtra("account_username");
//
//        user.setText(name);
//
//        logout.setOnClickListener(v-> {
//            Toast.makeText(MainActivity.this, "You are logged out!", Toast.LENGTH_SHORT).show();
//            Intent toLoginIntent = new Intent(MainActivity.this, LoginActivity.class);
//            startActivity(toLoginIntent);
//        });
    }

    private void setViewPager2 (ViewPager2 viewPager2){
        if(pageAdapter==null){
            pageAdapter = new PageAdapter(this);
            pageAdapter.addFragment(new HomeFragment(), "Home");
            pageAdapter.addFragment(new SettingsFragment(), "Settings");
            viewPager2.setAdapter(pageAdapter);
        }
    }
}