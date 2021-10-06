package com.example.livros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.livros.databinding.ActivityMainBinding
import com.example.livros.model.Livro

class MainActivity : AppCompatActivity() {
    companion object Extras{
        const val EXTRA_LIVRO = "EXTRA_LIVRO"
    }
    private val activityMainBinding: ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    //DataSource
    private val livrosList: MutableList<Livro> = mutableListOf()

    //Adapter
    private val livrosAdapter: ArrayAdapter<String> by lazy{
        ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, livrosList.run{
            val livrosStringList =  mutableListOf<String>()
            this.forEach{livro -> livrosStringList.add(livro.toString())}
            livrosStringList
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // inicilizando lista de livros
        inicializarLivrosList()

        //Associar Adapter ao ListView
        activityMainBinding.LivrosLv.adapter = livrosAdapter

    }

    private fun inicializarLivrosList(){
        for(indice in 1..10){
            livrosList.add(
                Livro(
                    "Titulo ${indice}",
                    "Isbn ${indice}",
                    "Primeiro autor ${indice}",
                    "Editora ${indice}",
                    indice,
                    indice
                )
            )
        }
    }
}

//DATA SOURCE <-> ADAPTOR <-> LISTVIEW