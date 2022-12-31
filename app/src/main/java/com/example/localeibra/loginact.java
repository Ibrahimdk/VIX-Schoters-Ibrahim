package com.example.localeibra;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class loginact extends AppCompatActivity implements View.OnClickListener {

    private EditText edtEmail, edtPassword;
    private Button signIn;
    private TextView txtRegister;

    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginact);

        txtRegister = (TextView) findViewById(R.id.txtRegister);
        txtRegister.setOnClickListener(this);

        signIn = (Button) findViewById(R.id.actlogin);
        signIn.setOnClickListener(this);

        edtEmail = (EditText) findViewById(R.id.logEmail);
        edtPassword = (EditText) findViewById(R.id.logPassword);

        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.txtRegister:
                startActivity(new Intent(this, register.class));
                break;
            case R.id.actlogin:
                loginUser();
                break;


        }
    }

    private void loginUser() {
        String email = edtEmail.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();

        if (email.isEmpty()){
            edtEmail.setError("Email is required");
            edtEmail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            edtEmail.setError("Please enter a valid email");
            edtEmail.requestFocus();
            return;
        }

        if (password.isEmpty()){
            edtPassword.setError("Password is required");
            edtPassword.requestFocus();
            return;
        }

        if(password.length() < 5){
            edtPassword.setError("Min password length is 5 characters!");
            edtPassword.requestFocus();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    startActivity(new Intent(loginact.this, tablayout_custom.class));
                    Toast.makeText(loginact.this, "Login Succesfully",Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(loginact.this, "Failed to login! please chcek yout credentials",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    //public void mainlayout(View view) {
        //Intent it = new Intent(loginact.this, tablayout_custom.class );
        //(it);
    //}
}