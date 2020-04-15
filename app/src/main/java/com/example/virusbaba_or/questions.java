package com.example.virusbaba_or;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class questions extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner country;
    String Q1,country_sel,Q4,Q6,Q7;
    Button sb,rs;
    RadioGroup rg1,rg4,rg6,rg7;
    RadioButton rb1,rb4,rb6,rb7;
    int c31,c32,c33,c34,c35,c36,c37,c51,c52,c53,c54,c55,checkans;
    int q1,q4,q6,q7;
    ArrayList<String> symp=new ArrayList<String>();
    ArrayList<String> med_cond=new ArrayList<String>();
    CheckBox cc11,cc12,cc13,cc14,cc15,cc16,cc17,cc21,cc22,cc23,cc24,cc25;
    int score=0;
    FirebaseFirestore mstore;




    Boolean checked;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        country=findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.countries,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        country.setAdapter(adapter);
        country.setOnItemSelectedListener(this);
        rg1=findViewById(R.id.rg_q1);
        rg4=findViewById(R.id.rg_q4);
        rg6=findViewById(R.id.rg_q6);
        rg7=findViewById(R.id.rg_q7);
        sb=findViewById(R.id.bt_testm);
        rs=findViewById(R.id.bt_reset);
        
        cc11=findViewById(R.id.c1_1);
        cc12=findViewById(R.id.c1_2);
        cc13=findViewById(R.id.c1_3);
        cc14=findViewById(R.id.c1_4);
        cc15=findViewById(R.id.c1_5);
        cc16=findViewById(R.id.c1_6);
        cc17=findViewById(R.id.c1_7);


        cc21=findViewById(R.id.c2_1);
        cc22=findViewById(R.id.c2_2);
        cc23=findViewById(R.id.c2_3);
        cc24=findViewById(R.id.c2_4);
        cc25=findViewById(R.id.c2_5);



        sb.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
               checkans = c31 + c32 + c33 + c34 + c35 + c36 + c37 + c51 + c52 + c53 + c54 + c55;
               score = q1 + q4 + q6 + q7 + checkans;
               String lsco=String.valueOf(score);

               mstore=FirebaseFirestore.getInstance();
               DocumentReference documentReference;

               documentReference=mstore.collection("Details").document();

               Map<String,Object> user=new HashMap<>();
               user.put("Q1",Q1);
               user.put("Q2",country_sel);
               user.put("Q3",symp);
               user.put("Q4",Q4);
               user.put("Q5",med_cond);
               user.put("Q6",Q6);
               user.put("Q7",Q7);

               documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                   @Override
                   public void onSuccess(Void aVoid) {
                       Toast.makeText(questions.this,"User has Successfully Registered.",Toast.LENGTH_LONG).show();
                   }
               });

               if (score < 12) {
                   Intent intent6 = new Intent(questions.this, low_score.class);
                   intent6.putExtra("lscore", lsco);
                   startActivity(intent6);


               }
               else
               {
                   Intent intent7=new Intent(questions.this,high_score.class);
                   intent7.putExtra("hscore",lsco);
                   startActivity(intent7);

               }
           }
        });

        rs.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                score=0;
                cc11.setChecked(false);
                cc12.setChecked(false);
                cc13.setChecked(false);
                cc14.setChecked(false);
                cc15.setChecked(false);
                cc16.setChecked(false);
                cc17.setChecked(false);

                cc21.setChecked(false);
                cc22.setChecked(false);
                cc23.setChecked(false);
                cc24.setChecked(false);
                cc25.setChecked(false);

                rg1.clearCheck();
                rg4.clearCheck();
                rg6.clearCheck();
                rg7.clearCheck();



            }
        });




    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        country_sel=parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),"The Country Selected is: "+country_sel,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        country_sel="None";

    }


