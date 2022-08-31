package com.example.homework9;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Converter extends Activity {

    private Double exchangeRate = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter2);

        Bundle extras = getIntent().getExtras();
        String currency = extras.getString("currency");
        switch (currency) {
            case "cad":
                exchangeRate = 1.26;
                break;
            case "yen":
                exchangeRate = 109.94;
                break;
            case "eur":
                exchangeRate = 0.85;
                break;
        }

        TextView otherLabel = findViewById(R.id.OtherLabel);
        otherLabel.setText(currency);
    }

    public void closeConverter(View view) {
        finish();
    }

    public void onFromUSDClick(View view) {
        TextView UsdCurrency = findViewById(R.id.UsdCurrency);
        String usdInput = UsdCurrency.getText().toString();
        if (!usdInput.isEmpty()) {
            Double usd = Double.parseDouble(usdInput);
            Double otherCurrency = usd * exchangeRate;
            TextView OtherCurrency = findViewById(R.id.OtherCurrency);
            OtherCurrency.setText(otherCurrency.toString());
        }
    }

    public void onToUSDClick(View view) {
        TextView OtherCurrency = findViewById(R.id.OtherCurrency);
        String othInput = OtherCurrency.getText().toString();
        if (!othInput.isEmpty()) {
            Double oth = Double.parseDouble(othInput);
            Double usdCurrency = oth / exchangeRate;
            TextView UsdCurrency = findViewById(R.id.UsdCurrency);
            UsdCurrency.setText(usdCurrency.toString());
        }
    }
}