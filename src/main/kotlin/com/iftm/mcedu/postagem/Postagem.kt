package com.iftm.mcedu.postagem

import com.iftm.mcedu.turma.Turma
import java.time.LocalDate
import javax.persistence.*

@Entity
class Postagem(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val titulo: String,
    @ManyToOne(cascade = arrayOf(CascadeType.PERSIST))
    val turma: Turma,
    val dataEntrega: LocalDate?,
    val descricao: String?,
    @ManyToMany(cascade = arrayOf(CascadeType.PERSIST))
    val arquivos: List<Arquivo>?
) {

    private constructor(): this(
        null,
        "",
        Turma(null, "", "", listOf(), listOf()),
        LocalDate.now(),
        "",
        listOf()
    )
}