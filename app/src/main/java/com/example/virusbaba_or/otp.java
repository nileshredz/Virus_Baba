package com.example.virusbaba_or;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class otp extends AppCompatActivity {
    Boolean verficationInProgress =false;
    Button ver,resend;
    EditText otp;
    FirebaseAuth mAuth;
    String otp1;
    FirebaseFirestore mstore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        mAuth=FirebaseAuth.getInstance();
        mstore=FirebaseFirestore.getInstance();
        ver=findViewById(R.id.bt_ver);
        otp=findViewById(R.id.et_otp);
        otp1=otp.getText().toString();
        ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!otp.getText().toString().isEmpty() && otp.getText().length()==6)
                {
                    String verificationId1=getIntent().getExtras().getString("verificationId");
                    PhoneAuthCredential credential;
                    credential = PhoneAuthProvider.getCredential(verificationId1,otp.getText().toString());
                    Toast.makeText(otp.this,"Done "+credential,Toast.LENGTH_SHORT).show();
                    verifyAuth(credential);


               }
                else
               {
                   Toast.makeText(otp.this,"There was an Error",Toast.LENGTH_SHORT).show();


                }
            }
        });

        }

    private void verifyAuth(PhoneAuthCredential credential){

        //Toast.makeText(otp.this,"Reached verifyAUth",Toast.LENGTH_SHORT).show();
        mAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(otp.this,"Authentication is Successful",Toast.LENGTH_LONG).show();
                    final String userId=getIntent().getExtras().getString("userID");
                    DocumentReference documentReference=mstore.collection("personal").document(userId);

                    String name=getIntent().getExtras().getString("name");
                    String age=getIntent().getExtras().getString("age");
                    String gender=getIntent().getExtras().getString("gender");
                    String phone=getIntent().getExtras().getString("phone");
                    String email=getIntent().getExtras().getString("email");

                    Map<String,Object> user =new HashMap<>();
                    user.put("UserID",userId);
                    user.put("Name",name);
                    user.put("Age",age);
                    user.put("Gender",gender);
                    user.put("Phone",phone);
                    user.put("Email",email);
                    Intent intent3=new Intent(otp.this,profile.class);
                    intent3.putExtra("name_tag",name);
                    startActivity(intent3);

                    Intent intent10=new Intent(otp.this,booking.class);
                    intent10.putExtra("name",name);
                    intent10.putExtra("age",age);
                    intent10.putExtra("gender",gender);
                    intent10.putExtra("phone",phone);
                    intent10.putExtra("email",email);
                    intent10.putExtra("userId",userId);

                    documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Log.d("TAG","User is Created of"+userId);
                        }
                    });


               }
                else
               {
                    Toast.makeText(otp.this,"OTP is Incorrect.",Toast.LENGTH_SHORT).show();

                }

            }
        });

    }
}
