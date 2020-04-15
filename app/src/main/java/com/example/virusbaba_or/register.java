package com.example.virusbaba_or;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.concurrent.TimeUnit;

public class register extends AppCompatActivity {
    Button sub,res;
    EditText name, age, phone, email,passwd;
    ImageView m,f;
    String verificationId;
    FirebaseAuth mAuth;
    Boolean verficationInProgress;
    String gender;
    FirebaseFirestore mstore;



    PhoneAuthProvider.ForceResendingToken token;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //Buttons
        sub=findViewById(R.id.bt_sub);
        res=findViewById(R.id.bt_res);
        //Edit Text, Gender
        name=findViewById(R.id._name);
        age=findViewById(R.id._age);
        phone=findViewById(R.id._phone);
        email=findViewById(R.id._email);
        passwd=findViewById(R.id._passwd);
        m=findViewById(R.id.male);
        f=findViewById(R.id.female);
        //Initialize the FirebaseAuth Instances:
        mAuth=FirebaseAuth.getInstance();
        mstore=FirebaseFirestore.getInstance();




        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().isEmpty() | age.getText().toString().isEmpty() | phone.getText().toString().isEmpty()  | email.getText().toString().isEmpty() |passwd.getText().toString().isEmpty() && phone.getText().toString().length() !=10){
                    Toast.makeText(register.this,"Please Enter all Details...",Toast.LENGTH_LONG).show();
                }
                else
                {

                    String phone1="+91" +phone.getText().toString();
                    requestOTP(phone1);
                }

            }
        });

        //Reset Button Function below:
        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                age.setText("");
                phone.setText("");
                email.setText("");
                passwd.setText("");
                m.setVisibility(View.VISIBLE);
                f.setVisibility(View.VISIBLE);
            }
        });
        //If Female is Selected Male will be Invisible.
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m.setVisibility(View.GONE);
                gender="F";

            }
        });
        //If Male is Selected Female will be Invisible.
        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f.setVisibility(View.GONE);
                gender="M";
            }
        });




    }

    private void requestOTP(String phone1) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(phone1, 60L, TimeUnit.SECONDS, this, new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                verificationId=s;
                token=forceResendingToken;
                verficationInProgress =true;
                String userId=mAuth.getCurrentUser().getUid();
                String name1=name.getText().toString().trim();
                String age1=age.getText().toString().trim();
                String phone1=phone.getText().toString().trim();
                String email1=email.getText().toString().trim();
                String passwd1=passwd.getText().toString().trim();


                Intent inte=new Intent(register.this,otp.class);
                inte.putExtra("verificationId",verificationId);
                inte.putExtra("userID",userId);
                inte.putExtra("name",name1);
                inte.putExtra("age",age1);
                inte.putExtra("phone",phone1);
                inte.putExtra("email",email1);
                inte.putExtra("gender",gender);
                startActivity(inte);
            }

            @Override
            public void onCodeAutoRetrievalTimeOut(@NonNull String s) {
                super.onCodeAutoRetrievalTimeOut(s);
            }

            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                Toast.makeText(register.this,"Cannont Create Account " +e.getMessage(),Toast.LENGTH_LONG).show();
            }
        });


    }
}
