package com.example.virusbaba_or;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;

public class high_score extends AppCompatActivity {
    Button book;
    TextView hi_score;
    FirebaseFirestore mstrore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);
        book=findViewById(R.id.bt_map);
        hi_score=findViewById(R.id.tv_hscore);
        final String hscore=getIntent().getExtras().getString("hscore");
        final String hscore1=hscore+"/40";

        hi_score.setText(hscore1);



        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent8=new Intent(high_score.this,MapsActivity.class);
                startActivity(intent8);




            }
        });
    }
}
