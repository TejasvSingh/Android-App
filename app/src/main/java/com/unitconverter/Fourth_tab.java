package com.unitconverter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class Fourth_tab extends Fragment {

    private EditText editTextFahrenheit;
    private TextView textViewCelsius, textViewKelvin;
    private Button convertTemperatureButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fourth_tab, container, false);

        // Initialize UI components
        editTextFahrenheit = view.findViewById(R.id.editTextFahrenheit);
        textViewCelsius = view.findViewById(R.id.textViewCelsius);
        textViewKelvin = view.findViewById(R.id.textViewKelvin);
        convertTemperatureButton = view.findViewById(R.id.convertTemperatureButton);

        // Set click listener for the Convert button
        convertTemperatureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertTemperature();
            }
        });

        return view;
    }

    private void convertTemperature() {
        try {
            // Get the entered Fahrenheit value
            double fahrenheit = Double.parseDouble(editTextFahrenheit.getText().toString());

            // Convert Fahrenheit to other units
            double celsius = (fahrenheit - 32) * 5/9;
            double kelvin = (fahrenheit + 459.67) * 5/9;

            // Display the converted values in TextViews
            textViewCelsius.setText("Celsius: " + celsius);
            textViewKelvin.setText("Kelvin: " + kelvin);

        } catch (NumberFormatException e) {
            // Handle the case when the input is not a valid number
            // You can show a toast or any other error handling mechanism here
        }
    }
}
