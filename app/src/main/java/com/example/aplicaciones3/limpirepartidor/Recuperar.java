package com.example.aplicaciones3.limpirepartidor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Recuperar extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar);
        findViewById(R.id.cerrar).setOnClickListener(this);
        findViewById(R.id.enviar).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.cerrar:
                Intent cerrar = new Intent(Recuperar.this,Login.class);
                startActivity(cerrar);
                break;
            case R.id.enviar:
                Intent enviar = new Intent(Recuperar.this,Recovery.class);
                startActivity(enviar);
                break;
        }
    }
}
