package com.example.treerisk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class QuestionPage1 extends AppCompatActivity {

//    step1
    CheckBox myQ1_1CB,myQ1_2CB,myQ1_3CB,myQ1_4CB,
        myQ2_1CB,myQ2_2CB,myQ2_3CB,myQ2_4CB,
        myQ3_1CB,myQ3_2CB,myQ3_3CB,myQ3_4CB;

    Button myNextBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_question_page1);

//        step2
        myQ1_1CB = findViewById(R.id.Q1_1CB);
        myQ1_2CB = findViewById(R.id.Q1_2CB);
        myQ1_3CB = findViewById(R.id.Q1_3CB);
        myQ1_4CB = findViewById(R.id.Q1_4CB);

        CheckBox [] group1 = {myQ1_1CB,myQ1_2CB,myQ1_3CB,myQ1_4CB};

        for (CheckBox cb : group1) {
            cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        // ถ้ามีอันใดอันหนึ่งถูกติ๊ก ให้ยกเลิกที่เหลือ
                        for (CheckBox other : group1) {
                            if (other != buttonView) {
                                other.setChecked(false);
                            }
                        }
                    }
                }
            });
        }
        int scoreQ1 = getIntent().getIntExtra("scoreQ1", 0);
        if (scoreQ1 != 0) {
            if (scoreQ1 == 1) {
                myQ1_1CB.setChecked(true);
            }
            else if (scoreQ1 == 2){
                myQ1_2CB.setChecked(true);
            }
            else if (scoreQ1 == 3){
                myQ1_3CB.setChecked(true);
            }
            else if (scoreQ1 == 4){
                myQ1_4CB.setChecked(true);
            }
        }


        myQ2_1CB = findViewById(R.id.Q2_1CB);
        myQ2_2CB = findViewById(R.id.Q2_2CB);
        myQ2_3CB = findViewById(R.id.Q2_3CB);
        myQ2_4CB = findViewById(R.id.Q2_4CB);

        CheckBox [] group2 = {myQ2_1CB,myQ2_2CB,myQ2_3CB,myQ2_4CB};
//        Step 3
        for (CheckBox cb : group2) {
            cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                    step 4
                    if (isChecked) {
                        // ถ้ามีอันใดอันหนึ่งถูกติ๊ก ให้ยกเลิกที่เหลือ
                        for (CheckBox other : group2) {
                            if (other != buttonView) {
                                other.setChecked(false);
                            }
                        }
                    }
                }
            });
        }
        int scoreQ2 = getIntent().getIntExtra("scoreQ2", 0);
        if (scoreQ2 != 0) {
            if (scoreQ2 == 1) {
                myQ2_1CB.setChecked(true);
            }
            else if (scoreQ2 == 2){
                myQ2_2CB.setChecked(true);
            }
            else if (scoreQ2 == 3){
                myQ2_3CB.setChecked(true);
            }
            else if (scoreQ2 == 4){
                myQ2_4CB.setChecked(true);
            }
        }

        myQ3_1CB = findViewById(R.id.Q3_1CB);
        myQ3_2CB = findViewById(R.id.Q3_2CB);
        myQ3_3CB = findViewById(R.id.Q3_3CB);
        myQ3_4CB = findViewById(R.id.Q3_4CB);

        CheckBox [] group3 = {myQ3_1CB,myQ3_2CB,myQ3_3CB,myQ3_4CB};

        for (CheckBox cb : group3) {
            cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        // ถ้ามีอันใดอันหนึ่งถูกติ๊ก ให้ยกเลิกที่เหลือ
                        for (CheckBox other : group3) {
                            if (other != buttonView) {
                                other.setChecked(false);
                            }
                        }
                    }
                }
            });
        }
        int scoreQ3 = getIntent().getIntExtra("scoreQ3", 0);
        if (scoreQ3 != 0) {
            if (scoreQ3 == 1) {
                myQ3_1CB.setChecked(true);
            }
            else if (scoreQ3 == 2){
                myQ3_2CB.setChecked(true);
            }
            else if (scoreQ3 == 3){
                myQ3_3CB.setChecked(true);
            }
            else if (scoreQ3 == 4){
                myQ3_4CB.setChecked(true);
            }
        }

        myNextBt = findViewById(R.id.nextBT);


//        step 3 Next Button
        myNextBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                step 4
                int scoreQ1 = 0,scoreQ2 = 0,scoreQ3 = 0,Sumscore1;
                if (myQ1_1CB.isChecked()){
                    scoreQ1 = 1;
                }
                else if (myQ1_2CB.isChecked()){
                    scoreQ1 = 2;
                }
                else if (myQ1_3CB.isChecked()){
                    scoreQ1 = 3;
                }
                else if (myQ1_4CB.isChecked()){
                    scoreQ1 = 4;
                }

                if (myQ2_1CB.isChecked()){
                    scoreQ2 = 1;
                }
                else if (myQ2_2CB.isChecked()){
                    scoreQ2 = 2;
                }
                else if (myQ2_3CB.isChecked()){
                    scoreQ2 = 3;
                }
                else if (myQ2_4CB.isChecked()){
                    scoreQ2 = 4;
                }

                if (myQ3_1CB.isChecked()){
                    scoreQ3 = 1;
                }
                else if (myQ3_2CB.isChecked()){
                    scoreQ3 = 2;
                }
                else if (myQ3_3CB.isChecked()){
                    scoreQ3 = 3;
                }
                else if (myQ3_4CB.isChecked()){
                    scoreQ3 = 4;
                }

                Sumscore1 = scoreQ1 + scoreQ2 + scoreQ3;


                Intent myintent = new Intent(getApplicationContext(), QuestionPage2.class);
                myintent.putExtra("scoreQ1", scoreQ1);
                myintent.putExtra("scoreQ2", scoreQ2);
                myintent.putExtra("scoreQ3", scoreQ3);
                myintent.putExtra("Sumscore1", Sumscore1);
                myintent.putExtra("scoreQ4", getIntent().getIntExtra("scoreQ4", 0));
                myintent.putExtra("scoreQ5", getIntent().getIntExtra("scoreQ5", 0));
                myintent.putExtra("scoreQ6", getIntent().getIntExtra("scoreQ6", 0));
                startActivity(myintent);
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.SumtoHome), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}