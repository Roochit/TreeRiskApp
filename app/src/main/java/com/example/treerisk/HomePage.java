package com.example.treerisk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomePage extends AppCompatActivity {

    //step1
    Button startButton;
    ImageButton myUserButton,myHistoryButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_page);
        //step2
        startButton = findViewById(R.id.startBT);
        myHistoryButton = findViewById(R.id.HistoryButton);
        myUserButton = findViewById(R.id.UserButton);


//        step3 Start Button
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //step 4
                Intent myintent = new Intent(getApplicationContext(), QuestionPage1.class);
                startActivity(myintent);
            }
        });

//        step 3 history Button
        myHistoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                step 4
                Intent myintent = new Intent(getApplicationContext(), SummaryPage.class);
                myintent.putExtra("viewOnly", true);
                startActivity(myintent);
            }
        });

//        step 3 User Button
        myUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(getApplicationContext(), UserPage.class);
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