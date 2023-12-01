package com.example.otros_componentes_sabado;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    }//fin metodo onCreate

    public void Viajes(View view){
        Intent intviajes=new Intent(this,ViajesActivity.class);
        startActivity(intviajes);
    }//Fin metodo Viajes

    public void Computador(View view){
        Intent intcomputador=new Intent(this,ComputadorActivity.class);
        startActivity(intcomputador);
    }//Fin metodo Computador
}