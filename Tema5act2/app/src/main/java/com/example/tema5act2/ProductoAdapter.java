package com.example.tema5act2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder> {
    private List<Objeto> productos;

    public ProductoAdapter(List<Objeto> productos) {
        this.productos = productos;
    }

    @Override
    public ProductoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_producto, parent, false);
        return new ProductoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProductoViewHolder holder, int position) {
        Objeto objeto = productos.get(position);
        holder.nombreProducto.setText(objeto.getNombreObjeto());
        holder.descripcionProducto.setText(objeto.getDescripcionObjeto());
        holder.imagenProducto.setImageResource(objeto.getImagenResourceId());
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public static class ProductoViewHolder extends RecyclerView.ViewHolder {
        public TextView nombreProducto;
        public TextView descripcionProducto;
        public ImageView imagenProducto;

        public ProductoViewHolder(View itemView) {
            super(itemView);
            nombreProducto = itemView.findViewById(R.id.nombreProducto);
            descripcionProducto = itemView.findViewById(R.id.descripcionProducto);
            imagenProducto = itemView.findViewById(R.id.imagenProducto);
        }
    }
}