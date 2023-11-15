package br.com.alura.orgs.ui.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.orgs.R
import br.com.alura.orgs.dao.TarefasDao
import br.com.alura.orgs.model.Tarefa
import java.math.BigDecimal

class FormularioTarefaActivity :
    AppCompatActivity(R.layout.activity_formulario_tarefa) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuraBotaoSalvar()
    }

    private fun configuraBotaoSalvar() {
        val botaoSalvar = findViewById<Button>(R.id.activity_formulario_tarefa_botao_salvar)
        val dao = TarefasDao()
        botaoSalvar.setOnClickListener {
            val tarefaNovo = criaTarefa()
            dao.adiciona(tarefaNovo)
            finish()
        }
    }

    private fun criaTarefa(): Tarefa {
        val campoNome = findViewById<EditText>(R.id.activity_formulario_tarefa_nome)
        val nome = campoNome.text.toString()
        val campoDescricao = findViewById<EditText>(R.id.activity_formulario_tarefa_descricao)
        val descricao = campoDescricao.text.toString()
        val campoValor = findViewById<EditText>(R.id.activity_formulario_tarefa_data)
        val valorEmTexto = campoValor.text.toString()
        val data = if (valorEmTexto.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valorEmTexto)
        }

        return Tarefa(
                nome = nome,
                descricao = descricao,
                data = data
        )
    }

}