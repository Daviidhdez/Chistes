package net.azarquiel.recyclerviewpajaros.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import net.azarquiel.gson3recyclerchistes.R
import net.azarquiel.gson3recyclerchistes.model.Categoria


/**
 * Created by pacopulido on 9/10/18.
 */
class AdapterCat(val context: Context,
                 val layout: Int
                    ) : RecyclerView.Adapter<AdapterCat.ViewHolder>() {

    private var dataList: List<Categoria> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val viewlayout = layoutInflater.inflate(layout, parent, false)
        return ViewHolder(viewlayout, context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    internal fun setCategorias(categorias: List<Categoria>) {
        this.dataList = categorias
        notifyDataSetChanged()
    }


    class ViewHolder(viewlayout: View, val context: Context) : RecyclerView.ViewHolder(viewlayout) {
        fun bind(dataItem: Categoria){
            // itemview es el item de diseño
            // al que hay que poner los datos del objeto dataItem
            val ivrowcat = itemView.findViewById(R.id.ivrowcat) as ImageView
            val tvrowcat = itemView.findViewById(R.id.tvrowcat) as TextView

            tvrowcat.text = dataItem.nombre

            val foto = "http://www.ies-azarquiel.es/paco/apichistes/img/${dataItem.id}.png"
            // foto de internet a traves de Picasso
            Picasso.get().load(foto).into(ivrowcat)

            itemView.tag = dataItem

        }

    }
}