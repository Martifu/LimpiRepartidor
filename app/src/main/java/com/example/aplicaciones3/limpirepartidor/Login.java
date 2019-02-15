package com.example.aplicaciones3.limpirepartidor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById(R.id.registro).setOnClickListener(this);
        findViewById(R.id.recuperar).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.registro:
                Intent registro = new Intent(Login.this,registro.class);
                startActivity(registro);
                break;
            case R.id.recuperar:
                Intent recuperar = new Intent(Login.this,Recuperar.class);
                startActivity(recuperar);
                break;
        }
    }
}
