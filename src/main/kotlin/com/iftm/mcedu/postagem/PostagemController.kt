package com.iftm.mcedu.postagem

import com.iftm.mcedu.aluno.AlunoService
import com.iftm.mcedu.turma.TurmaService
import com.iftm.mcedu.usuario.UsuarioService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("postagens")
class PostagemController(
    private val postagemService: PostagemService,
    private val turmaService: TurmaService,
    private val usuarioService: UsuarioService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun salvarPostagem(@RequestBody @Valid postagem: PostagemRequest): PostagemResponse {
        val turma = turmaService.buscaTurmaPeloId(postagem.turma)
        val usuario = usuarioService.buscaUsuarioPeloId(postagem.usuario)
        postagemService.salvarPostagem(postagem.toPostagemModel(turma, usuario))
        return postagem.toPostagemResponse(turma)
    }

    @PostMapping("entrega")
    @ResponseStatus(HttpStatus.CREATED)
    fun entregarAtividade(@RequestBody @Valid entrega: EntregaRequest) : EntregaResponse {
        val postagem = postagemService.buscaPostagemPeloId(entrega.postagem)
        val aluno = usuarioService.buscaUsuarioPeloId(entrega.aluno)
        postagemService.salvarEntrega(entrega.toEntregaModel(postagem, aluno))
        return entrega.toEntregaResponse(postagem, aluno)
    }

    @GetMapping("turma/{id}")
    fun buscaPostagensDaTurma(@PathVariable id: Long): List<Postagem> {
        return postagemService.buscaPostagensDaTurma(id)
    }

    @GetMapping("/{id}")
    fun buscaPostagemPeloId(@PathVariable id: Long): Postagem {
        return postagemService.buscaPostagemPeloId(id)
    }
}