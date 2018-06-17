package com.example.justwhat.instagramclone.presentation.view.logIn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.example.justwhat.instagramclone.presentation.view.signUp.SignUp;
import com.example.justwhat.instagramclone.data.logIn.logIn;
import com.example.justwhat.instagramclone.presentation.presenter.presenter.login.PresenterActivityLogIn;
import com.example.justwhat.instagramclone.presentation.view.main.MainActivity;
import com.example.justwhat.instagramclone.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LogIn extends AppCompatActivity {

    private static final String TAG = "ActivityLogIn";

    @BindView(R.id.activity_login_et_email)
    public EditText editTextEmail;

    @BindView(R.id.activity_login_et_password)
    public EditText editTextPassword;

    private PresenterActivityLogIn presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        ButterKnife.bind(this);

        logIn logIn = new logIn();
        presenter = new PresenterActivityLogIn(logIn);
        presenter.attachView(this);

    }

    @OnClick(R.id.activity_login_btn_login)
    public void openActivitySignUp(){

        presenter.logIn();

    }

    @OnClick(R.id.activity_login_field_down)
    public void openSignUpActivity(){

        startActivity(new Intent(LogIn.this, SignUp.class));

    }

    public void completeLoaded(){

        Log.i(TAG, "Loaded");

        startActivity(new Intent(LogIn.this, MainActivity.class));
        finish();

    }

    public void failLoaded(){

        Log.i(TAG, "Fail");

    }

    public com.example.justwhat.instagramclone.models.logIn.LogIn getUserData(){
        com.example.justwhat.instagramclone.models.logIn.LogIn logIn = new com.example.justwhat.instagramclone.models.logIn.LogIn();
        logIn.setEmail(editTextEmail.getText().toString());
        logIn.setPassword(editTextPassword.getText().toString());
        return logIn;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
