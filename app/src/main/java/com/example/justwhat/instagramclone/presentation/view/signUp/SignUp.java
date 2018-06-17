package com.example.justwhat.instagramclone.presentation.view.signUp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.justwhat.instagramclone.data.signUp.signUp;
import com.example.justwhat.instagramclone.presentation.presenter.presenter.signUp.PresenterActivitySignUp;
import com.example.justwhat.instagramclone.presentation.view.main.MainActivity;
import com.example.justwhat.instagramclone.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUp extends AppCompatActivity {

    private static final String TAG = "signUp";

    private PresenterActivitySignUp presenter;

    @BindView(R.id.activity_sign_up_email)
    public EditText email;

    @BindView(R.id.activity_sign_up_full_name)
    public EditText fullName;

    @BindView(R.id.activity_sign_up_username)
    public EditText username;

    @BindView(R.id.activity_sign_up_password)
    public EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);

        signUp signUp = new signUp();
        presenter = new PresenterActivitySignUp(signUp);
        presenter.attachView(this);


    }

    public com.example.justwhat.instagramclone.models.signUp.SignUp getUserData() {
        com.example.justwhat.instagramclone.models.signUp.SignUp signUp = new com.example.justwhat.instagramclone.models.signUp.SignUp();
        signUp.setEmail(email.getText().toString());
        signUp.setUsername(username.getText().toString());
        signUp.setPassword(password.getText().toString());
        signUp.setFullName(fullName.getText().toString());

        return signUp;
    }

    @OnClick(R.id.activity_sign_up_btn_login)
    void signUp() {

        presenter.signUp();

    }

    public void completeLoaded() {

        startActivity(new Intent(SignUp.this, MainActivity.class));
        finish();

    }

    public void failLoaded() {

        Toast.makeText(this, "Error, sorry", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "Error");

    }

    @OnClick(R.id.activity_sign_up_field_down)
    public void openLogInActivity() {

        finish();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

}