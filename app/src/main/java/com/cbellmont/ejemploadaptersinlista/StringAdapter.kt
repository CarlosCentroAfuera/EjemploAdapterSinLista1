package com.cbellmont.ejemploadaptersinlista

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.cbellmont.ejemploadaptersinlista.databinding.ItemBinding

class StringAdapter : RecyclerView.Adapter<StringAdapter.StringViewHolder>()  {

    lateinit var binding : ItemBinding

    class StringViewHolder(var itemBinding : ItemBinding) : RecyclerView.ViewHolder(itemBinding.root)

    var numeroDeFilas = 20

    // Aquí solo obtenemos las vistas que están dentro de layout en el que queremos mostrar nuestros elementos
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StringViewHolder {
        binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StringViewHolder(binding)
    }

    // Aquí devolvemos el número de elementos que habrá en nuestro recylcerView
    override fun getItemCount(): Int {
        return numeroDeFilas + 1
    }

    // Aquí ponermos en el layout vacío que hemos creado en el onCreateViewHolder los datos del elemento
    override fun onBindViewHolder(holder: StringViewHolder, position: Int) {
        holder.itemBinding.textView.text = if (position % 2 == 0) {
            holder.itemBinding.textView.setBackgroundColor(ContextCompat.getColor(holder.itemBinding.root.context, R.color.colorPrimaryDark))
            "Position = $position"
        } else {
            holder.itemBinding.textView.setBackgroundColor(ContextCompat.getColor(holder.itemBinding.root.context, R.color.colorAccent))
            "Soy impar"
        }

        if (position == numeroDeFilas) {
            holder.itemBinding.textView.text = "Soy el último"
        }
    }

}

