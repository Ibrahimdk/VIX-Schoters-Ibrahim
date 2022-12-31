package com.example.localeibra;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    private EditText edtUsername, edtEmail, edtPassword;
    private TextView registerbtn, txtLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_act);
        mAuth = FirebaseAuth.getInstance();

        txtLogin = (TextView) findViewById(R.id.txtLogin);
        txtLogin.setOnClickListener(this);


        registerbtn = (Button) findViewById(R.id.registerbtn);
        registerbtn.setOnClickListener(this);

        edtUsername = (EditText) findViewById(R.id.regUser);
        edtEmail = (EditText) findViewById(R.id.regEmail);
        edtPassword = (EditText) findViewById(R.id.regPassword);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.txtLogin:
                startActivity(new Intent(this, loginact.class));
                break;
            case R.id.registerbtn:
                registerUser();
                break;
        }
    }


    private void registerUser() {
        String email = edtEmail.getText().toString().trim();
        String username = edtUsername.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();

        if (username.isEmpty()){
            edtUsername.setError("Username is required");
            edtUsername.requestFocus();
            return;
        }

        if (email.isEmpty()){
            edtUsername.setError("Email is required");
            edtUsername.requestFocus();
            return;
        }


        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            edtEmail.setError("Please provide valid email");
            edtEmail.requestFocus();
            return;
        }

        if (password.isEmpty()){
            edtUsername.setError("Password is required");
            edtUsername.requestFocus();
            return;
        }

        if (password.length() < 5){
            edtPassword.setError("Min password length is 5 characters");
            edtPassword.requestFocus();
            return;
        }
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            User user = new User(username, email, password);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {

                                            if (task.isSuccessful()){
                                                Toast.makeText(register.this, "User has been registered successfully!", Toast.LENGTH_LONG).show();

                                            }else{
                                                Toast.makeText(register.this, "Failed to register. Try Again!", Toast.LENGTH_LONG).show();
                                            }
                                        }
                                    });
                        }else {
                            Toast.makeText(register.this, "Failed to register.", Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }


}