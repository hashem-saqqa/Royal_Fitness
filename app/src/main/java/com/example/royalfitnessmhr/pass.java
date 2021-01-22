package com.example.royalfitnessmhr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class pass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass);
    }

    public void ok(View view) {
        Intent intent = new Intent(getApplicationContext(),pass2.class);
        startActivity(intent);
    }
}
