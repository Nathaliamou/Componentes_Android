package com.example.otros_componentes_sabado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class ComputadorActivity extends AppCompatActivity {
    TextView jtvprocesadores, jtvDiscoSol, jtvComponentes, jtvsubtotal, jtviva, jtvtotal;
    RadioButton jrbCORE_5, jrbCORE_7, jrbCORE_9, jrbRAM_8, jrbRAM_16;
    CheckBox jcbDISCO_SOLIDO, jcbComponentes;
    DecimalFormat formato = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computador);
        // Ocultar la barra de titulo por defecto
        //getSupportActionBar().hide();
        //Asociar objetos Java con los objetos Xml
        //jtvprocesadores,jtvDiscoSol,jtvComponentes,jtvsubtotal,jtviva,jtvtotal
        jtvprocesadores = findViewById(R.id.tvprocesadores);
        jtvDiscoSol = findViewById(R.id.tvDiscoSol);
        jtvComponentes = findViewById(R.id.tvComponentes);
        jtviva = findViewById(R.id.tviva);
        jtvsubtotal = findViewById(R.id.tvsubtotal);
        jtvtotal = findViewById(R.id.tvtotal);
        jrbCORE_5 = findViewById(R.id.rbCORE_5);
        jrbCORE_7 = findViewById(R.id.rbCORE_7);
        jrbCORE_9 = findViewById(R.id.rbCORE_9);
        jrbRAM_8 = findViewById(R.id.rbRAM_8);
        jrbRAM_16 = findViewById(R.id.rbRAM_16);
        jcbDISCO_SOLIDO = findViewById(R.id.cbDISCO_SOLIDO);
        jcbComponentes = findViewById(R.id.cbComponentes);
    }//fin metodo onCreate

    public void Calcular_Computador(View view) {
        float val_Componentes, val_procesador, val_RAM, val_DiscoSolido,
                val_subtotal, val_iva, val_total;
        //Validando el valor por procesador
        if (jrbCORE_5.isChecked()) {
            jtvprocesadores.setText("1200000");
            val_procesador = 1200000;
        } else {
            if (jrbCORE_7.isChecked()) {
                jtvprocesadores.setText("2000000");
                val_procesador = 2000000;
            } else {
                jtvprocesadores.setText("4000000");
                val_procesador = 4000000;
            }
        }

        //Validando el valor por ram
        if (jrbRAM_8.isChecked()) {
            val_RAM = 1200000;
        } else {

            val_RAM = 2000000;
        }
        //Validar el opcional de disco solido
        if (jcbDISCO_SOLIDO.isChecked()) {
            jtvDiscoSol.setText("400000");
            val_DiscoSolido = 400000;
        } else {
            jtvDiscoSol.setText("0");
            val_DiscoSolido = 0;
        }
        //Validar el opcional de componentes
        if (jcbComponentes.isChecked()) {
            jtvComponentes.setText("200000");
            val_Componentes = 200000;
        } else {
            jtvComponentes.setText("0");
            val_Componentes = 0;
        }
        //Hacer las operaciones
        val_subtotal = val_procesador + val_RAM + val_Componentes + val_DiscoSolido;
        val_iva = (val_subtotal * 19) / 100;
        val_total = val_subtotal + val_iva;
        //Mostrar resultados
        jtvsubtotal.setText(formato.format(val_subtotal));
        jtviva.setText(formato.format(val_iva));
        jtvtotal.setText(formato.format(val_total));
    }//Fin metodo Calcular_Computador

    public void Limpiar(View view) {
        jrbCORE_5.setChecked(true);
        jtvprocesadores.setText("");
        jrbRAM_8.setChecked(true);

        jcbDISCO_SOLIDO.setChecked(false);
        jtvDiscoSol.setText("0");
        jtvprocesadores.setText("0");
        jcbComponentes.setChecked(true);
        jtvComponentes.setText("");
        jtvsubtotal.setText("");
        jtviva.setText("");
        jtvtotal.setText("");
    }//Fin metodo Limpiar

    public void Regresar(View view) {
        Intent intmenu = new Intent(this, MenuActivity.class);
        startActivity(intmenu);
    }
}//fin metodo Regresar
