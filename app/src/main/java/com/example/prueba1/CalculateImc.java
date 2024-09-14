package com.example.prueba1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CalculateImc extends AppCompatActivity {

    private Button btnVolver, btnCalculateImc;
    private EditText etWeight, etHeight;
    private TextView tvCalculateImc;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_imc);

        btnVolver = findViewById(R.id.btnVolverImc);
        btnCalculateImc = findViewById(R.id.btnCalculateImc);
        etWeight = findViewById(R.id.etWeight);
        etHeight = findViewById(R.id.etHeight);
        tvCalculateImc = findViewById(R.id.tvCalculateImc);

        btnVolver.setOnClickListener(v -> finish());

        btnCalculateImc.setOnClickListener(v -> {
            String inputWeight = etWeight.getText().toString();
            String inputHeight = etHeight.getText().toString();
            if (!inputWeight.isEmpty() || !inputHeight.isEmpty()) {
                double height = Double.parseDouble(inputHeight) / 100;
                height = height * height;
                double imc = Math.round(Double.parseDouble(inputWeight)) / height;
                String level;
                if (imc < 18.5) {
                    level = "Bajo peso";
                } else if (18.5 <= imc && imc < 25.0) {
                    level = "Normal";
                } else if (25.0 <= imc && imc < 30.0) {
                    level = "Sobrepeso";
                } else {
                    level = "Obesidad";
                }
                tvCalculateImc.setText("Resultado: "+ String.format("%.2f", imc) + " - " + level);
            } else {
                Toast.makeText(this, "Por favor ingrese un peso y una altura", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
