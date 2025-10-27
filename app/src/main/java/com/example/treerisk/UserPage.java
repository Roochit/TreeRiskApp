package com.example.treerisk;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class UserPage extends AppCompatActivity {

    // step 1
    EditText FullnameET, AddressET, JobET, PhoneNoET;
    Button myUsertoHomeBt,mySaveBT;
    ImageButton myHistoryBT2;

    SharedPreferences userPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_page);
//        step 2
        FullnameET = findViewById(R.id.FullnameET);
        AddressET = findViewById(R.id.AddressET);
        JobET = findViewById(R.id.JobET);
        PhoneNoET = findViewById(R.id.PhoneNoET);

        myHistoryBT2 = findViewById(R.id.historyButton2);

        mySaveBT = findViewById(R.id.SaveButton);
        myUsertoHomeBt = findViewById(R.id.UsertoHome);

        // เตรียม SharedPreferences
        userPref = getSharedPreferences("UserData", MODE_PRIVATE);

        // โหลดข้อมูลที่เคยบันทึกไว้
        loadUserData();

        // ปุ่มบันทึก
        mySaveBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUserData();
            }
        });



//        step3 User to Home Button
        myUsertoHomeBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                step 4
                Intent myintent = new Intent(getApplicationContext(), HomePage.class);
                startActivity(myintent);
            }
        });

        myHistoryBT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(getApplicationContext(), SummaryPage.class);
                myintent.putExtra("viewOnly", true);
                startActivity(myintent);
            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    private void saveUserData() {
        SharedPreferences.Editor editor = userPref.edit();
        editor.putString("fullname", FullnameET.getText().toString());
        editor.putString("address", AddressET.getText().toString());
        editor.putString("job", JobET.getText().toString());
        editor.putString("phone", PhoneNoET.getText().toString());
        editor.apply();

        Toast.makeText(this, "บันทึกข้อมูลเรียบร้อยแล้ว", Toast.LENGTH_SHORT).show();
    }

    private void loadUserData() {
        String name = userPref.getString("fullname", "");
        String address = userPref.getString("address", "");
        String job = userPref.getString("job", "");
        String phone = userPref.getString("phone", "");

        FullnameET.setText(name);
        AddressET.setText(address);
        JobET.setText(job);
        PhoneNoET.setText(phone);
    }
}