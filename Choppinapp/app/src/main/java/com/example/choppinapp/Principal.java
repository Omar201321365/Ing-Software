package com.example.choppinapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class Principal extends AppCompatActivity{
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


    }
    public void AgregarA (View view){

        Intent intent = new Intent(this, AgregarA.class);
        startActivity(intent);
    }

    public void IdentificarA (View view){

        Intent intent = new Intent(this, IdentificarA.class);
        startActivity(intent);
    }
    public void BuscarR (View view){

        Intent intent = new Intent(this, Rutas.class);
        startActivity(intent);
    }
    public void AsignarAl (View view){

        Intent intent = new Intent(this, AsignarAlarma.class);
        startActivity(intent);
    }
    public void RealizarC (View view){

        Intent intent = new Intent(this, CarritoDigital.class);
        startActivity(intent);
    }
    public void EnviarM (View view){

        Intent intent = new Intent(this, Mensajes.class);
        startActivity(intent);
    }
}



