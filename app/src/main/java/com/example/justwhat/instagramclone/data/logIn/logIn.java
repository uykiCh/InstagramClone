package com.example.justwhat.instagramclone.data.logIn;

import android.content.ContentValues;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class logIn {

    public interface CompleteCallback {
        void onComplete();
    }

    public interface FailCallback{
        void onFail();
    }

    private static final String TAG = "logIn";

    private FirebaseAuth auth;

    public void checkUser(ContentValues contentValues, CompleteCallback completeCallback, FailCallback failCallback){

        auth = FirebaseAuth.getInstance();

        String email = contentValues.getAsString("email");
        String password = contentValues.getAsString("password");

        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){

                    completeCallback.onComplete();


                }else {

                    failCallback.onFail();

                    Log.i(TAG, Objects.requireNonNull(task.getException()).getMessage());

                }
            }
        });

    }

}
