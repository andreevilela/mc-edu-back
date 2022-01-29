package com.iftm.mcedu.postagem

import com.iftm.mcedu.usuario.Usuario

data class EntregaResponse(

    val postagem: Postagem,
    val aluno: Usuario,
    val arquivos: List<Arquivo>
) {
}