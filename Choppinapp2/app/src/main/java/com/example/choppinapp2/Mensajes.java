package com.example.choppinapp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Mensajes extends AppCompatActivity {

    EditText etMsj,etCel;
    Button btnEnviar;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensajes);

        etMsj=findViewById(R.id.editTextTextPersonName4);
        etCel=findViewById(R.id.editTextTextPersonName5);
        btnEnviar = findViewById(R.id.button25);

        if(ActivityCompat.checkSelfPermission(Mensajes.this, Manifest.permission.SEND_SMS)!=
                PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(Mensajes.this,new String[]{Manifest.permission.SEND_SMS},1);
        }




        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(etCel.getText().toString(),null,etMsj.getText().toString(),null,null);
            }
        });

    }
}
