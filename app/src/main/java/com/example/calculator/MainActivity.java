package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private CalculatorModel calculator;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int [] numberId = new int[]{
                R.id.one,
                R.id.two,
                R.id.three,
                R.id.fory,
                R.id.fife,
                R.id.sex,
                R.id.seven,
                R.id.eich,
                R.id.nine,
                R.id.zero,
        };
        int [] actionsIds = new int[]{
                R.id.minus,
                R.id.pluse,
                R.id.umnoj,
                R.id.delen,
                R.id.ravno

        };
        text = findViewById(R.id.text);
        calculator = new CalculatorModel();

        View.OnClickListener numberButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.onNumPressed(view.getId());
                text.setText(calculator.getText());
            }
        };
        View.OnClickListener actionButtonOnclickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.onActionPressed(v.getId());
                text.setText(calculator.getText());
            }
        };

        for (int i = 0; i < numberId.length; i++) {
            findViewById(numberId[i]).setOnClickListener(numberButtonClickListener);
        }
        for (int i = 0; i < actionsIds.length; i++) {
            findViewById(actionsIds[i]).setOnClickListener(actionButtonOnclickListener);
        }
    }
}