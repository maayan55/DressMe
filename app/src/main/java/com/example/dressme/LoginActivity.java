package com.example.dressme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            startActivity(new Intent(LoginActivity.this, WelcomeActivity.class));
        }
    }

    public void register(View view) {
        EditText emailEditText = findViewById(R.id.edittext_email);
        EditText passwordEditText = findViewById(R.id.edittext_password);
        mAuth.createUserWithEmailAndPassword(emailEditText.getText().toString(), passwordEditText.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "registration was successful", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(LoginActivity.this, WelcomeActivity.class));
                        } else {
                            Toast.makeText(LoginActivity.this, "register failed:(", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    public void login(View view) {
        EditText emailEditText = findViewById(R.id.edittext_email);
        EditText passwordEditText = findViewById(R.id.edittext_password);
        mAuth.signInWithEmailAndPassword(emailEditText.getText().toString(), passwordEditText.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(LoginActivity.this, WelcomeActivity.class));
                        } else {
                            Toast.makeText(LoginActivity.this, "login failed:(", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}