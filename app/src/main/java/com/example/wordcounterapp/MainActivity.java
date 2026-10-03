package com.example.wordcounterapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText InputTextEditText;
    private Spinner MetricSpinner;
    private Button CountButton;
    private TextView ResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InputTextEditText = findViewById(R.id.edtInputText);
        MetricSpinner = findViewById(R.id.spnMetric);
        CountButton = findViewById(R.id.btnCount);
        ResultTextView = findViewById(R.id.ResultTextView);

        TextCounter textCounter = new TextCounter();

        CountButton.setOnClickListener(view -> {
            String text = InputTextEditText.getText().toString();

            if (text.trim().isEmpty()) {
                Toast.makeText(this, getString(R.string.empty_text_warning), Toast.LENGTH_SHORT).show();
                return;
            }

            String selectedMetric = MetricSpinner.getSelectedItem().toString();
            int result = 0;

            switch (selectedMetric) {
                case "Sentences":
                    result = textCounter.CountSentences(text);
                    break;

                case "Words":
                    result = textCounter.CountWords(text);
                    break;

                case "Chars":
                    result = textCounter.CountChars(text);
                    break;

                case "Numbers":
                    result = textCounter.CountNumbers(text);
                    break;
            }

            ResultTextView.setText(String.valueOf(result));
        });
    }
}