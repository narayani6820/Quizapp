package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    SharedPreferences sp;
    String s;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = findViewById(R.id.textView2);
        sp = getSharedPreferences("pqr",MODE_PRIVATE);
        s = sp.getString("poo","any");
        textView.setText(s);


    }

    public void finalexit(View view) {
        finish();
        System.exit(0);

    }
}