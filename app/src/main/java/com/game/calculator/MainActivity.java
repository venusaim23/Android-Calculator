package com.game.calculator;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.game.calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private String storedTextString = "";
    private String displayTextString = "";
    private double currentDisplayNumber = 0;

    private String firstOperand = "";
    private String secondOperand = "";
    private double storedNumber = 0;
    private boolean isSecondOperand = false;
    // Variable to keep track of the running total
    private double runningTotal = 0;

    // 0 - None, 1 - percent, 2 - Divide, 3 - multiply, 4 - subtract, 5 - add, 6 - root
    private int symbol = 0;

    private String rootStr;
    private String equalStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbarCalculator);

        ImageButton[] inputButtons = new ImageButton[]{binding.button0, binding.button1, binding.button2,
                binding.button3, binding.button4, binding.button5, binding.button6,
                binding.button7, binding.button8, binding.button9, binding.buttonDot};

        currentDisplayNumber = Double.parseDouble(getResources().getString(R.string.zero_text));
        rootStr = getResources().getString(R.string.square_root_sign);
        equalStr = getResources().getString(R.string.equal_sign);

        for (ImageButton i : inputButtons)
            i.setOnClickListener(listener);

        binding.buttonRoot.setOnClickListener(v -> {
            Log.d("Button Clicked", "Square Root");
            symbol = 6;  // 7 represents the square root operation
            performOperation();
            displayTextString = "";
            binding.displayTv.setText(String.valueOf(runningTotal));
        });

        binding.buttonBack.setOnClickListener(view -> {
            // Check if the string is not empty
            if (!displayTextString.isEmpty()) {
                // Remove the last character
                displayTextString = displayTextString.substring(0, displayTextString.length() - 1);
                // Update the display
                binding.displayTv.setText(displayTextString);
            }
        });

        binding.buttonPercent.setOnClickListener(v -> {
            Log.d("Button Clicked", "Percent");
            symbol = 1;
            firstOperand = displayTextString;
            isSecondOperand = true;
            displayTextString = "";
            binding.displayTv.setText("%");
        });

        binding.buttonDivide.setOnClickListener(v -> {
            Log.d("Button Clicked", "Divide");
            performOperation();
            symbol = 2;
            displayTextString = "";
            binding.displayTv.setText("/");
        });

        binding.buttonMultiply.setOnClickListener(v -> {
            Log.d("Button Clicked", "Multiply");
            performOperation();
            symbol = 3;
            displayTextString = "";
            binding.displayTv.setText("X");
        });

        binding.buttonSubtract.setOnClickListener(v -> {
            Log.d("Button Clicked", "Minus");
            performOperation();
            symbol = 4;
            displayTextString = "";
            binding.displayTv.setText("-");
        });

        binding.buttonAdd.setOnClickListener(v -> {
            Log.d("Button Clicked", "Plus");
            performOperation();
            symbol = 5;
            displayTextString = "";
            binding.displayTv.setText("+");
        });


        // Modify the equal button click listener
        binding.buttonEqual.setOnClickListener(v -> {
            Log.d("Button Clicked", "Equals");
            performOperation();
            binding.displayTv.setText(String.valueOf(runningTotal));
            Log.d("Calculation", "Result: " + runningTotal);
            displayTextString = String.valueOf(runningTotal);
            symbol = 0;
        });

        binding.buttonAc.setOnClickListener(v -> {
            Log.d("Button Clicked", "AC");
            displayTextString = "";
            firstOperand = "";
            isSecondOperand = false;
            symbol = 0;
            runningTotal = 0;  // Resetting the running total
            binding.displayTv.setText("0");
        });
    }

    // New function to perform the operation
    private void performOperation() {
        try {
            double operand = Double.parseDouble(displayTextString);
            switch (symbol) {
                case 0:  // No operation set yet, initialize runningTotal
                    runningTotal = operand;
                    break;
                case 1:
                    runningTotal = (runningTotal / 100) * operand;
                    break;
                case 2:
                    runningTotal /= operand;
                    break;
                case 3:
                    runningTotal *= operand;
                    break;
                case 4:
                    runningTotal -= operand;
                    break;
                case 5:
                    runningTotal += operand;
                    break;
                case 6:
                    runningTotal = Math.sqrt(operand);
                    break;
            }
        } catch (Exception e) {
            Log.d("Calculation", "Error: " + e.getMessage());
        }
        firstOperand = String.valueOf(runningTotal);
    }

    private View.OnClickListener listener = v -> {
        if (isSecondOperand) {
            displayTextString = "";
            isSecondOperand = false;
        }

        appendString(v.getContentDescription().toString());
        Log.d("Button Clicked", v.getContentDescription().toString());
    };

    private void appendString(String str) {
        displayTextString = displayTextString.concat(str);
        binding.displayTv.setText(displayTextString);
    }
}