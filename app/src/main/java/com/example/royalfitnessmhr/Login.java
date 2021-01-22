package com.example.royalfitnessmhr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void replay(View view) {
        Intent intent = new Intent(getApplicationContext(),pass.class);
        startActivity(intent);

    }

    public void createe(View view) {
        Intent intent = new Intent(getApplicationContext(),create.class);
        startActivity(intent);
    }


    public void ok(View view) {
        Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
        startActivity(intent);
    }
}
