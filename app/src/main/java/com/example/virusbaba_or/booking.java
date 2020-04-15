package com.example.virusbaba_or;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

public class booking extends AppCompatActivity {
    TextView id,name,age,phone,gender,centre;
    Bundle bundle;
    FirebaseFirestore mstore;
    String txt_centre,txt_id;
    Button conf;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        id=findViewById(R.id.tv_id);
        name=findViewById(R.id.tv_name);
        age=findViewById(R.id.tv_age);
        phone=findViewById(R.id.tv_phone);
        gender=findViewById(R.id.tv_gender);
        centre=findViewById(R.id.tv_centre);
        conf=findViewById(R.id.bt_confirm);

        mstore=FirebaseFirestore.getInstance();
        bundle=getIntent().getExtras();


        txt_centre=bundle.getString("testcentrename");
        centre.setText("Centre: "+txt_centre);

        mstore.collection("personal").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                for (DocumentSnapshot ds: queryDocumentSnapshots){
                    String txt_name=ds.getString("Name");
                    String txt_age=ds.getString("Age");
                    txt_id=ds.getString("UserID");
                    String txt_gender=ds.getString("Gender");
                    String txt_phone=ds.getString("Phone");
                    id.setText("UserID: "+txt_id);
                    name.setText("Name: "+txt_name);
                    age.setText("Age: "+txt_age);
                    phone.setText("Phone: "+txt_phone);
                    gender.setText("Gender: "+txt_gender);

                }
            }
        });

        conf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent11=new Intent(booking.this,end.class);
                intent11.putExtra("uid",txt_id);
                startActivity(intent11);

            }
        });






    }
}
