package com.game.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.game.calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private String displayTextString = "";
    private double currentDisplayNumber = 0;
    private boolean dot = false;
    private double storedNumber = 0;

    // 0 - None, 1 - percent, 2 - Divide, 3 - multiply, 4 - subtract, 5 - add
    private int symbol = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbarCalculator);

        currentDisplayNumber = Double.parseDouble(getResources().getString(R.string.zero_text));

        binding.button0.setOnClickListener(listener);
        binding.button1.setOnClickListener(listener);
        binding.button2.setOnClickListener(listener);
        binding.button3.setOnClickListener(listener);
        binding.button4.setOnClickListener(listener);
        binding.button5.setOnClickListener(listener);
        binding.button6.setOnClickListener(listener);
        binding.button7.setOnClickListener(listener);
        binding.button8.setOnClickListener(listener);
        binding.button9.setOnClickListener(listener);

        binding.buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //insert dot
            }
        });

        binding.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (displayTextString.length() > 1) {
                    displayTextString = displayTextString.substring(0, displayTextString.length() - 1);
                    binding.displayTv.setText(displayTextString);
                    currentDisplayNumber = Double.parseDouble(displayTextString);
                } else if (displayTextString.length() == 1) {
                    displayTextString = "";
                    binding.displayTv.setText(getResources().getString(R.string.zero_text));
                    currentDisplayNumber = 0;
                }
            }
        });

        binding.buttonAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayTextString = "";
                currentDisplayNumber = 0;
                storedNumber = 0;
                dot = false;
                symbol = 0;
                binding.displayTv.setText(getResources().getString(R.string.zero_text));
            }
        });
    }

    private View.OnClickListener listener = v -> {
        if (symbol == 0)
            appendString(v.getContentDescription().toString());
        else {
            //store number and new line
        }
    };

    private void appendString(String digit) {
        if (digit.equals("0")) {
            if (currentDisplayNumber == 0)
                return;
        }
        displayTextString = displayTextString.concat(digit);
        binding.displayTv.setText(displayTextString);
        currentDisplayNumber = Double.parseDouble(displayTextString);
        //
    }
}