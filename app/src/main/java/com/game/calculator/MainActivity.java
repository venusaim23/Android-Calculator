package com.game.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.game.calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private String storedTextString = "";
    private String displayTextString = "";
    private double currentDisplayNumber = 0;
    private boolean dot = false;
    private double storedNumber = 0;

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

        for (ImageButton i: inputButtons)
            i.setOnClickListener(listener);

        binding.buttonAc.setOnClickListener(v -> reset());

        binding.buttonBack.setOnClickListener(view -> {
            if (symbol == 0) {
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

        binding.buttonPercent.setOnClickListener(v -> {
            symbol = 1;
            //remainder
        });

        binding.buttonDivide.setOnClickListener(v -> {
            symbol = 2;
            //divide
        });

        binding.buttonMultiply.setOnClickListener(v -> {
            symbol = 3;
            //multiply
        });

        binding.buttonSubtract.setOnClickListener(v -> {
            symbol = 4;
            //subtract
        });

        binding.buttonAdd.setOnClickListener(v -> {
            symbol = 5;
            //add
        });

        binding.buttonRoot.setOnClickListener(v -> {
            symbol = 6;

            storedNumber = currentDisplayNumber;
            storedTextString = rootStr + storedNumber;
            binding.storeTv.setText(storedTextString);

            currentDisplayNumber = Math.sqrt(storedNumber);
            displayTextString = equalStr + currentDisplayNumber;
            binding.displayTv.setText(displayTextString);
        });
    }

    private View.OnClickListener listener = v -> {
        if (symbol != 0)
            reset();

        appendString(v.getContentDescription().toString());
    };

    private void appendString(String str) {
        if (str.equals("0")) {
            if (currentDisplayNumber == 0)
                return;
        }

        if (str.equals("."))
            dot = true;

        displayTextString = displayTextString.concat(str);
        binding.displayTv.setText(displayTextString);
        currentDisplayNumber = Double.parseDouble(displayTextString);
    }

    private void reset() {
        displayTextString = "";
        currentDisplayNumber = 0;
        storedNumber = 0;
        dot = false;
        symbol = 0;
        binding.displayTv.setText(getResources().getString(R.string.zero_text));
        binding.storeTv.setText(null);
    }
}