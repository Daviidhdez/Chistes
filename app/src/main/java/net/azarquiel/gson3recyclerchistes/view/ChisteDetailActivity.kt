package net.azarquiel.gson3recyclerchistes.view

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import net.azarquiel.gson3recyclerchistes.R
import net.azarquiel.gson3recyclerchistes.model.Chiste

class ChisteDetailActivity : AppCompatActivity() {
    private lateinit var chiste: Chiste

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chiste_detail)

         chiste = intent.getSerializableExtra("chiste") as Chiste
        showChiste()
    }

    private fun showChiste() {
        val ivdetail = findViewById<ImageView>(R.id.ivdetail)
        val tvcontenidodetail = findViewById<TextView>(R.id.tvcontenidodetail)
        val contenido = Html.fromHtml(chiste.contenido)
        tvcontenidodetail.text = contenido

        val foto = "http://www.ies-azarquiel.es/paco/apichistes/img/${chiste.idcategoria}.png"
        // foto de internet a traves de Picasso
        Picasso.get().load(foto).into(ivdetail)
    }
}