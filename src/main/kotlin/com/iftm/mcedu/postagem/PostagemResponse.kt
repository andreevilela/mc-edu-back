package com.iftm.mcedu.postagem

import com.iftm.mcedu.turma.Turma
import java.time.LocalDate

data class PostagemResponse(

    val titulo: String,
    val turma: Turma,
    val dataEntrega: LocalDate?,
    val descricao: String?,
    val arquivos: List<Arquivo>?
) {

}
