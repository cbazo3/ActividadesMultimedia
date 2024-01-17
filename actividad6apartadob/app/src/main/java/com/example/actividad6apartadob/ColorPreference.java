package com.example.actividad6apartadob;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.util.AttributeSet;

public class ColorPreference extends Preference {

    public ColorPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnPreferenceClickListener(new OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                showColorDialog();
                return true;
            }
        });
    }

    private void showColorDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Selecciona un color de fondo");

        // Colores predefinidos
        final CharSequence[] colors = {"Rojo", "Verde", "Azul"};
        final int[] colorValues = {Color.RED, Color.GREEN, Color.BLUE};

        builder.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int selectedColor = colorValues[which];
                saveSelectedColor(selectedColor);
            }
        });

        builder.show();
    }

    private void saveSelectedColor(int color) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(getKey(), color);
        editor.apply();
    }
}
