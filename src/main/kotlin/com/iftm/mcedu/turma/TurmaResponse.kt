package com.iftm.mcedu.turma

import com.iftm.mcedu.usuario.Usuario

data class TurmaResponse(

    val nome: String,
    val codigo: String,
    val professores: List<Usuario>,
    val status: Boolean
) {
}