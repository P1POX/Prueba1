package com.example.prueba1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btnValidate, btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnValidate = findViewById(R.id.btnValidate);
        btnCalculate = findViewById(R.id.btnCalculate);

        btnValidate.setOnClickListener(v -> {
            Intent intent = new Intent(this, ValidateRut.class);
            startActivity(intent);
        });

        btnCalculate.setOnClickListener(v -> {
            Intent intent = new Intent(this, CalculateImc.class);
            startActivity(intent);
        });
    }
}