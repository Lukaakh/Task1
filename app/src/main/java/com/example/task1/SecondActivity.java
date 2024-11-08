package com.example.task1;  // Ensure this matches your package name

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
package com.example.task1;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView emailTextView;
    private EditText messageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        emailTextView = findViewById(R.id.emailTextView);
        messageEditText = findViewById(R.id.messageEditText);
        Button clearButton = findViewById(R.id.clearButton);

        String email = getIntent().getStringExtra("email");
        String message = getIntent().getStringExtra("message");

        emailTextView.setText(email);
        messageEditText.setText(message);

        clearButton.setOnClickListener(v -> {
            emailTextView.setText("");
            messageEditText.setText("");
        });
    }
}
