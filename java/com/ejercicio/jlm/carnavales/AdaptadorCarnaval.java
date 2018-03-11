package com.ejercicio.jlm.carnavales;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Josel on 24/01/2018.
 */

public abstract class AdaptadorCarnaval extends BaseAdapter{

    private ArrayList<?> carnaval;
    private int RLayoutIdView;
    private Context contexto;


    public AdaptadorCarnaval (Context contexto, int RLayotIdView, ArrayList<?> carnaval){
        super();
        this.contexto = contexto;
        this.RLayoutIdView = RLayoutIdView;
        this.carnaval = carnaval;
    }

    public View getView(int position, View view, ViewGroup parient){
        if(view == null){
            LayoutInflater vi = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = vi.inflate(R.layout.entrada, null);
        }
        onEntrada(carnaval.get(position),view);
        return view;
    }
    public int getCount (){
        return carnaval.size();
    }
    public long getItemId(int position){return position;}

    public Object getItem(int position){return carnaval.get(position);}

    public abstract void onEntrada(Object entrada, View view);
}
