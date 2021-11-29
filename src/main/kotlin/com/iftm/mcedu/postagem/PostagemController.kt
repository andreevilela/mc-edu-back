package com.iftm.mcedu.postagem

import com.iftm.mcedu.turma.TurmaService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("postagem")
class PostagemController(
    private val postagemService: PostagemService,
    private val turmaService: TurmaService
) {

    @PostMapping
    fun salvarPostagem(@RequestBody @Valid postagem: PostagemRequest): PostagemResponse {
        val turma = turmaService.buscaTurmaPeloId(postagem.turma)
        val arquivos = postagem.arquivos
        postagemService.salvarPostagem(postagem.toPostagemModel(turma))
        return postagem.toPostagemResponse(turma)
    }
}