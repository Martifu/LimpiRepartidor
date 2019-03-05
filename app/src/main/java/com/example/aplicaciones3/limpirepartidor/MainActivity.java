package com.example.aplicaciones3.limpirepartidor;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
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

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements PedidosFragment.OnFragmentInteractionListener,PerfilFragment.OnFragmentInteractionListener,NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout mDrawerlayout;
    private ActionBarDrawerToggle mToggle;
    Button abrir, cerrar,logout;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerlayout = findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this,mDrawerlayout, R.string.open, R.string.close);
        abrir = findViewById(R.id.abrir);
//        logout = findViewById(R.id.logout);

//        logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent salir = new Intent(MainActivity.this,Login.class);
//                startActivity(salir);
//            }
//        });


        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        abrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerlayout.openDrawer(GravityCompat.START);
            }
        });




    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        Fragment fragment = null;
        boolean fragmentseleccionado = false;

        if (id == R.id.perfil){
            fragment = new PerfilFragment();
            fragmentseleccionado = true;
        }
        else if (id == R.id.pedidos){
            fragment = new PedidosFragment();
            fragmentseleccionado = true;
        }

        if (fragmentseleccionado)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.fcontent,fragment).commit();
        }

        mDrawerlayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
