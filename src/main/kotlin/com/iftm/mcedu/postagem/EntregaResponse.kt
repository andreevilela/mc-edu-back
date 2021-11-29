package com.iftm.mcedu.postagem

import com.iftm.mcedu.aluno.Aluno

data class EntregaResponse(

    val postagem: Postagem,
    val aluno: Aluno,
    val arquivos: List<Arquivo>
) {
}