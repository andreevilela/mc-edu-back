package com.iftm.mcedu.postagem

import com.iftm.mcedu.turma.Turma
import com.iftm.mcedu.usuario.Usuario
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
    val aluno: Usuario,
    @ManyToMany(cascade = arrayOf(CascadeType.PERSIST))
    val arquivos: List<Arquivo>
) {

    private constructor(): this(
        null,
        Postagem(
            null,
            "",
            Usuario("", "", "", ""),
            Turma(null, "", "", listOf(), listOf()),
            LocalDate.now(),
            "",
            listOf()),
        Usuario("", "", "", ""),
        listOf()
    )

    constructor(postagem: Postagem, aluno: Usuario, arquivos: List<Arquivo>): this(
        null,
        Postagem(
            null,
            "",
            Usuario("", "", "", ""),
            Turma(null, "", "", listOf(), listOf()),
            LocalDate.now(),
            "",
            listOf()),
        Usuario("", "", "", ""),
        listOf()
    )
}