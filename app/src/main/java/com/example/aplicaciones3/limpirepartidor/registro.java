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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class registro extends AppCompatActivity implements View.OnClickListener {
    EditText correo, contrasena;
    Button registro;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener stateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        FirebaseAuth.getInstance().signOut();
        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.cerrar).setOnClickListener(this);
        findViewById(R.id.registro).setOnClickListener(this);


        correo = findViewById(R.id.correo);
        contrasena = findViewById(R.id.contraseña);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.cerrar:
                Intent intent = new Intent(registro.this,Login.class);
                startActivity(intent);
                break;
            case R.id.registro:
                registro();
                break;
        }
    }

    public void registro()
    {
        final String
                Correo = String.valueOf(correo.getText()),
                Contra = String.valueOf(contrasena.getText());
        if (!Correo.isEmpty() && !Contra.isEmpty()) {
            mAuth.createUserWithEmailAndPassword(Correo,Contra).addOnCompleteListener(registro.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                        user.sendEmailVerification();
                        Intent regi = new Intent(registro.this,Recovery.class);
                        startActivity(regi);
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(registro.this, "" + e, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}
