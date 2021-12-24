package com.example.myinvestcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class StavkaActivity extends AppCompatActivity {

    Button btn_apply;
    TextView tv_stavka;
    String sessionId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stavka);

        btn_apply = findViewById(R.id.btn_apply);
        tv_stavka = findViewById(R.id.tv_stavka);



        //Принимаем интент с первой активити во второй
        sessionId = getIntent().getStringExtra("percent");
        String currentSum = getIntent().getStringExtra("currentSum");
        String currentDays = getIntent().getStringExtra("currentDays");

        tv_stavka.setText(sessionId);

        btn_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(StavkaActivity.this, "Передалось значение " + String.valueOf(sessionId),  Toast.LENGTH_LONG).show();

                sessionId = sessionId.replaceAll(",",".");
                Intent intent2 = new Intent(StavkaActivity.this, MainActivity.class);
                //Отправляем интент со второй активити на 1ю
                intent2.putExtra("upd_percent",String.valueOf(tv_stavka.getText()));
                intent2.putExtra("currentSum", currentSum);
                intent2.putExtra("currentDays", currentDays);
                startActivity(intent2);

            }
        });


    }
}