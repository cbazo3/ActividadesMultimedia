package com.example.navigationdrawer;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    // Agrega las referencias al EditText y al botón
    private EditText editText;
    private Button btnSubmit;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    // Agrega este método para inflar la vista del fragmento
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Obtener una referencia al EditText y al botón dentro del fragmento
        editText = view.findViewById(R.id.editText);
        btnSubmit = view.findViewById(R.id.submitButton);

        // Agregar un OnClickListener al botón
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener el texto ingresado en el EditText
                String textoIngresado = editText.getText().toString();

                // Llamar al método para mostrar el cuadro de diálogo con los datos ingresados
                mostrarDialogoConDatos(textoIngresado);
            }
        });

        return view;
    }

    private void mostrarDialogoConDatos(String datos) {
        // Crea un AlertDialog.Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());

        // Configura el título y el mensaje del cuadro de diálogo
        builder.setTitle("Datos ingresados");
        builder.setMessage("Tu nombre es: " + datos);

        // Agrega un botón de OK
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        // Muestra el cuadro de diálogo
        builder.show();
    }
}
