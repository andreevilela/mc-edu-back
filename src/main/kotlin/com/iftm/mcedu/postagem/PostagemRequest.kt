package com.iftm.mcedu.postagem

import com.iftm.mcedu.turma.Turma
import com.iftm.mcedu.usuario.Usuario
import java.time.LocalDate
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class PostagemRequest(

    @field:NotEmpty
    val titulo: String,
    @field:NotEmpty
    val usuario: String,
    @field:NotNull
    val turma: Long,
    val dataEntrega: LocalDate?,
    val descricao: String?,
    val arquivos: List<Arquivo>?
) {
    fun toPostagemModel(turma: Turma, usuario: Usuario): Postagem {
        return Postagem(id = null, titulo = this.titulo, usuario = usuario, turma = turma, dataEntrega = this.dataEntrega, descricao = this.descricao, arquivos = arquivos)
    }

    fun toPostagemResponse(turma: Turma): PostagemResponse {
        return PostagemResponse(titulo = this.titulo, turma = turma, dataEntrega = this.dataEntrega, descricao = this.descricao, arquivos = arquivos)
    }

}
