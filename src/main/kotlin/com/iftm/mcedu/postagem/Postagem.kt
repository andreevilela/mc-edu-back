package com.iftm.mcedu.postagem

import com.iftm.mcedu.turma.Turma
import java.time.LocalDate
import javax.persistence.*

@Entity
class Postagem(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val titulo: String,
    @ManyToOne
    val turma: Turma,
    val dataEntrega: LocalDate?,
    val descricao: String,
    @ManyToMany
    val arquivos: List<Arquivo>
) {
}