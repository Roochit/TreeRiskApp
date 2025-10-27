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

public class QuestionPage2 extends AppCompatActivity {


//    step 1
    Button BackBT,SendBT;
    CheckBox myQ4_1CB,myQ4_2CB,myQ4_3CB,myQ4_4CB,
            myQ5_1CB,myQ5_2CB,myQ5_3CB,myQ5_4CB,
            myQ6_1CB,myQ6_2CB,myQ6_3CB,myQ6_4CB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_question_page2);

//        step 2
//        Question 4
        myQ4_1CB = findViewById(R.id.Q4_1CB);
        myQ4_2CB = findViewById(R.id.Q4_2CB);
        myQ4_3CB = findViewById(R.id.Q4_3CB);
        myQ4_4CB = findViewById(R.id.Q4_4CB);

        CheckBox [] group1 = {myQ4_1CB,myQ4_2CB,myQ4_3CB,myQ4_4CB};

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
        int scoreQ4 = getIntent().getIntExtra("scoreQ4", 0);
        if (scoreQ4 != 0) {
            if (scoreQ4 == 1) {
                myQ4_1CB.setChecked(true);
            }
            else if (scoreQ4 == 2){
                myQ4_2CB.setChecked(true);
            }
            else if (scoreQ4 == 3){
                myQ4_3CB.setChecked(true);
            }
            else if (scoreQ4 == 4){
                myQ4_4CB.setChecked(true);
            }
        }


//        Question 5
        myQ5_1CB = findViewById(R.id.Q5_1CB);
        myQ5_2CB = findViewById(R.id.Q5_2CB);
        myQ5_3CB = findViewById(R.id.Q5_3CB);
        myQ5_4CB = findViewById(R.id.Q5_4CB);

        CheckBox [] group2 = {myQ5_1CB,myQ5_2CB,myQ5_3CB,myQ5_4CB};

        for (CheckBox cb : group2) {
            cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
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

        int scoreQ5 = getIntent().getIntExtra("scoreQ5", 0);
        if (scoreQ5 != 0) {
            if (scoreQ5 == 1) {
                myQ5_1CB.setChecked(true);
            }
            else if (scoreQ5 == 2){
                myQ5_2CB.setChecked(true);
            }
            else if (scoreQ5 == 3){
                myQ5_3CB.setChecked(true);
            }
            else if (scoreQ5 == 4){
                myQ5_4CB.setChecked(true);
            }
        }

        //        Question 6
        myQ6_1CB = findViewById(R.id.Q6_1CB);
        myQ6_2CB = findViewById(R.id.Q6_2CB);
        myQ6_3CB = findViewById(R.id.Q6_3CB);
        myQ6_4CB = findViewById(R.id.Q6_4CB);

        CheckBox [] group3 = {myQ6_1CB,myQ6_2CB,myQ6_3CB,myQ6_4CB};

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
        int scoreQ6 = getIntent().getIntExtra("scoreQ6", 0);
        if (scoreQ6 != 0) {
            if (scoreQ6 == 1) {
                myQ6_1CB.setChecked(true);
            }
            else if (scoreQ6 == 2){
                myQ6_2CB.setChecked(true);
            }
            else if (scoreQ6 == 3){
                myQ6_3CB.setChecked(true);
            }
            else if (scoreQ6 == 4){
                myQ6_4CB.setChecked(true);
            }
        }

//        step 2 Back Button
        BackBT = findViewById(R.id.BackButton);
//        step 3 Back Button
        BackBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int scoreQ4 = 0,scoreQ5 = 0,scoreQ6 = 0;
                if (myQ4_1CB.isChecked()){
                    scoreQ4 = 1;
                }
                else if (myQ4_2CB.isChecked()){
                    scoreQ4 = 2;
                }
                else if (myQ4_3CB.isChecked()){
                    scoreQ4 = 3;
                }
                else if (myQ4_4CB.isChecked()){
                    scoreQ4 = 4;
                }

                if (myQ5_1CB.isChecked()){
                    scoreQ5 = 1;
                }
                else if (myQ5_2CB.isChecked()){
                    scoreQ5 = 2;
                }
                else if (myQ5_3CB.isChecked()){
                    scoreQ5 = 3;
                }
                else if (myQ5_4CB.isChecked()){
                    scoreQ5 = 4;
                }
                if (myQ6_1CB.isChecked()){
                    scoreQ6 = 1;
                }
                else if (myQ6_2CB.isChecked()){
                    scoreQ6 = 2;
                }
                else if (myQ6_3CB.isChecked()){
                    scoreQ6 = 3;
                }
                else if (myQ6_4CB.isChecked()){
                    scoreQ6 = 4;
                }
//                step 4 Back Button
                Intent myintent = new Intent(getApplicationContext(), QuestionPage1.class);
                myintent.putExtra("scoreQ1", getIntent().getIntExtra("scoreQ1", 0));
                myintent.putExtra("scoreQ2", getIntent().getIntExtra("scoreQ2", 0));
                myintent.putExtra("scoreQ3", getIntent().getIntExtra("scoreQ3", 0));
                myintent.putExtra("scoreQ4", scoreQ4);
                myintent.putExtra("scoreQ5", scoreQ5);
                myintent.putExtra("scoreQ6", scoreQ6);
                startActivity(myintent);
                finish();
            }
        });

//        step2 Send Button
        SendBT = findViewById(R.id.SendButton);

//        step3
        SendBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int scoreQ4 = 0,scoreQ5 = 0,scoreQ6 = 0,Sumscore2 = 0 , Allscore;
                if (myQ4_1CB.isChecked()){
                    scoreQ4 = 1;
                }
                else if (myQ4_2CB.isChecked()){
                    scoreQ4 = 2;
                }
                else if (myQ4_3CB.isChecked()){
                    scoreQ4 = 3;
                }
                else if (myQ4_4CB.isChecked()){
                    scoreQ4 = 4;
                }

                if (myQ5_1CB.isChecked()){
                    scoreQ5 = 1;
                }
                else if (myQ5_2CB.isChecked()){
                    scoreQ5 = 2;
                }
                else if (myQ5_3CB.isChecked()){
                    scoreQ5 = 3;
                }
                else if (myQ5_4CB.isChecked()){
                    scoreQ5 = 4;
                }
                if (myQ6_1CB.isChecked()){
                    scoreQ6 = 1;
                }
                else if (myQ6_2CB.isChecked()){
                    scoreQ6 = 2;
                }
                else if (myQ6_3CB.isChecked()){
                    scoreQ6 = 3;
                }
                else if (myQ6_4CB.isChecked()){
                    scoreQ6 = 4;
                }

                Sumscore2 = scoreQ4 + scoreQ5 + scoreQ6;

                int Sumscore1 = getIntent().getIntExtra("Sumscore1", 0);
                Allscore = Sumscore1 + Sumscore2;


                Intent myintent = new Intent(getApplicationContext(), SummaryPage.class);
                myintent.putExtra("Allscore", Allscore);
                myintent.putExtra("viewOnly", false);
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