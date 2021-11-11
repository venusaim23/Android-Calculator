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

        currentDisplayNumber = Double.parseDouble(getResources().getString(R.string.default_string_display));

        binding.button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (symbol == 0)
                    appendString(0);
                else {
                    //store number and new line
                }
            }
        });

        binding.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (symbol == 0)
                    appendString(1);
                else {
                    //store number and new line
                }
            }
        });

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (symbol == 0)
                    appendString(2);
                else {
                    //store number and new line
                }
            }
        });

        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (symbol == 0)
                    appendString(3);
                else {
                    //store number and new line
                }
            }
        });

        binding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (symbol == 0)
                    appendString(4);
                else {
                    //store number and new line
                }
            }
        });

        binding.button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (symbol == 0)
                    appendString(5);
                else {
                    //store number and new line
                }
            }
        });

        binding.button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (symbol == 0)
                    appendString(6);
                else {
                    //store number and new line
                }
            }
        });

        binding.button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (symbol == 0)
                    appendString(7);
                else {
                    //store number and new line
                }
            }
        });

        binding.button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (symbol == 0)
                    appendString(8);
                else {
                    //store number and new line
                }
            }
        });

        binding.button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (symbol == 0)
                    appendString(9);
                else {
                    //store number and new line
                }
            }
        });

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
                    binding.displayTv.setText(getResources().getString(R.string.default_string_display));
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
                binding.displayTv.setText(getResources().getString(R.string.default_string_display));
            }
        });
    }

    private void appendString(int digit) {
        if (digit == 0) {
            if (currentDisplayNumber == 0)
                return;
        }
        displayTextString = displayTextString.concat(Integer.toString(digit));
        binding.displayTv.setText(displayTextString);
        currentDisplayNumber = Double.parseDouble(displayTextString);
        //
    }
}