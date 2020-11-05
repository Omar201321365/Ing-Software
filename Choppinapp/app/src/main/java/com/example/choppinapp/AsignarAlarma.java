package com.example.choppinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AsignarAlarma extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignar_alarma);
    }
    public void AsignarAlarma (View view){

        Intent intent = new Intent(this, AsignarAl.class);
        startActivity(intent);
    }
    public void Atras (View view){

        Intent intent = new Intent(this, Principal.class);
        startActivity(intent);
    }
}