package com.unitconverter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
/////////////////////////////////////
//////////FOR LENGTH FRAGMENT///////
////////////////////////////////////
public class Second_tab extends Fragment {

    private EditText editTextMiles;
    private TextView textViewKilometers, textViewMeters, textViewFeet, textViewInches;
    private Button convertButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second_tab, container, false);

        // Initialize UI components
        editTextMiles = view.findViewById(R.id.editTextMiles);
        textViewKilometers = view.findViewById(R.id.textViewKilometers);
        textViewMeters = view.findViewById(R.id.textViewMeters);
        textViewFeet = view.findViewById(R.id.textViewFeet);
        textViewInches = view.findViewById(R.id.textViewInches);
        convertButton = view.findViewById(R.id.convertButton);

        // Set click listener for the Convert button
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertLength();
            }
        });

        return view;
    }

    private void convertLength() {
        try {
            // Get the entered miles value
            double miles = Double.parseDouble(editTextMiles.getText().toString());

            // Convert miles to other units
            double kilometers = miles * 1.60934;
            double meters = miles * 1609.34;
            double feet = miles * 5280;
            double inches = miles * 63360;

            // Display the converted values in TextViews
            textViewKilometers.setText("Kilometers: " + kilometers);
            textViewMeters.setText("Meters: " + meters);
            textViewFeet.setText("Feet: " + feet);
            textViewInches.setText("Inches: " + inches);

        } catch (NumberFormatException e) {
            // Handle the case when the input is not a valid number
            // You can show a toast or any other error handling mechanism here
        }
    }
}
