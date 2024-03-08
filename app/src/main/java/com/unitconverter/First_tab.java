package com.unitconverter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

/**
 * Fragment representing the first tab for currency conversion.
 */
public class First_tab extends Fragment {

    // UI components
    private EditText editTextUSD;
    private TextView textViewEuro, textViewRupee, textViewAUD, textViewCAD;
    private Button convertCurrencyButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first_tab, container, false);

        // Initialize UI components
        editTextUSD = view.findViewById(R.id.editTextUSD);
        textViewEuro = view.findViewById(R.id.textViewEuro);
        textViewRupee = view.findViewById(R.id.textViewRupee);
        textViewAUD = view.findViewById(R.id.textViewAUD);
        textViewCAD = view.findViewById(R.id.textViewCAD);
        convertCurrencyButton = view.findViewById(R.id.convertCurrencyButton);

        // Set click listener for the Convert button
        convertCurrencyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertCurrency();
            }
        });

        return view;
    }

    /**
     * Converts the entered US Dollars to Euro, Indian Rupee, Australian Dollars, and Canadian Dollars.
     */
    private void convertCurrency() {
        try {
            // Get the entered US Dollars value
            double usDollars = Double.parseDouble(editTextUSD.getText().toString());

            // Conversion rates
            double euro = usDollars * 0.92;
            double rupee = usDollars * 82.68;
            double aud = usDollars * 1.51;
            double cad = usDollars * 1.35;

            // Display the converted values in TextViews
            textViewEuro.setText("Euro: " + euro);
            textViewRupee.setText("Indian Rupee: " + rupee);
            textViewAUD.setText("Australian Dollars: " + aud);
            textViewCAD.setText("Canadian Dollars: " + cad);

        } catch (NumberFormatException e) {
            // Handle the case when the input is not a valid number
            // You can show a toast or any other error handling mechanism here
        }
    }
}
