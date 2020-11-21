package com.example.choppinapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ListArticulos extends AppCompatActivity {

    private EditText et_codigo,et_descripcion,et_precio;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_articulos);
    }


    public void Registrar(View veiew){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper( this,"administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();
        String descripcion = et_descripcion.getText().toString();
        String precio = et_precio.getText().toString();

        if (!codigo.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty()){

            ContentValues registro = new ContentValues();
            registro.put("codigo",codigo);
            registro.put("descripcion",descripcion);
            registro.put("precio",precio);

            BaseDeDatos.insert("articulos", null, registro);
            BaseDeDatos.close();
            et_codigo.setText("");
            et_descripcion.setText("");
            et_precio.setText("");
        }else{
            Toast.makeText(this,"Debes llenar los campos", Toast.LENGTH_SHORT).show();
        }
    }

    public void Buscar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase BaseDeDataBase = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();

        if(!codigo.isEmpty()){
            Cursor fila = BaseDeDataBase.rawQuery
                    ("select descripcion, precio from articulos where codigo ="+ codigo, null);
            if(fila.moveToFirst()){

                et_descripcion.setText(fila.getString(0));
                et_precio.setText(fila.getString(1));
                BaseDeDataBase.close();

            }else{
                Toast.makeText(this,"No existe el articulo", Toast.LENGTH_SHORT).show();
                BaseDeDataBase.close();
            }

        }else{
            Toast.makeText(this,"Debes introducir el codigo del articulo", Toast.LENGTH_SHORT).show();
        }

    }


    public void Eliminar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion",null, 1);
        SQLiteDatabase BaseDataBase = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();

        if(!codigo.isEmpty()){

            int cantidad = BaseDataBase.delete("articulos", "codigo="+ codigo, null);
            BaseDataBase.close();
            et_codigo.setText("");
            et_descripcion.setText("");
            et_precio.setText("");

            if(cantidad == 1){
                Toast.makeText(this,"Articulo eliminado exitosamente", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"El articulo no existe", Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this,"Debes introducir el codigo del articulo", Toast.LENGTH_SHORT).show();
        }
    }

    public void modificar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase BaseDatabase = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();
        String descripcion = et_descripcion.getText().toString();
        String precio = et_precio.getText().toString();

        if(!codigo.isEmpty()&& !descripcion.isEmpty() && !precio.isEmpty()){

            ContentValues registro = new ContentValues();
            registro.put("codigo",codigo);
            registro.put("descripcion",descripcion);
            registro.put("precio",precio);

            int cantidad = BaseDatabase.update("articulos", registro, "codigo="+codigo ,null);
            BaseDatabase.close();

            if(cantidad == 1){
                Toast.makeText(this,"El articulo se modifico correctamente", Toast.LENGTH_SHORT).show();

            }else{
                Toast.makeText(this,"El articulo no existe", Toast.LENGTH_SHORT).show();

            }

        }else{
            Toast.makeText(this,"Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }


    public void Atras (View  view){

        Intent intent = new Intent(this, Principal.class);
        startActivity(intent);
    }
}

