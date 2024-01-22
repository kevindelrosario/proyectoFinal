package com.example.sqlite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdaptador extends RecyclerView.Adapter<RecyclerViewAdaptador.ViewHolder> {

    public static class ViewHolder extends  RecyclerView.ViewHolder{
        private TextView tarjeta, efectivo, total;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tarjeta = (TextView) itemView.findViewById(R.id.txtTarjeta);
            efectivo = (TextView) itemView.findViewById(R.id.txtEfectivo);
            total = (TextView) itemView.findViewById(R.id.vistaTotal);


        }
    }
public List<VentaModelo> ventaLista;

    public RecyclerViewAdaptador(List<VentaModelo> ventaLista) {
        this.ventaLista = ventaLista;
    }

    //Se encarga de agregar mas elementos a la activity:
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_tabla_prueba, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }


    //realiza las modificaciones para cada item:


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tarjeta.setText((int) ventaLista.get(position).getTarjeta());
        holder.efectivo.setText((int) ventaLista.get(position).getTarjeta());
        holder.total.setText((int) ventaLista.get(position).getTarjeta());
    }


    //Indica la cantidad de elementos que se procesaran:


    @Override
    public int getItemCount() {
        return ventaLista.size();
    }
}
