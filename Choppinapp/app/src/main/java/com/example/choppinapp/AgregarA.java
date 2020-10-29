package com.example.choppinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AgregarA extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
    }

    public void Atras (View view){

        Intent intent = new Intent(this, Principal.class);
        startActivity(intent);
    }
}