package com.iftm.mcedu.postagem

import com.iftm.mcedu.aluno.Aluno
import javax.persistence.*

@Entity
class Entrega(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @ManyToOne
    val postagem: Postagem,
    @ManyToOne
    val aluno: Aluno,
    @ManyToMany
    val arquivos: List<Arquivo>
) {
}