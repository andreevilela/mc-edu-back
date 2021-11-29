package com.iftm.mcedu.postagem

import com.iftm.mcedu.aluno.Aluno
import com.iftm.mcedu.turma.Turma
import java.time.LocalDate
import javax.persistence.*

@Entity
class Entrega(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    @ManyToOne(cascade = arrayOf(CascadeType.PERSIST))
    val postagem: Postagem,
    @ManyToOne(cascade = arrayOf(CascadeType.PERSIST))
    val aluno: Aluno,
    @ManyToMany(cascade = arrayOf(CascadeType.PERSIST))
    val arquivos: List<Arquivo>?
) {

    constructor(postagem: Postagem, aluno: Aluno, arquivos: List<Arquivo>): this(
        null,
        Postagem(
            null,
            "",
            Turma(null, "", "", listOf(), listOf()),
            LocalDate.now(),
            "",
            listOf()),
        Aluno(null, "", "", ""),
        listOf(Arquivo(null, ""))
    )
}