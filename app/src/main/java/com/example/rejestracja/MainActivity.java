package com.example.rejestracja;

import android.os.Bundle;
import android.util.Patterns;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextPasswordRepeat;
    private TextView textViewMessage;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);;
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextPasswordRepeat = findViewById(R.id.editTextPasswordRepeat);
        textViewMessage = findViewById(R.id.textViewMessage);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(!Patterns.EMAIL_ADDRESS.matcher(editTextEmail.getText().toString().trim()).matches()){
                    textViewMessage.setText("Nieprawidłowy adres e-mail.");
                } else if(!editTextPasswordRepeat.getText().toString().trim().equals(editTextPassword.getText().toString().trim())){
                    textViewMessage.setText("Hasła się różnią.");
                } else {
                    textViewMessage.setText("Witaj " + editTextEmail.getText().toString().trim());
                }
            }
        });
    }
}