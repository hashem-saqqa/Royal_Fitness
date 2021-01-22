package com.example.royalfitnessmhr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class create1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create1);
    }
    public void h(View view) {

        Intent intent = new Intent(getApplicationContext(),createacount.class);
        startActivity(intent);
    }
}
