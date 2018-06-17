package com.example.justwhat.instagramclone.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.justwhat.instagramclone.Activities.MVPActivitySignUp.DataActivitySignUp;
import com.example.justwhat.instagramclone.Activities.MVPActivitySignUp.ModelActivitySignUp;
import com.example.justwhat.instagramclone.Activities.MVPActivitySignUp.PresenterActivitySignUp;
import com.example.justwhat.instagramclone.MainActivity;
import com.example.justwhat.instagramclone.R;
import com.google.firebase.components.ComponentContainer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivitySignUp extends AppCompatActivity {

    private static final String TAG = "ActivitySignUp";

    private PresenterActivitySignUp presenter;

    @BindView(R.id.activity_sign_up_email)
    EditText email;

    @BindView(R.id.activity_sign_up_full_name)
    EditText fullName;

    @BindView(R.id.activity_sign_up_username)
    EditText username;

    @BindView(R.id.activity_sign_up_password)
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);

        DataActivitySignUp dataActivitySignUp = new DataActivitySignUp();
        presenter = new PresenterActivitySignUp(dataActivitySignUp);
        presenter.attachView(this);


    }

    public ModelActivitySignUp getUserData() {
        ModelActivitySignUp modelActivitySignUp = new ModelActivitySignUp();
        modelActivitySignUp.setEmail(email.getText().toString());
        modelActivitySignUp.setUsername(username.getText().toString());
        modelActivitySignUp.setPassword(password.getText().toString());
        modelActivitySignUp.setFullName(fullName.getText().toString());

        return modelActivitySignUp;
    }

    @OnClick(R.id.activity_sign_up_btn_login)
    void signUp() {

        presenter.signUp();

    }

    public void completeLoaded() {

        startActivity(new Intent(ActivitySignUp.this, MainActivity.class));
        ActivitySignUp.this.finish();

    }

    public void failLoaded() {

        Toast.makeText(this, "Error, sorry", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "Error");

    }

    @OnClick(R.id.activity_sign_up_field_down)
    void openLogInActivity() {
        ActivitySignUp.this.finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

}