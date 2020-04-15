package com.example.virusbaba_or;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class profile extends AppCompatActivity {
    Button test,about;
    TextView profilen;
    Bundle intexs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        String name=getIntent().getExtras().getString("name_tag");


        profilen=findViewById(R.id.tv_user_n);
        profilen.setText(name);
        about=findViewById(R.id.bt_about);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4;
                intent4 = new Intent(profile.this,about.class);
                startActivity(intent4);
            }
        });

        test=findViewById(R.id.bt_test);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),questions.class));
            }
        });

    }
}
