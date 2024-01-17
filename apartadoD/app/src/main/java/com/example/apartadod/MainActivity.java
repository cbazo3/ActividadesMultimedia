package com.example.apartadod;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private Fragment[] fragments;
    private String[] fragmentTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Asegúrate de que el diseño de tu actividad tenga un ViewPager con el ID "viewPager".

        // Inicializa los fragmentos que deseas mostrar
        fragments = new Fragment[]{
                new TextFragment(),
                new ImageFragment(),
                new TableFragment()
        };

        // Opcional: inicializa los títulos de las páginas
        fragmentTitles = new String[]{
                "Texto",
                "Imagen",
                "Formulario"
        };

        // Inicializa el ViewPager y el adaptador
        viewPager = findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments, fragmentTitles);

        // Configura el ViewPager con el adaptador
        viewPager.setAdapter(viewPagerAdapter);
    }
}