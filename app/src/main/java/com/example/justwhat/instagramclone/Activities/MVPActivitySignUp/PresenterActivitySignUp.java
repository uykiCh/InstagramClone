package com.example.justwhat.instagramclone.Activities.MVPActivitySignUp;

import android.content.ContentValues;
import android.text.TextUtils;

import com.example.justwhat.instagramclone.Activities.ActivitySignUp;

public class PresenterActivitySignUp {

    private static final String TAG = "PASingUp";

    private ActivitySignUp view;
    private final DataActivitySignUp model;

    public PresenterActivitySignUp(DataActivitySignUp dataActivitySignUp) {
        this.model = dataActivitySignUp;
    }

    public void attachView(ActivitySignUp activitySignUp){

        view = activitySignUp;

    }

    public void detachView(){

        view = null;

    }

    public void signUp(){

        ModelActivitySignUp modelActivitySignUp = view.getUserData();
        if (!(TextUtils.isEmpty(modelActivitySignUp.getEmail())||
                TextUtils.isEmpty(modelActivitySignUp.getUsername())||
                TextUtils.isEmpty(modelActivitySignUp.getPassword())||
                TextUtils.isEmpty(modelActivitySignUp.getFullName()))){

            ContentValues cv = new ContentValues(4);
            cv.put("password", modelActivitySignUp.getPassword());
            cv.put("email", modelActivitySignUp.getEmail());
            cv.put("username", modelActivitySignUp.getUsername());
            cv.put("fullname", modelActivitySignUp.getFullName());

            model.signUp(cv,
                    new DataActivitySignUp.CompleteCallback() {
                        @Override
                        public void onComplete() {
                            view.completeLoaded();
                        }
                    },
                    new DataActivitySignUp.FailCallback() {
                        @Override
                        public void onFail() {
                            view.failLoaded();
                        }
                    });


        }

    }

}
