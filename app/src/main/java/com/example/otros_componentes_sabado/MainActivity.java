package com.example.otros_componentes_sabado;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }//fin metodo onCreate

    public void Ingresar(View view){
        //Pasar de una actividad a otra
        Intent intmenu=new Intent(this,MenuActivity.class);
        startActivity(intmenu);
    }//Fin metodo Ingresar
}