package com.example.justwhat.instagramclone.Activities.MVPActivitySignUp;

import android.content.ContentValues;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class DataActivitySignUp {

    interface CompleteCallback {
        void onComplete();
    }

    interface FailCallback{
        void onFail();
    }

    private FirebaseAuth auth;
    private FirebaseFirestore firebaseFirestore;

    public void signUp(ContentValues contentValues, CompleteCallback completeCallback, FailCallback failCallback){

        auth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        String email = contentValues.getAsString("email");
        String userName = contentValues.getAsString("username");
        String password = contentValues.getAsString("password");
        String fullname = contentValues.getAsString("fullname");

        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isComplete()){

                    Map<String, Object> map = new HashMap<>();
                    map.put("username", userName);
                    map.put("fullname", fullname);

                    firebaseFirestore.collection("Users")
                            .add(map).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentReference> task) {



                        }
                    });

                    completeCallback.onComplete();

                }else {

                    failCallback.onFail();

                }

            }
        });

    }

}
