package net.azarquiel.gson3recyclerchistes.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.azarquiel.gson3recyclerchistes.R
import net.azarquiel.gson3recyclerchistes.model.Categoria
import net.azarquiel.gson3recyclerchistes.model.Chiste
import net.azarquiel.gson3recyclerchistes.model.Result
import net.azarquiel.recyclerviewpajaros.adapter.AdapterChistes
import java.io.Serializable
import java.net.URL

class ChistesActivity : AppCompatActivity() {
    private lateinit var adapter: AdapterChistes
    private lateinit var categoria: Categoria

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chistes)

        categoria = intent.getSerializableExtra("categoria") as Categoria

        initRV()
        getDatos()
    }

    private fun getDatos() {
        GlobalScope.launch() {
            val jsontxt = URL("http://www.ies-azarquiel.es/paco/apichistes/categoria/${categoria.id}/chistes").readText(Charsets.UTF_8)
            launch(Dispatchers.Main) {
                val result = Gson().fromJson(jsontxt, Result::class.java)
                adapter.setChistes(result.chistes)
            }
        }
    }

    private fun initRV() {
        val rvchiste = findViewById<RecyclerView>(R.id.rvchiste)
        adapter = AdapterChistes ( this, R.layout.rowchiste)
        rvchiste.adapter = adapter
        rvchiste.layoutManager = LinearLayoutManager(this)
    }

    fun onclickchiste ( v: View){
        val chiste = v.tag as Chiste

        val intent = Intent(this, ChisteDetailActivity::class.java)
        intent.putExtra("chiste", chiste)
        startActivity(intent)
    }

}