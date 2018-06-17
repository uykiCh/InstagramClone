package com.example.justwhat.instagramclone.Activities.MVPActivityLogIn;

import android.content.ContentValues;
import android.text.TextUtils;
import android.util.Log;

import com.example.justwhat.instagramclone.Activities.ActivityLogin;
import com.example.justwhat.instagramclone.Activities.MVPActivityLogIn.ModelActivityLogIn;

public class PresenterActivityLogIn {

    private final static String TAG = "PresenterAL";

    private ActivityLogin view;
    private final DataActivityLogIn model;

    public void attachView(ActivityLogin activityLogin) {

        view = activityLogin;

    }

    public void detachView() {

        view = null;

    }

    public PresenterActivityLogIn(DataActivityLogIn model) {
        this.model = model;
    }

    public void add() {
        ModelActivityLogIn modelActivityLogIn = view.getUserData();
        Log.i(TAG, "email: " + modelActivityLogIn.getEmail() + "\npassword: " + modelActivityLogIn.getPassword());

        if (TextUtils.isEmpty(modelActivityLogIn.getEmail()) || TextUtils.isEmpty(modelActivityLogIn.getPassword())) {
            ContentValues cv = new ContentValues(2);
            cv.put("password", modelActivityLogIn.getPassword());
            cv.put("email", modelActivityLogIn.getEmail());
            model.checkUser(cv, new DataActivityLogIn.CompleteCallback() {
                @Override
                public void onComplete() {
                    view.completeLoaded();
                }
            });
        }

    }


}
