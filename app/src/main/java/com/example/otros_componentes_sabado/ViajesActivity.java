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

public class ViajesActivity extends AppCompatActivity {

    TextView jtvciudad,jtvvehiculo,jtvguia,jtvsubtotal,jtviva,jtvtotal;
    RadioButton jrbcartagena,jrbleticia,jrbpuntacana;
    CheckBox jcbvehiculo,jcbguia;
    EditText jetcantidad;
    DecimalFormat formato=new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viajes);
        // Ocultar la barra de titulo por defecto
        //getSupportActionBar().hide();
        //Asociar objetos Java con los objetos Xml
        //jtvciudad,jtvvehiculo,jtvguia,jtvsubtotal,jtviva,jtvtotal
        jtvciudad=findViewById(R.id.tvciudad);
        jtvguia=findViewById(R.id.tvguia);
        jtvvehiculo=findViewById(R.id.tvvehiculo);
        jtviva=findViewById(R.id.tviva);
        jtvsubtotal=findViewById(R.id.tvsubtotal);
        jtvtotal=findViewById(R.id.tvtotal);
        jrbcartagena=findViewById(R.id.rbcartagena);
        jrbleticia=findViewById(R.id.rbleticia);
        jrbpuntacana=findViewById(R.id.rbpuntacana);
        jcbguia=findViewById(R.id.cbguia);
        jcbvehiculo=findViewById(R.id.cbvehiculo);
        jetcantidad=findViewById(R.id.etcantidad);
        jetcantidad.requestFocus();
    }//fin metodo onCreate

    public void Calcular_Viaje(View view){
        String cantidad;
        //Validar la cantidad de personas
        cantidad=jetcantidad.getText().toString();
        if (!cantidad.isEmpty()){
            float val_persona,val_guia,val_vehiculo,
            val_subtotal,val_iva,val_total;
            int can_personas=0;
            //Convertir de String a float
            can_personas=Integer.parseInt(cantidad);
            //Validar que se digito un numero mayor de cero
            if (can_personas > 0){
                //Validando el valor por ciudad
                if (jrbcartagena.isChecked()){
                    jtvciudad.setText("1200000");
                    val_persona=1200000;
                }else{
                    if (jrbleticia.isChecked()){
                        jtvciudad.setText("2000000");
                        val_persona=2000000;
                    }else{
                        jtvciudad.setText("4000000");
                        val_persona=4000000;
                    }
                }
                //Validar el opcional de vehiculo
                if (jcbvehiculo.isChecked()){
                    jtvvehiculo.setText("400000");
                    val_vehiculo=400000;
                }else{
                    jtvvehiculo.setText("0");
                    val_vehiculo=0;
                }
                //Validar el opcional de guia
                if (jcbguia.isChecked()){
                    jtvguia.setText("200000");
                    val_guia=200000;
                }else{
                    jtvguia.setText("0");
                    val_guia=0;
                }
                //Hacer las operaciones
                val_subtotal=(can_personas * val_persona) + val_vehiculo + val_guia;
                val_iva=(val_subtotal * 19)/100;
                val_total=val_subtotal + val_iva;
                //Mostrar resultados
                jtvsubtotal.setText(formato.format(val_subtotal));
                jtviva.setText(formato.format(val_iva));
                jtvtotal.setText(formato.format(val_total));
            }else{
                Toast.makeText(this, "La cantidad debe ser mayor que cero", Toast.LENGTH_SHORT).show();
                jetcantidad.requestFocus();
            }
        }else{
            Toast.makeText(this, "Cantidad de personas es requerida", Toast.LENGTH_SHORT).show();
            jetcantidad.requestFocus();
        }
    }//Fin metodo Calcular_Viaje

    public void Limpiar(View view){
        jrbcartagena.setChecked(true);
        jtvciudad.setText("");
        jetcantidad.setText("");
        jcbvehiculo.setChecked(false);
        jtvvehiculo.setText("0");
        jcbguia.setChecked(false);
        jtvguia.setText("0");
        jtvsubtotal.setText("");
        jtviva.setText("");
        jtvtotal.setText("");
        jetcantidad.requestFocus();
    }//Fin metodo Limpiar

    public void Regresar(View view){
        Intent intmenu=new Intent(this,MenuActivity.class);
        startActivity(intmenu);
    }//fin metodo Regresar
}