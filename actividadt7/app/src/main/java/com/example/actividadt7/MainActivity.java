package com.example.actividadt7;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.actividadt7.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText tCodigo, tNombre, tApellido;
    private Button bInsertar, bConsultar;
    private BDUsuarios bd;
    private RecyclerView listaUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ligamos los elementos gráficos
        tCodigo = findViewById(R.id.tCodigo);
        tNombre = findViewById(R.id.tNombre);
        tApellido = findViewById(R.id.tApellido);
        bInsertar = findViewById(R.id.bInsertar);
        bConsultar = findViewById(R.id.bConsultar);
        listaUsuarios = findViewById(R.id.listaUsuarios);

        bd = new BDUsuarios(this);

        bInsertar.setOnClickListener(this);
        bConsultar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bInsertar) {
            int codigo = Integer.valueOf(tCodigo.getText().toString());
            String nombre = tNombre.getText().toString();
            String apellido = tApellido.getText().toString();

            try {
                bd.insertarUsuario(codigo, nombre, apellido);
                Toast.makeText(getApplicationContext(), "Usuario insertado correctamente", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Error: " + e.toString(), Toast.LENGTH_SHORT).show();
                System.out.println("Error: " + e.toString());
            }

        }
        else if (v.getId() == R.id.bConsultar) {
            // Con esto el tamaño del recyclerwiew no cambiará
            listaUsuarios.setHasFixedSize(true);
            // Creo un layoutmanager para el recyclerview
            LinearLayoutManager llm = new LinearLayoutManager(this);
            listaUsuarios.setLayoutManager(llm);

            try
            {
                ArrayList<Usuario> usuariostotales = bd.obtenerTodosUsuarios();

                AdaptadorUsuarios adaptador = new AdaptadorUsuarios(this, usuariostotales);
                listaUsuarios.setAdapter(adaptador);
                adaptador.refrescar();
            }
            catch (Exception e)
            {
                System.out.println("Error obteniendo los usuario: " + e.toString());
            }
        }
    }
}