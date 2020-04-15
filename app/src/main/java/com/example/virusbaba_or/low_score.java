package com.example.virusbaba_or;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class low_score extends AppCompatActivity {
    TextView low_score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_low_score);
        low_score=findViewById(R.id.tv_lscore);
        String sco=getIntent().getExtras().getString("lscore");
        Toast.makeText(low_score.this,"Score: "+sco,Toast.LENGTH_LONG).show();

        low_score.setText(sco+"/40");

    }
}
