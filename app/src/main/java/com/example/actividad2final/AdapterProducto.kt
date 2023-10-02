package com.example.actividad2final

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterProducto(private var lista: MutableList<ModelProducto>): RecyclerView.Adapter<AdapterProducto.ViewHolder>() {

    //var listaMutable: MutableList<ModelProducto> = ArrayList()

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.producto_card, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {

        val modelProducto = lista[i]

        viewHolder.imagenView.setImageResource(modelProducto.imagen)
        viewHolder.nombreView.text = modelProducto.nombre
        viewHolder.marcaView.text = modelProducto.marca
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    //fun clearData(){lista.clear()}

     class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val imagenView: ImageView = itemView.findViewById(R.id.imagen)
        val nombreView: TextView = itemView.findViewById(R.id.nombre)
        val marcaView: TextView = itemView.findViewById(R.id.marca)
    }

}