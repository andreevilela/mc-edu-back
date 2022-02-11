package com.iftm.mcedu.postagem

import org.springframework.data.jpa.repository.JpaRepository

interface PostagemRepository: JpaRepository<Postagem, Long> {

    fun getPostagemByTurmaIdOrderByIdDesc(id: Long): List<Postagem>
}