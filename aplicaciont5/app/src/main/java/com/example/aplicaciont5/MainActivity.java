package com.example.aplicaciont5;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBox1, checkBox2;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Spinner spinner;
    private Switch aSwitch;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        radioGroup = findViewById(R.id.radioGroup);
        spinner = findViewById(R.id.spinner);
        aSwitch = findViewById(R.id.switch1);
        fab = findViewById(R.id.fab);

        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override

                public void onClick(View view) {
                    // Lógica para verificar respuestas y mostrar mensaje de agradecimiento
                    if (isAllQuestionsAnswered()) {
                        showThankYouMessage();
                    } else {
                        // Muestra un mensaje de error
                        showErrorMessage("Por favor, responde todas las preguntas antes de enviar la encuesta.");
                    }
                }
            });


        }

    private void showErrorMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    private boolean isAllQuestionsAnswered() {
        boolean checkBox1Checked = checkBox1.isChecked();
        boolean checkBox2Checked = checkBox2.isChecked();
        boolean radioSelected = radioGroup.getCheckedRadioButtonId() != -1;
        boolean spinnerSelected = spinner.getSelectedItemPosition() > 0;
        boolean switchChecked = aSwitch.isChecked();

        Log.d("DEBUG", "checkBox1Checked: " + checkBox1Checked);
        Log.d("DEBUG", "checkBox2Checked: " + checkBox2Checked);
        Log.d("DEBUG", "radioSelected: " + radioSelected);
        Log.d("DEBUG", "spinnerSelected: " + spinnerSelected);
        Log.d("DEBUG", "switchChecked: " + switchChecked);

        return checkBox1Checked && checkBox2Checked && radioSelected && spinnerSelected && switchChecked;
    }



    private void showThankYouMessage() {
        // Muestra un mensaje de agradecimiento o resumen
        Toast.makeText(getApplicationContext(), "¡Gracias por completar la encuesta!", Toast.LENGTH_SHORT).show();
    }
}
