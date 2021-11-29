package com.iftm.mcedu.postagem

import org.springframework.stereotype.Service

@Service
class PostagemService(
    private val postagemRepository: PostagemRepository
) {

    fun salvarPostagem(postagem: Postagem) {
        postagemRepository.save(postagem)
    }
}