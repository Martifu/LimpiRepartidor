package com.example.aplicaciones3.limpirepartidor;

import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout mDrawerlayout;
    private ActionBarDrawerToggle mToggle;
    Button abrir, cerrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerlayout = findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this,mDrawerlayout, R.string.open, R.string.close);
        abrir = findViewById(R.id.abrir);


        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        abrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerlayout.openDrawer(GravityCompat.START);
            }
        });

        if (savedInstanceState == null )
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.fcontent,
                    new PerfilFragment()).commit();
            navigationView.setCheckedItem(R.id.perfil);
        }



    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.perfil:
                getSupportFragmentManager().beginTransaction().replace(R.id.fcontent,
                        new PerfilFragment()).commit();
                Toast.makeText(this, "Jalo", Toast.LENGTH_SHORT).show();
                break;
        }
        mDrawerlayout.closeDrawer(GravityCompat.START);
        return true;
    }


}
