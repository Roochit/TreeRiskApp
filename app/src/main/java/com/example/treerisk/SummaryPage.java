package com.example.treerisk;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SummaryPage extends AppCompatActivity {
//    step 1
    TextView data01, desc01, data02, desc02, data03, desc03;
    View box01, box02, box03;
    ImageButton myUserButton;
    int allScore;
    Button SumtoHomeBT,myclearButton;

    SharedPreferences prefe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_summary_page);
//        step 2
        data01 = findViewById(R.id.Data01);
        desc01 = findViewById(R.id.Description01);
        data02 = findViewById(R.id.Data02);
        desc02 = findViewById(R.id.Description02);
        data03 = findViewById(R.id.Data03);
        desc03 = findViewById(R.id.Description03);

        box01 = findViewById(R.id.Box01);
        box02 = findViewById(R.id.Box02);
        box03 = findViewById(R.id.Box03);

        myUserButton = findViewById(R.id.userButton);

        SumtoHomeBT = findViewById(R.id.SumtoHomeBT);
        myclearButton = findViewById(R.id.clearButton);

        prefe = getSharedPreferences("TreeRiskData", MODE_PRIVATE);

        loadOldData();

        boolean viewOnly = getIntent().getBooleanExtra("viewOnly", false);

        if (!viewOnly) {
            allScore = getIntent().getIntExtra("Allscore", 0);
            int index = prefe.getInt("lastIndex", 0);


            RiskData risk = getRiskLevel(allScore);


            saveRiskData(index, risk);


            if (index == 0) setData(data01, desc01, box01, risk);
            else if (index == 1) setData(data02, desc02, box02, risk);
            else if (index == 2) setData(data03, desc03, box03, risk);


            prefe.edit().putInt("lastIndex", (index + 1) % 3).apply();
        }

        SumtoHomeBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(getApplicationContext(), HomePage.class);
                startActivity(myintent);
            }
        });

        myclearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = prefe.edit();
                editor.clear(); // ล้างข้อมูลทั้งหมดใน TreeRiskData
                editor.apply();

                // ล้างข้อความและสีในหน้า
                data01.setText("Data01");
                desc01.setText("description");
                box01.setBackgroundColor(Color.parseColor("#E0E0E0"));

                data02.setText("Data02");
                desc02.setText("description");
                box02.setBackgroundColor(Color.parseColor("#E0E0E0"));

                data03.setText("Data03");
                desc03.setText("description");
                box03.setBackgroundColor(Color.parseColor("#E0E0E0"));

                // แจ้งเตือนผู้ใช้
                Toast.makeText(SummaryPage.this, "ลบข้อมูลทั้งหมดเรียบร้อยแล้ว", Toast.LENGTH_SHORT).show();
            }
        });

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


    private void saveRiskData(int index, RiskData risk) {
        SharedPreferences.Editor editor = prefe.edit();
        editor.putInt("level_" + index, risk.level);
        editor.putString("desc_" + index, risk.description);
        editor.putString("color_" + index, risk.colorHex);
        editor.apply();
    }

    private void loadOldData() {
        for (int i = 0; i < 3; i++) {
            int level = prefe.getInt("level_" + i, -1);
            String desc = prefe.getString("desc_" + i, null);
            String color = prefe.getString("color_" + i, null);

            if (level != -1 && desc != null && color != null) {
                RiskData oldRisk = new RiskData(level, desc, color);
                if (i == 0) setData(data01, desc01, box01, oldRisk);
                else if (i == 1) setData(data02, desc02, box02, oldRisk);
                else if (i == 2) setData(data03, desc03, box03, oldRisk);
            }
        }
    }

    private void setData(TextView data, TextView desc, View box, RiskData risk) {
        data.setText("ระดับความเสี่ยง " + risk.level);
        desc.setText(risk.description);
        box.setBackgroundColor(Color.parseColor(risk.colorHex));
    }

    private RiskData getRiskLevel(int score) {
        if (score <= 7) return new RiskData(1, "นักลงทุนอนุรักษ์นิยมที่สุด (Very Conservative) \n เหมาะกับการลงทุนในสินทรัพย์ที่มีความเสี่ยงต่ำมาก เช่น เงินฝากออมทรัพย์ พันธบัตรรัฐบาล หรือกองทุนตลาดเงิน เพื่อรักษาเงินต้นเป็นหลัก กำไรอาจไม่มาก แต่มีความมั่นคงสูง", "#A8E6CF");
        else if (score == 8) return new RiskData(2, "นักลงทุนอนุรักษ์นิยม (Conservative) \n ควรเน้นการลงทุนที่มีความเสี่ยงต่ำเป็นส่วนใหญ่ เช่น พันธบัตรรัฐบาล พันธบัตรเอกชนคุณภาพดี และอาจมีสัดส่วนเล็กน้อยในกองทุนตราสารหนี้หรือหุ้นปันผล เพื่อเพิ่มผลตอบแทนเล็กน้อย", "#DCEDC1");
        else if (score == 9) return new RiskData(3, "นักลงทุนเสี่ยงต่ำ (Low Risk) \n สามารถยอมรับความผันผวนได้บ้าง ลงทุนในพันธบัตรเอกชน กองทุนตราสารหนี้ระยะยาว หรือกองทุนผสมบางส่วน เพื่อให้ผลตอบแทนสูงกว่าเงินฝาก แต่ยังคงรักษาความปลอดภัยของเงินต้น", "#FFD3B6");
        else if (score <= 11) return new RiskData(4, "นักลงทุนเสี่ยงต่ำ-ปานกลาง (Low–Moderate) \n ควรจัดพอร์ตแบบผสมระหว่างตราสารหนี้และหุ้น เช่น 70/30 หรือ 60/40 เพื่อให้ได้ผลตอบแทนที่เพิ่มขึ้น แต่ยังควบคุมความผันผวนได้ เหมาะกับผู้ที่เริ่มลงทุนระยะยาว", "#FFAAA5");
        else if (score <= 13) return new RiskData(5, "นักลงทุนเสี่ยงปานกลาง (Moderate) \n สามารถรับความผันผวนของตลาดได้พอสมควร เหมาะกับผู้ลงทุนระยะกลางถึงยาว อาจลงทุนในกองทุนผสม หุ้นขนาดใหญ่ และตราสารหนี้บางส่วน เพื่อสร้างสมดุลระหว่างความเสี่ยงและผลตอบแทน", "#FF8B94");
        else if (score <= 15) return new RiskData(6, "นักลงทุนเสี่ยงปานกลาง–สูง (Moderate–High) \n เหมาะกับผู้ที่ต้องการผลตอบแทนมากขึ้น และเข้าใจความผันผวนของตลาด ควรเน้นหุ้นหรือกองทุนหุ้นประมาณ 70–80% และถือสินทรัพย์ปลอดภัยบางส่วนไว้กระจายความเสี่ยง", "#FF6F61");
        else if (score <= 17) return new RiskData(7, "นักลงทุนเสี่ยงสูง (High) \n เหมาะกับผู้ที่รับความเสี่ยงได้ดี และมองการลงทุนระยะยาว เช่น หุ้นเติบโต หุ้นต่างประเทศ หรือกองทุน thematic มีโอกาสได้ผลตอบแทนสูง แต่ต้องยอมรับการขาดทุนระยะสั้นได้", "#FF3D00");
        else return new RiskData(8, "นักลงทุนเสี่ยงสูงสุด (Very High) \n เหมาะกับผู้ที่เข้าใจตลาดการลงทุนเชิงลึก ยอมรับความผันผวนสูงมากได้ อาจลงทุนในหุ้นเทคโนโลยี สินทรัพย์ดิจิทัล หรือสินทรัพย์ทางเลือก เช่น Startup หรือ Crypto โดยต้องมีการติดตามอย่างใกล้ชิด", "#BF360C");
    }

    private static class RiskData {
        int level;
        String description;
        String colorHex;

        RiskData(int level, String description, String colorHex) {
            this.level = level;
            this.description = description;
            this.colorHex = colorHex;
        }
    }
}

