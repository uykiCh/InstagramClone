package com.example.justwhat.instagramclone.Activities.MVPActivityLogIn;

import android.content.ContentValues;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class DataActivityLogIn {

    private static final String TAG = "DataActivityLogIn";

    private FirebaseAuth auth;

    public void checkUser(ContentValues contentValues, CompleteCallback completeCallback){

        String password = contentValues.getAsString("password");
        String email = contentValues.getAsString("email");
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isComplete()){

                    Log.i(TAG, "Complete");
                    

                }else {

                    Log.i(TAG, "Sorry");

                }
            }
        });

        auth = FirebaseAuth.getInstance();

    }

    interface CompleteCallback {
        void onComplete();
    }

    class checkFromFirebase{

        private final CompleteCallback callback;


        checkFromFirebase(CompleteCallback callback) {
            this.callback = callback;
        }
    }

}
