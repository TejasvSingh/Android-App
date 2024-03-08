package com.unitconverter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

//////////////////////////////////
///FOR WEIGHT FRAGMENT///////////
public class Third_tab extends Fragment {

    private EditText editTextPounds;
    private TextView textViewKilograms, textViewGrams, textViewOunces;
    private Button convertWeightButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third_tab, container, false);

        // Initialize UI components
        editTextPounds = view.findViewById(R.id.editTextPounds);
        textViewKilograms = view.findViewById(R.id.textViewKilograms);
        textViewGrams = view.findViewById(R.id.textViewGrams);
        textViewOunces = view.findViewById(R.id.textViewOunces);
        convertWeightButton = view.findViewById(R.id.convertWeightButton);

        // Set click listener for the Convert button
        convertWeightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertWeight();
            }
        });

        return view;
    }

    private void convertWeight() {
        try {
            // Get the entered pounds value
            double pounds = Double.parseDouble(editTextPounds.getText().toString());

            // Convert pounds to other units
            double kilograms = pounds * 0.453592;
            double grams = pounds * 453.592;
            double ounces = pounds * 16;

            // Display the converted values in TextViews
            textViewKilograms.setText("Kilograms: " + kilograms);
            textViewGrams.setText("Grams: " + grams);
            textViewOunces.setText("Ounces: " + ounces);

        } catch (NumberFormatException e) {
            // Handle the case when the input is not a valid number
            // You can show a toast or any other error handling mechanism here
        }
    }
}
