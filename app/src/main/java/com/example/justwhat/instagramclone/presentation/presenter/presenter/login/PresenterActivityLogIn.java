package com.example.justwhat.instagramclone.presentation.presenter.presenter.login;

import android.content.ContentValues;
import android.text.TextUtils;
import android.util.Log;

import com.example.justwhat.instagramclone.presentation.view.logIn.LogIn;
import com.example.justwhat.instagramclone.data.logIn.logIn;

public class PresenterActivityLogIn {

    private final static String TAG = "PresenterAL";

    private LogIn view;
    private final logIn model;

    public void attachView(LogIn logIn) {

        view = logIn;

    }

    public void detachView() {

        view = null;

    }

    public PresenterActivityLogIn(logIn model) {
        this.model = model;
    }

    public void logIn() {
        com.example.justwhat.instagramclone.models.logIn.LogIn logIn = view.getUserData();
        Log.i(TAG, "email: " + logIn.getEmail() + "\npassword: " + logIn.getPassword());

        if (!(TextUtils.isEmpty(logIn.getEmail()) || TextUtils.isEmpty(logIn.getPassword()))) {
            ContentValues cv = new ContentValues(2);
            cv.put("password", logIn.getPassword());
            cv.put("email", logIn.getEmail());
            model.checkUser(cv,
                    new com.example.justwhat.instagramclone.data.logIn.logIn.CompleteCallback() {
                        @Override
                        public void onComplete() {
                            view.completeLoaded();
                        }
                    },
                    new com.example.justwhat.instagramclone.data.logIn.logIn.FailCallback() {
                        @Override
                        public void onFail() {
                            view.failLoaded();
                        }
                    });
        }

    }


}
