package com.example.myinvestcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button btn_calc, btn_changePercent;
    TextView tv_sum, tv_percent, tv_days, tv_result;
    String upd_percent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_calc = findViewById(R.id.btn_calc);
        btn_changePercent = findViewById(R.id.btn_changePercent);

        tv_sum = findViewById(R.id.tv_sum);
        tv_days = findViewById(R.id.tv_days);
        tv_percent = findViewById(R.id.tv_percent);
        tv_result = findViewById(R.id.tv_result);

        tv_percent.setText(String.valueOf(5.6));








        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    String sum = tv_sum.getText().toString();
                    String days = tv_days.getText().toString();
                    days = days.replaceAll(",",".");
                    sum = sum.replaceAll(",",".");


                    double percent = Double.parseDouble(String.valueOf(tv_percent.getText()));
                    int i_days = Integer.parseInt(days);
                    double d_sum = Double.parseDouble(sum);
                    double profit = (d_sum * percent * i_days / 365) / 100;
                    double profitPerDay = profit / i_days;
                    double infl = 7.5;
                    double inFact = profit * infl;

              tv_result.setText("При текущих условиях, через " + String.valueOf(days) + " дней прибыль составит "
                      + String.format("%.2f", profit) + " или " +  String.format("%.2f", profitPerDay));
            }
        });

        btn_changePercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), StavkaActivity.class);

                //Отправляем интент с первой активити на вторую
                intent.putExtra("percent", String.valueOf(tv_percent.getText()));
                intent.putExtra("currentDays", String.valueOf(tv_days.getText().toString()));
                intent.putExtra("currentSum", String.valueOf(tv_sum.getText().toString()));

                startActivity(intent);
            }
        });

        try{
            //Получаем интент из активити 2

            String upd_percent = getIntent().getStringExtra("upd_percent");
            String sum = getIntent().getStringExtra("currentSum");
            String days = getIntent().getStringExtra("currentDays");

            if (upd_percent.isEmpty()){
               // Toast.makeText(MainActivity.this, "upd_percent is impty",  Toast.LENGTH_LONG).show();
            }
            else{
              //  Toast.makeText(MainActivity.this, "upd_percent is " + upd_percent,  Toast.LENGTH_LONG).show();
                upd_percent = upd_percent.replaceAll(",",".");
                tv_percent.setText(upd_percent);
                tv_sum.setText(sum);
                tv_days.setText(days);
            }
        }catch (RuntimeException e){
           // Toast.makeText(MainActivity.this, "upd_percent dosnt exist", Toast.LENGTH_LONG).show();
        }






    }
}