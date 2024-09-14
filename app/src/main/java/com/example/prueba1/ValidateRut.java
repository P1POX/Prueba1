package com.example.prueba1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ValidateRut extends AppCompatActivity {

    private Button btnVolver, btnValidationRut;
    private EditText etRut;
    private TextView tvValidationRut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.validation_rut);

        btnVolver = findViewById(R.id.btnVolverRut);
        btnValidationRut = findViewById(R.id.btnValidationRut);
        etRut = findViewById(R.id.etRut);
        tvValidationRut = findViewById(R.id.tvValidationRut);

        btnVolver.setOnClickListener(v -> finish());

        btnValidationRut.setOnClickListener(v -> {
            String inputRut = etRut.getText().toString();
            if (!inputRut.isEmpty()) {
                String rut = "";
                if (!inputRut.contains("-")) {
                    etRut.setError("Formato incorrecto: 12345678-9 2");
                    tvValidationRut.setText("");
                    return;
                }
                for (int i = 0; i < inputRut.length(); i++) {
                    char c = inputRut.charAt(i);
                    if (!((c >= '0' && c <= '9') || c == '-' || c == 'k' || c == 'K')) {
                        etRut.setError("Formato incorrecto: 12345678-9 0");
                        tvValidationRut.setText("");
                        return;
                    } else if (c == '-' && i != (inputRut.length() - 2)) {
                        etRut.setError("Formato incorrecto: 12345678-9 1");
                        tvValidationRut.setText("");
                        return;
                    } else if ((c == 'k' || c == 'K') && i != inputRut.length() - 1) {
                        etRut.setError("Formato incorrecto: 12345678-9 2");
                        tvValidationRut.setText("");
                        return;
                    } else if (c != '-' && c != 'k' && c != 'K' && i != inputRut.length() - 1) {
                        rut = c + rut;
                    }
                }
                int sum = 0;
                for (int j = 0; j < rut.length(); j++) {
                    String number = String.valueOf(rut.charAt(j));
                    sum += Integer.parseInt(number) * (j%6+2);
                }
                int digit = 11 - (sum % 11);
                char d;
                switch (digit) {
                    case 11:
                        d = '0';
                        break;
                    case 10:
                        d = 'k';
                        break;
                    default:
                        d = (char) (digit + '0');
                        break;
                }
                char lastDigit = inputRut.charAt(inputRut.length() - 1);
                if (((lastDigit == 'k' || lastDigit == 'K') && d == 'k') || lastDigit == d) {
                    tvValidationRut.setText("RUT válido");
                } else {
                    tvValidationRut.setText("RUT inválido");
                }
            } else {
                Toast.makeText(this, "Por favor ingrese un RUT", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
