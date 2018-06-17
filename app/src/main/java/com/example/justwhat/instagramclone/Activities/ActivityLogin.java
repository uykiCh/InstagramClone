package com.example.justwhat.instagramclone.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.example.justwhat.instagramclone.Activities.MVPActivityLogIn.DataActivityLogIn;
import com.example.justwhat.instagramclone.Activities.MVPActivityLogIn.ModelActivityLogIn;
import com.example.justwhat.instagramclone.Activities.MVPActivityLogIn.PresenterActivityLogIn;
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

    private PresenterActivityLogIn presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        ButterKnife.bind(this);

        DataActivityLogIn dataActivityLogIn = new DataActivityLogIn();
        presenter = new PresenterActivityLogIn(dataActivityLogIn);
        presenter.attachView(this);

        //for fragments
        //unbinder = ButterKnife.bind(this, view);
    }

    @OnClick(R.id.activity_login_btn_login)
    public void openActivitySignUp(){

        presenter.logIn();

    }

    @OnClick(R.id.activity_login_field_down)
    public void openSignUpActivity(){

        startActivity(new Intent(ActivityLogin.this, ActivitySignUp.class));

    }

    public void completeLoaded(){

        Log.i(TAG, "Loaded");

    }

    public void failLoaded(){

        Log.i(TAG, "Fail");

    }

    public ModelActivityLogIn getUserData(){
        ModelActivityLogIn modelActivityLogIn = new ModelActivityLogIn();
        modelActivityLogIn.setEmail(editTextEmail.getText().toString());
        modelActivityLogIn.setPassword(editTextPassword.getText().toString());
        return modelActivityLogIn;
    }

    //for fragments
    /*@Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }*/

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
