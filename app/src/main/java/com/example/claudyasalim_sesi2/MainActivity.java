package com.example.claudyasalim_sesi2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button logout, toUser;
    TextView user;
//    private RecyclerView collectionRecycleView;
    RecyclerView collectionRecycleView;
    CollectionsAdapter collectionRecycleViewAdapter;
    ArrayList<String> collectionList;
    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logout = findViewById(R.id.btn_logout);
        toUser = findViewById(R.id.btn_toUser);
        user = findViewById(R.id.tv_user);
        collectionList = new ArrayList<>();

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

        mainViewModel = new ViewModelProvider(this, new MainViewModelFactory(getApplication())).get(MainViewModel.class);

        collectionList.add("Artifact");
        collectionList.add("Seashells");


        collectionRecycleView = findViewById(R.id.recycler_view);
        collectionRecycleView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false));
        collectionRecycleViewAdapter = new CollectionsAdapter(collectionList);
        collectionRecycleView.setAdapter(collectionRecycleViewAdapter);

    }

}