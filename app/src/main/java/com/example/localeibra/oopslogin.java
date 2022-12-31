package com.example.localeibra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class oopslogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oopslogin);
    }

    public void gaslog(View view) {
        Intent it = new Intent(oopslogin.this, register.class );
        startActivity(it);
    }

    public void loginbtn(View view) {
        Intent it = new Intent(oopslogin.this, loginact.class );
        startActivity(it);
    }
}