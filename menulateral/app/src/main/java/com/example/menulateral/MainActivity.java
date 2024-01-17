package com.example.menulateral;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.menulateral.HomeActivity;
import com.example.menulateral.ProfileActivity;
import com.example.menulateral.R;
import com.example.menulateral.SettingActivity;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        drawerList = findViewById(R.id.drawer_list);

        String[] sections = {"Inicio", "Perfil", "Configuración"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sections);
        drawerList.setAdapter(adapter);

        actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                R.string.drawer_open,
                R.string.drawer_close
        );

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        drawerList.setOnItemClickListener((parent, view, position, id) -> selectDrawerItem(position));

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void selectDrawerItem(int position) {
        Intent intent;
        switch (position) {
            case 0:
                intent = new Intent(this, HomeActivity.class);
                intent.putExtra("section", "Inicio");
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(this, ProfileActivity.class);
                intent.putExtra("section", "Perfil");
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(this, SettingActivity.class);
                intent.putExtra("section", "Configuración");
                startActivity(intent);
                break;
            default:
                break;
        }

        drawerLayout.closeDrawer(drawerList);
    }
}