//  Radio Group Selections:
    public void rg_q1(View view)
    {

        int radiobuttonId=rg1.getCheckedRadioButtonId();
        rb1=(RadioButton) findViewById(radiobuttonId);
        Toast.makeText(this,"You Have Selected " +rb1.getText(),Toast.LENGTH_SHORT).show();
        checked=((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.y1:
                if(checked)
                 {
                     Q1="Yes";
                q1=5;
                break;
                 }

            case R.id.n1:
                if(checked)
                {
                    Q1="No";
                    q1=2;
                    break;
                }

        }



    }
    public void rg_q4(View view)
    {
        int radiobuttonId4=rg4.getCheckedRadioButtonId();
        rb4=(RadioButton) findViewById(radiobuttonId4);
        Toast.makeText(this,"You Have Selected: " +rb4.getText(),Toast.LENGTH_SHORT).show();
        switch (view.getId())
        {
            case R.id.y2:
                if(checked)
                {
                    Q4="Yes";
                    q4=3;
                    break;
                }

            case R.id.n2:
                if(checked)
                {
                    Q4="No";
                    q4=0;
                    break;
                }

        }

    }

    public void rg_q6(View view)
    {
        int radiobuttonId6=rg6.getCheckedRadioButtonId();
        rb6=(RadioButton) findViewById(radiobuttonId6);
        Toast.makeText(this,"You Have Selected: " +rb6.getText(),Toast.LENGTH_SHORT).show();
        switch (view.getId())
        {
            case R.id.r_none:
                if(checked)
                {
                    Q6="None";
                    q6=1;
                    break;
                }

            case R.id.r_1:
                if(checked)
                {
                    String Q6="1";
                    q6=2;
                    break;
                }
            case R.id.r_2:
                if(checked)
                {
                    Q6="2";
                    q6=3;
                    break;
                }

            case R.id.r_3:
                if(checked)
                {
                    Q6="3";
                    q6=3;
                    break;
                }
            case R.id.r_4:
                if(checked)
                {
                    Q6="4";
                    q6=3;
                    break;
                }

            case R.id.r_5:
                if(checked)
                {
                    Q6="4+";
                    q6=4;
                    break;
                }

        }

    }

    public void rg_q7(View view) {

        int radiobuttonId7=rg7.getCheckedRadioButtonId();
        rb7=(RadioButton) findViewById(radiobuttonId7);
        Toast.makeText(this,"You Have Selected: " +rb7.getText(),Toast.LENGTH_SHORT).show();
        switch (view.getId())
        {
            case R.id.y3:
                if(checked)
                {
                    Q7="Yes";
                    q7=3;
                    break;
                }

            case R.id.n3:
                if(checked)
                {
                    Q7="No";
                    q7=2;
                    break;
                }

        }
    }

    public void checkSelection(View view)
    {
        Boolean checked1=((CheckBox) view).isChecked();
        switch(view.getId())
        {

            case R.id.c1_1:
                if(checked1)
                {
                    symp.add("High Fever. ");
                    c31=2;
                    break;
                }
                else
                {
                    symp.remove("High Fever. ");
                    c31=0;
                    break;
                }


            case R.id.c1_2:
                if(checked1)
                {
                    symp.add("Dry Cough. ");

                    c32=2;
                    break;
                }
                else
                {
                    symp.remove("Dry Cough. ");
                    c32=0;
                    break;

                }


            case R.id.c1_3:
                if(checked1)
                {
                    symp.add("Mild Breathing Issue. ");
                    c33=3;
                    break;
                }
                else
                {
                    symp.remove("Mild Breathing Issue. ");
                    c33=0;
                    break;

                }



            case R.id.c1_4:
                if(checked1)
                {
                    symp.add("Severe Breathing Issue. ");
                    c34=3;
                    break;
                }
                else
                {
                    symp.remove("Severe Breathing Issue. ");
                    c34=0;
                    break;

                }


            case R.id.c1_5:
                if(checked1)
                {
                    symp.add("Diarrhea. ");
                    c35=1;
                    break;
                }
                else
                {
                    symp.remove("Diarrhea. ");
                    c35=0;
                    break;

                }


            case R.id.c1_6:
                if(checked1)
                {
                    symp.add("Fatigue. ");
                    c36=2;
                    break;
                }
                else
                {
                    symp.remove("Fatigue. ");
                    c36=0;
                    break;

                }


            case R.id.c1_7:
                if(checked1)
                {
                    symp.add("None. ");
                    cc11.setEnabled(false);
                    cc12.setEnabled(false);
                    cc13.setEnabled(false);
                    cc14.setEnabled(false);
                    cc15.setEnabled(false);
                    cc16.setEnabled(false);
                    c37=1;
                    break;
                }
                else
                {
                    symp.remove("None. ");
                    cc11.setEnabled(true);
                    cc12.setEnabled(true);
                    cc13.setEnabled(true);
                    cc14.setEnabled(true);
                    cc15.setEnabled(true);
                    cc16.setEnabled(true);
                    c37=0;
                    break;

                }


            case R.id.c2_1:
                if(checked1)
                {
                    med_cond.add("Heart Problem. ");
                    c51=3;
                    break;
                }
                else
                {
                    med_cond.remove("Heart Problem. ");
                    c51=0;
                    break;

                }


            case R.id.c2_2:
                if(checked1)
                {

                    med_cond.add("Blood Pressure. ");
                    c52=3;
                    break;
                }
                else
                {
                    med_cond.remove("Blood Pressure. ");
                    c52=0;
                    break;

                }

            case R.id.c2_3:
                if(checked1)
                {
                    med_cond.add("Diabetes. ");
                    c53=2;
                    break;
                }
                else
                {
                    med_cond.remove("Diabetes. ");
                    c53=0;
                    break;

                }

            case R.id.c2_4:
                if(checked1)
                {
                    med_cond.add("Bone Issue. ");
                    c54=2;
                    break;
                }
                else
                {
                    med_cond.remove("Bone Issue. ");
                    c54=0;
                    break;

                }

            case R.id.c2_5:
                if(checked1)
                {
                    
                    med_cond.add("None. ");
                    c55=3;

                    cc21.setEnabled(false);
                    cc22.setEnabled(false);
                    cc23.setEnabled(false);
                    cc24.setEnabled(false);

                    break;
                }
                else
                {
                    med_cond.remove("None.");
                    c51=0;
                    cc21.setEnabled(true);
                    cc22.setEnabled(true);
                    cc23.setEnabled(true);
                    cc24.setEnabled(true);
                    break;

                }




        }

    }


}
