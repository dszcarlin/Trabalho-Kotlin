package br.com.alura.orgs.dao

import br.com.alura.orgs.model.Tarefa


class TarefasDao {

    fun adiciona(tarefa: Tarefa){
        tarefas.add(tarefa)
    }

    fun buscaTodos() : List<Tarefa> {
        return tarefas.toList()
    }

    companion object {
        private val tarefas = mutableListOf<Tarefa>()
    }

}