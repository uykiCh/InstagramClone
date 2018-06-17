package com.example.justwhat.instagramclone.presentation.view.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.justwhat.instagramclone.R;
import com.example.justwhat.instagramclone.presentation.view.logIn.LogIn;
import com.google.firebase.auth.FirebaseAuth;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @BindView(R.id.activity_main_bottom_navigation_bar)
    BottomNavigationViewEx bottomNavigationViewEx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        firebaseAuth = FirebaseAuth.getInstance();

        setNavigationView();

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (firebaseAuth.getCurrentUser()==null){

            startActivity(new Intent(MainActivity.this, LogIn.class));
            finish();

        }
    }

    void setNavigationView(){

        BottomNavigationViewExHelper.setBottomNavigationViewEx(bottomNavigationViewEx);
        BottomNavigationViewExHelper.setNavigation(MainActivity.this, bottomNavigationViewEx);

    }
}
