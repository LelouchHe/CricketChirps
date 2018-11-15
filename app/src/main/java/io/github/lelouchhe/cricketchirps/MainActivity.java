package io.github.lelouchhe.cricketchirps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etChirps;
    Button btnCalculate;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        etChirps = this.findViewById(R.id.etChirps);
        btnCalculate = this.findViewById(R.id.btnCalculate);
        tvResult = this.findViewById(R.id.tvResult);

        tvResult.setVisibility(View.GONE);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String chirpsValue = etChirps.getText().toString().trim();
                if (chirpsValue.isEmpty()) {
                    Toast.makeText(MainActivity.this, "input chirps count", Toast.LENGTH_SHORT).show();
                    return;
                }

                int chirps;
                try {
                    chirps = Integer.parseInt(chirpsValue);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "chirps count is too large to be possible", Toast.LENGTH_SHORT).show();
                    return;
                }

                double temperature = chirps / 3.0 + 4;

                tvResult.setText(String.format("The appropriate temperature is %.1f degrees Celsius.", temperature));
                tvResult.setVisibility(View.VISIBLE);
            }
        });
    }
}
