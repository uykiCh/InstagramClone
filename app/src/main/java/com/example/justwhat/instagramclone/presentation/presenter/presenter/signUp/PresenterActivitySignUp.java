package com.example.justwhat.instagramclone.presentation.presenter.presenter.signUp;

import android.content.ContentValues;
import android.text.TextUtils;

import com.example.justwhat.instagramclone.presentation.view.signUp.SignUp;
import com.example.justwhat.instagramclone.data.signUp.signUp;

public class PresenterActivitySignUp {

    private static final String TAG = "PASingUp";

    private SignUp view;
    private final signUp model;

    public PresenterActivitySignUp(signUp signUp) {
        this.model = signUp;
    }

    public void attachView(SignUp signUp) {

        view = signUp;

    }

    public void detachView() {

        view = null;

    }

    public void signUp() {

        com.example.justwhat.instagramclone.models.signUp.SignUp signUp = view.getUserData();
        if (!(TextUtils.isEmpty(signUp.getEmail()) ||
                TextUtils.isEmpty(signUp.getUsername()) ||
                TextUtils.isEmpty(signUp.getPassword()) ||
                TextUtils.isEmpty(signUp.getFullName()))) {

            //сделать проверку на ник(и возможно почту)
            //переделать папки на нормальную архитектуру

            ContentValues cv = new ContentValues(4);
            cv.put("password", signUp.getPassword());
            cv.put("email", signUp.getEmail());
            cv.put("username", signUp.getUsername());
            cv.put("fullname", signUp.getFullName());

            model.signUp(cv,
                    new com.example.justwhat.instagramclone.data.signUp.signUp.CompleteCallback() {
                        @Override
                        public void onComplete() {

                            view.completeLoaded();

                        }
                    },
                    new com.example.justwhat.instagramclone.data.signUp.signUp.FailCallback() {
                        @Override
                        public void onFail() {

                            view.failLoaded();

                        }
                    });


        }

    }

}
