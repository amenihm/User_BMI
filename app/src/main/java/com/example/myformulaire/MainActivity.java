package com.example.myformulaire;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText etWeight;
    EditText etHeight;
    Button btnCalculateBMI;
    TextView tvBMI;
    TextView tvInterpretation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        etWeight = findViewById(R.id.etWeight);
        etHeight = findViewById(R.id.etHeight);
        btnCalculateBMI = findViewById(R.id.btnCalculateBMI);
        tvBMI = findViewById(R.id.tvBMI);
        tvInterpretation = findViewById(R.id.tvInterpretation);

        // Set click listener
        btnCalculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        // Get weight and height from EditText
        String weightStr = etWeight.getText().toString();
        String heightStr = etHeight.getText().toString();

        if (!weightStr.isEmpty() && !heightStr.isEmpty()) {
            float weight = Float.parseFloat(weightStr);
            float height = Float.parseFloat(heightStr) / 100;

            float bmi = weight / (height * height);
            tvBMI.setText(String.format("BMI: %.2f", bmi));

            String interpretation;
            if (bmi < 18.5) {
                interpretation = "Underweight";
            } else if (bmi < 24.9) {
                interpretation = "Normal weight";
            } else if (bmi < 29.9) {
                interpretation = "Overweight";
            } else {
                interpretation = "Obesity";
            }
            tvInterpretation.setText(interpretation);
        } else {
            tvBMI.setText("Please enter valid values.");
            tvInterpretation.setText("");
        }
    }
}
