package com.example.tema5act2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProductoAdapter adapter;
    private List<Objeto> objetos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar objetos...
        objetos = new ArrayList<>();
        objetos.add(new Objeto("Maillot 1", "Granate y elastico", R.drawable.img1));
        objetos.add(new Objeto("Maillot 2", "Azul marino con blonda", R.drawable.img2));
        objetos.add(new Objeto("Maillot 1", "Granate y elastico", R.drawable.img1));
        objetos.add(new Objeto("Maillot 2", "Azul marino con blonda", R.drawable.img2));
        objetos.add(new Objeto("Maillot 1", "Granate y elastico", R.drawable.img1));
        objetos.add(new Objeto("Maillot 2", "Azul marino con blonda", R.drawable.img2));
        objetos.add(new Objeto("Maillot 1", "Granate y elastico", R.drawable.img1));
        objetos.add(new Objeto("Maillot 2", "Azul marino con blonda", R.drawable.img2));
        objetos.add(new Objeto("Maillot 1", "Granate y elastico", R.drawable.img1));
        objetos.add(new Objeto("Maillot 2", "Azul marino con blonda", R.drawable.img2));
        objetos.add(new Objeto("Maillot 1", "Granate y elastico", R.drawable.img1));
        objetos.add(new Objeto("Maillot 2", "Azul marino con blonda", R.drawable.img2));
        objetos.add(new Objeto("Maillot 1", "Granate y elastico", R.drawable.img1));
        objetos.add(new Objeto("Maillot 2", "Azul marino con blonda", R.drawable.img2));
        objetos.add(new Objeto("Maillot 1", "Granate y elastico", R.drawable.img1));
        objetos.add(new Objeto("Maillot 2", "Azul marino con blonda", R.drawable.img2));
        objetos.add(new Objeto("Maillot 1", "Granate y elastico", R.drawable.img1));
        objetos.add(new Objeto("Maillot 2", "Azul marino con blonda", R.drawable.img2));
        objetos.add(new Objeto("Maillot 1", "Granate y elastico", R.drawable.img1));
        objetos.add(new Objeto("Maillot 2", "Azul marino con blonda", R.drawable.img2));

        // ...

        // Inicializar RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Inicializar y configurar adaptador
        adapter = new ProductoAdapter(objetos);
        recyclerView.setAdapter(adapter);
    }
}