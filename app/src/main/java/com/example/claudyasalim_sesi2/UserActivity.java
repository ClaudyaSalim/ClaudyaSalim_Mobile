package com.example.claudyasalim_sesi2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class UserActivity extends AppCompatActivity {

    TabLayout tab;
    ViewPager2 viewPager2;
    PageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        tab = findViewById(R.id.tab);
        viewPager2 = findViewById(R.id.view_pager);

        setViewPager2(viewPager2);

        new TabLayoutMediator(tab, viewPager2, ((tab, position)-> {
            tab.setText(pageAdapter.getTitle(position));
        })).attach();
    }

    private void setViewPager2 (ViewPager2 viewPager2){
        if(pageAdapter==null){
            pageAdapter = new PageAdapter(this);
            pageAdapter.addFragment(new HomeFragment(), "Collections");
            pageAdapter.addFragment(new SettingsFragment(), "Settings");
            viewPager2.setAdapter(pageAdapter);
        }
    }
}