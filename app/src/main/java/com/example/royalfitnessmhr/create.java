package com.example.royalfitnessmhr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class create extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
    }
    public void cont(View view) {
        Intent intent = new Intent(getApplicationContext(),create1.class);
        startActivity(intent);
    }
}
