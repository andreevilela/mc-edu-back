package com.iftm.mcedu.postagem

import com.iftm.mcedu.aluno.Aluno
import javax.validation.constraints.NotNull

data class EntregaRequest(

    @field:NotNull
    val postagem: Long,
    @field:NotNull
    val aluno: Long,
    @field:NotNull
    val arquivos: List<Arquivo>
) {
    fun toEntregaModel(postagem: Postagem, aluno: Aluno): Entrega {
        return Entrega(null, postagem = postagem, aluno = aluno, arquivos = arquivos)
    }

    fun toEntregaResponse(postagem: Postagem, aluno: Aluno): EntregaResponse {
        return EntregaResponse(postagem = postagem, aluno = aluno, arquivos = arquivos)
    }
}