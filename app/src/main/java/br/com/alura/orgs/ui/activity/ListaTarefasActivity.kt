package br.com.alura.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.R
import br.com.alura.orgs.dao.TarefasDao
import br.com.alura.orgs.ui.recyclerview.adapter.ListaTarefasAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaTarefasActivity : AppCompatActivity(R.layout.activity_lista_tarefas_activity) {

    private val dao = TarefasDao()
    private val adapter = ListaTarefasAdapter(context = this, tarefas = dao.buscaTodos())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuraRecyclerView()
        configuraFab()
    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.buscaTodos())
    }

    private fun configuraFab() {
        val fab = findViewById<FloatingActionButton>(R.id.activity_lista_tarefas_fab)
        fab.setOnClickListener {
            vaiParaFormularioTarefa()
        }
    }

     private fun vaiParaFormularioTarefa() {
        val intent = Intent(this, FormularioTarefaActivity::class.java)
        startActivity(intent)
    }

    private fun configuraRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.activity_lista_tarefas_recyclerView)
        recyclerView.adapter = adapter
    }

}