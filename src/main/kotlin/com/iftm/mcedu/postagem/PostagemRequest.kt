package com.iftm.mcedu.postagem

import com.iftm.mcedu.turma.Turma
import java.time.LocalDate
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class PostagemRequest(

    @field:NotEmpty
    val titulo: String,
    @field:NotNull
    val turma: Long,
    val dataEntrega: LocalDate?,
    val descricao: String?,
    val arquivos: List<Arquivo>?
) {
    fun toPostagemModel(turma: Turma): Postagem {
        return Postagem(id = null, titulo = this.titulo, turma = turma, dataEntrega = this.dataEntrega, descricao = this.descricao, arquivos = arquivos)
    }

    fun toPostagemResponse(turma: Turma): PostagemResponse {
        return PostagemResponse(titulo = this.titulo, turma = turma, dataEntrega = this.dataEntrega, descricao = this.descricao, arquivos = arquivos)
    }

}
