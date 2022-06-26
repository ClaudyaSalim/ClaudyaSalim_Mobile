package com.example.claudyasalim_sesi2;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class HomeFragment extends Fragment {

    Button logout;
    TextView user;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);
        logout = v.findViewById(R.id.btn_logout);
        user = v.findViewById(R.id.tv_user);
        Intent homeIntent = getActivity().getIntent();
        String name = homeIntent.getStringExtra("account_username");
        user.setText(name);

        logout.setOnClickListener(view -> {
            Toast.makeText(getActivity(), "You are logged out!", Toast.LENGTH_SHORT).show();
            Intent toLoginIntent = new Intent(getActivity(), LoginActivity.class);
            startActivity(toLoginIntent);
        });

        return v;
    }
}