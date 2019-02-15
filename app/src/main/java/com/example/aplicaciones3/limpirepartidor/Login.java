package com.example.aplicaciones3.limpirepartidor;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity  {
private Button btn1;
private EditText correo;
private EditText contra;
private FirebaseAuth firebaseAuth;
private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onStop() {
        super.onStop();
        if(authStateListener!=null){
            firebaseAuth.removeAuthStateListener(authStateListener);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(authStateListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn1= (Button) findViewById(R.id.log_iniciar);
        correo= (EditText) findViewById(R.id.log_correo);
        contra= (EditText) findViewById(R.id.log_contraseña);

        firebaseAuth= FirebaseAuth.getInstance();
        authStateListener= new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user!=null){
                    if(!user.isEmailVerified())
                        Toast.makeText(Login.this, "Favor de verificar su correo",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Login.this,MainActivity.class));
                }
                else
                {
                    Toast.makeText(Login.this, "¡Welcom to Limpi!",Toast.LENGTH_LONG).show();
                }
            }
        };

    }

   /*@Override
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
    }*/

    public void login(View view) {
        String email = correo.getText().toString();
        String pass = contra.getText().toString();
        if(email!=null && pass!=null){
        firebaseAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(!task.isSuccessful())
                {
                    String mensaje= task.getException().getMessage();
                    Toast.makeText(Login.this,"Error: "+mensaje,Toast.LENGTH_LONG).show();
                }
                else
                {
                    startActivity(new Intent(Login.this,MainActivity.class));
                }
            }
        });}
        else
        {
            Toast.makeText(Login.this,"Por favor llene todos los campos",Toast.LENGTH_LONG).show();
        }

    }
}
