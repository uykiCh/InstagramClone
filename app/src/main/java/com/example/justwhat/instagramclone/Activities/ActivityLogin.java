package com.example.justwhat.instagramclone.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.justwhat.instagramclone.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityLogin extends AppCompatActivity {

    private static final String TAG = "ActivityLogIn";

    //for fragments
    // private Unbinder unbinder;

    @BindView(R.id.activity_login_et_email)
    EditText editTextEmail;

    @BindView(R.id.activity_login_et_password)
    EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        ButterKnife.bind(this);
        //for fragments
        //unbinder = ButterKnife.bind(this, view);
    }

    /*@OnClick(R.id.activity_login_btn_login)
    public void openActivitySignUp(){

        *//*startActivity(new Intent(ActivityLogin.this, ActivitySignUp.class));*//*

        Log.i(TAG, "Clicked");

    }*/

    //for fragments
    /*@Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }*/
}
