package com.iftm.mcedu.postagem

import com.iftm.mcedu.aluno.Aluno
import com.iftm.mcedu.usuario.Usuario
import javax.validation.constraints.NotNull

data class EntregaRequest(

    @field:NotNull
    val postagem: Long,
    @field:NotNull
    val aluno: String,
    @field:NotNull
    val arquivos: List<Arquivo>
) {
    fun toEntregaModel(postagem: Postagem, aluno: Usuario): Entrega {
        return Entrega(null, postagem = postagem, aluno = aluno, arquivos = arquivos)
    }

    fun toEntregaResponse(postagem: Postagem, aluno: Usuario): EntregaResponse {
        return EntregaResponse(postagem = postagem, aluno = aluno, arquivos = arquivos)
    }
}