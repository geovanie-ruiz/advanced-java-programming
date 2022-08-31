package com.example.homework9;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button nextButton = findViewById(R.id.openConverter);
        RadioGroup currencyChoices = findViewById(R.id.currency);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int chosenOptionId = currencyChoices.getCheckedRadioButtonId();

                if (chosenOptionId != -1) {
                    RadioButton chosenOption = findViewById(chosenOptionId);
                    String chosenCurrency = chosenOption.getText().toString();
                    Intent intent = new Intent(MainActivity.this, Converter.class);
                    intent.putExtra("currency", chosenCurrency);
                    startActivity(intent);
                }
            }
        });
    }
}