package com.example.dell.signingoogle;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class SecondOne extends AppCompatActivity {


    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;
    Button button;

    @Override
    protected void onStart() {
        super.onStart();
      mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_one);
        button=findViewById(R.id.button2);

        mAuth=FirebaseAuth.getInstance();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              mAuth.signOut();
            }
        });

        mAuthListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()==null)
                    startActivity(new Intent(SecondOne.this,MainActivity.class));
            }
        };

    }
}
