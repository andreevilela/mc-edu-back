package com.iftm.mcedu.postagem

import com.iftm.mcedu.aluno.AlunoService
import com.iftm.mcedu.turma.TurmaService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("postagem")
class PostagemController(
    private val postagemService: PostagemService,
    private val turmaService: TurmaService,
    private val alunoService: AlunoService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun salvarPostagem(@RequestBody @Valid postagem: PostagemRequest): PostagemResponse {
        val turma = turmaService.buscaTurmaPeloId(postagem.turma)
        postagemService.salvarPostagem(postagem.toPostagemModel(turma))
        return postagem.toPostagemResponse(turma)
    }

    @PostMapping("entrega")
    @ResponseStatus(HttpStatus.CREATED)
    fun entregarAtividade(@RequestBody @Valid entrega: EntregaRequest) : EntregaResponse {
        val postagem = postagemService.buscaPostagemPeloId(entrega.postagem)
        val aluno = alunoService.buscaAlunoPeloId(entrega.aluno)
        postagemService.salvarEntrega(entrega.toEntregaModel(postagem, aluno))
        return entrega.toEntregaResponse(postagem, aluno)
    }
}