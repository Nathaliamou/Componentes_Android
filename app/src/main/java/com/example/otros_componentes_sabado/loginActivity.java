package com.example.otros_componentes_sabado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class loginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }//Fin metodo onCreate

    public void Ingresar(View view){
        Intent intmenu=new Intent(this,MenuActivity.class);
        startActivity(intmenu);
    }//Fin metodo Ingresar

}