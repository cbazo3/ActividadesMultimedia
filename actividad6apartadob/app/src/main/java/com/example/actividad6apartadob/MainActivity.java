package com.example.actividad6apartadob;

// src/main/java/com/tu_paquete/MainActivity.java
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button buttonChangeColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        buttonChangeColor = findViewById(R.id.buttonChangeColor);

        buttonChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSelectedColor();
            }
        });

        // Cargar el color de fondo almacenado en las preferencias
        loadBackgroundColor();
    }

    private void loadBackgroundColor() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        int backgroundColor = preferences.getInt("background_color", Color.WHITE);
        textView.setBackgroundColor(backgroundColor);
    }

    private void showSelectedColor() {
        // Al hacer clic en el botón, actualizamos el color de fondo
        loadBackgroundColor();
    }
}
