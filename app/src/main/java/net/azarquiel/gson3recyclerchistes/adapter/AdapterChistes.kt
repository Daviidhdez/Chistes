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
import net.azarquiel.gson3recyclerchistes.model.Chiste


/**
 * Created by pacopulido on 9/10/18.
 */
class AdapterChistes(val context: Context,
                     val layout: Int
                    ) : RecyclerView.Adapter<AdapterChistes.ViewHolder>() {

    private var dataList: List<Chiste> = emptyList()

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

    internal fun setChistes(chistes: List<Chiste>) {
        this.dataList = chistes
        notifyDataSetChanged()
    }


    class ViewHolder(viewlayout: View, val context: Context) : RecyclerView.ViewHolder(viewlayout) {
        fun bind(dataItem: Chiste){
            // itemview es el item de diseño
            // al que hay que poner los datos del objeto dataItem
            val ivrowchiste = itemView.findViewById(R.id.ivrowchiste) as ImageView
            val tvrowcontenidochiste = itemView.findViewById(R.id.tvrowcontenidochiste) as TextView

            tvrowcontenidochiste.text = "${dataItem.contenido.substring(0,30)}..."

            val foto = "http://www.ies-azarquiel.es/paco/apichistes/img/${dataItem.idcategoria}.png"
            // foto de internet a traves de Picasso
            Picasso.get().load(foto).into(ivrowchiste)

            itemView.tag = dataItem

        }

    }
}