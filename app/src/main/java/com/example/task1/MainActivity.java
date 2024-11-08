package com.example.task1;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText messageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.emailEditText);
        messageEditText = findViewById(R.id.messageEditText);
        Button sendButton = findViewById(R.id.sendButton);

        sendButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString();
            String message = messageEditText.getText().toString();

            if (isValidEmail(email) && isValidMessage(message)) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("email", email);
                intent.putExtra("message", message);
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "Invalid email or message", Toast.LENGTH_SHORT).show();
            }
        });

        messageEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 250) {
                    messageEditText.setError("Message cannot exceed 250 characters");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private boolean isValidEmail(String email) {
        return email.contains("@");
    }

    private boolean isValidMessage(String message) {
        return message.length() <= 250;
    }
}
