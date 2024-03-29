package com.iftm.mcedu.postagem

import org.springframework.stereotype.Service

@Service
class PostagemService(
    private val postagemRepository: PostagemRepository,
    private val entregaRepository: EntregaRepository
) {

    fun salvaPostagem(postagem: Postagem) {
        postagemRepository.save(postagem)
    }

    fun buscaPostagemPeloId(id: Long): Postagem {
        return postagemRepository.getById(id)
    }

    fun salvaEntrega(entrega: Entrega) {
        entregaRepository.save(entrega)
    }

    fun buscaPostagensDaTurma(id: Long): List<Postagem> {
        return postagemRepository.getPostagemByTurmaIdAndStatusOrderByIdDesc(id, true)
    }

    fun editaPostagem(postagem: Postagem) {
        postagemRepository.save(postagem)
    }

    fun deletaPostagemPeloId(id: Long) {
        postagemRepository.deleteById(id)
    }

    fun buscaEntregasDaPostagem(id: Long): List<Entrega> {
        return entregaRepository.getEntregaByPostagemId(id)
    }
}