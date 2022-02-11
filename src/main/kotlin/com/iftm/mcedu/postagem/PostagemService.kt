package com.iftm.mcedu.postagem

import org.springframework.stereotype.Service

@Service
class PostagemService(
    private val postagemRepository: PostagemRepository,
    private val entregaRepository: EntregaRepository
) {

    fun salvarPostagem(postagem: Postagem) {
        postagemRepository.save(postagem)
    }

    fun buscaPostagemPeloId(id: Long): Postagem {
        return postagemRepository.getById(id)
    }

    fun salvarEntrega(entrega: Entrega) {
        entregaRepository.save(entrega)
    }

    fun buscaPostagensDaTurma(id: Long): List<Postagem> {
        return postagemRepository.getPostagemByTurmaIdOrderByIdDesc(id)
    }
}