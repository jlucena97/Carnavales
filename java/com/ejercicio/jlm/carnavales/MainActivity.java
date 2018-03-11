package com.ejercicio.jlm.carnavales;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rellenarLista();

    }


    public void rellenarLista() {

        ArrayList<Carnaval> listaCarnvales = new ArrayList<Carnaval>();
        listaCarnvales.add(new Carnaval(R.drawable.foto, "Carnaval Cadiz", "Ubicación: Cádiz \n Fecha: 8-18 Febrero de 2018"));
        listaCarnvales.add(new Carnaval(R.drawable.foto1, "Carnaval Córdoba", "Ubicación: Córdoba \n Fecha: 14-18 Febrero de 2018"));
        listaCarnvales.add(new Carnaval(R.drawable.foto2, "Carnaval Sevilla", "Ubicación: Sevilla \n Fecha: 9-18 Febrero de 2018"));
        listaCarnvales.add(new Carnaval(R.drawable.foto3, "Carnaval Huelva", "Ubicación: Huelva \n Fecha: 8-17 Febrero de 2018"));
        listaCarnvales.add(new Carnaval(R.drawable.foto4, "Carnaval Almería", "Ubicación: Almería \n Fecha: 6-7 Febrero de 2018"));
        listaCarnvales.add(new Carnaval(R.drawable.foto5, "Carnaval Jaen", "Ubicación: Jaén \n Fecha: 13-15 Febrero de 2018"));
        listaCarnvales.add(new Carnaval(R.drawable.foto6, "Carnaval Málaga", "Ubicación: Málaga \n Fecha: 3-11 Febrero de 2018"));
        listaCarnvales.add(new Carnaval(R.drawable.foto7, "Carnaval Granada", "Ubicación: Granada \n Fecha: 11-15 Febrero de 2018"));

        lista = (ListView) findViewById(R.id.listaCarnaval);
        lista.setAdapter(new AdaptadorCarnaval(this, R.layout.entrada, listaCarnvales) {

            public void onEntrada(Object entrada, View view) {
                if (entrada != null) {
                    TextView texto_superior = (TextView) view.findViewById(R.id.tituloCarnaval);
                    if (texto_superior != null) {
                        texto_superior.setText(((Carnaval) entrada).titulo);
                    }
                    TextView text_inferior = (TextView) view.findViewById(R.id.descripcionCarnaval);
                    if (text_inferior != null) {
                        text_inferior.setText(((Carnaval) entrada).subtitulo);
                    }
                    ImageView imagen = (ImageView) view.findViewById(R.id.imagenCarnaval);
                    if (imagen != null) {
                        imagen.setImageResource(((Carnaval) entrada).idImagen);
                    }
                }
            }

        });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Carnaval elegido = (Carnaval) parent.getItemAtPosition(position);
                CharSequence texto = "Seleccionado: " + elegido.titulo;
                Toast tost = Toast.makeText(MainActivity.this, texto, Toast.LENGTH_LONG);
                tost.show();
            }
        });
    }

}
