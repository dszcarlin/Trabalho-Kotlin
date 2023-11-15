package br.com.alura.orgs.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.R
import br.com.alura.orgs.model.Tarefa

class ListaTarefasAdapter(
        private val context: Context,
        tarefas: List<Tarefa>
) : RecyclerView.Adapter<ListaTarefasAdapter.ViewHolder>() {

    private val tarefas = tarefas.toMutableList()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun vincula(tarefa: Tarefa) {
            val nome = itemView.findViewById<TextView>(R.id.tarefa_item_nome)
            nome.text = tarefa.nome
            val descricao = itemView.findViewById<TextView>(R.id.tarefa_item_descricao)
            descricao.text = tarefa.descricao
            val valor = itemView.findViewById<TextView>(R.id.tarefa_item_valor)
            valor.text = tarefa.data.toPlainString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.tarefa_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tarefa = tarefas[position]
        holder.vincula(tarefa)
    }

    override fun getItemCount(): Int = tarefas.size

    fun atualiza(tarefas: List<Tarefa>) {
        this.tarefas.clear()
        this.tarefas.addAll(tarefas)
        notifyDataSetChanged()
    }

}
