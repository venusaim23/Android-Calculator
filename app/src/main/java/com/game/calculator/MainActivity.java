package com.game.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    ImageButton plus, minus, multiply, divide, percent, root, ac, back;
    TextView display;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.button_0);
        btn1 = findViewById(R.id.button_1);
        btn2 = findViewById(R.id.button_2);
        btn3 = findViewById(R.id.button_3);
        btn4 = findViewById(R.id.button_4);
        btn5 = findViewById(R.id.button_6);
        btn6 = findViewById(R.id.button_7);
        btn8 = findViewById(R.id.button_8);
        btn9 = findViewById(R.id.button_9);

        plus = findViewById(R.id.button_plus);
        minus = findViewById(R.id.button_minus);
        multiply = findViewById(R.id.button_multiply);
        divide = findViewById(R.id.button_divide);
        percent = findViewById(R.id.button_percent);
        root = findViewById(R.id.button_root);
        ac = findViewById(R.id.button_ac);
        back = findViewById(R.id.button_back);

        display = findViewById(R.id.display_tv);
        imageView = findViewById(R.id.imageView);

    }
}