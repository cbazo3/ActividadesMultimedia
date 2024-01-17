package com.example.menulateral;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Recuperar datos enviados por el Intent
        if (getIntent().hasExtra("user_data")) {
            String userData = getIntent().getStringExtra("user_data");

            // Mostrar datos en un TextView
            TextView textView = findViewById(R.id.textViewProfile);
            textView.setText(userData);
        }
    }
}

