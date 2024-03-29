package com.iftm.mcedu.postagem

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
    fun salvaPostagem(@RequestBody @Valid postagem: PostagemRequest): PostagemResponse {
        val turma = turmaService.buscaTurmaPeloId(postagem.turma)
        val usuario = usuarioService.buscaUsuarioPeloId(postagem.usuario)
        postagemService.salvaPostagem(postagem.toPostagemModel(turma, usuario))
        return postagem.toPostagemResponse(turma)
    }

    @PostMapping("entrega")
    @ResponseStatus(HttpStatus.CREATED)
    fun entregaAtividade(@RequestBody @Valid entrega: EntregaRequest) : EntregaResponse {
        val postagem = postagemService.buscaPostagemPeloId(entrega.postagem)
        val aluno = usuarioService.buscaUsuarioPeloId(entrega.aluno)
        postagemService.salvaEntrega(entrega.toEntregaModel(postagem, aluno))
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

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun editaPostagem(@PathVariable id: Long, @RequestBody postagem: PostagemRequest) {
        val turma = turmaService.buscaTurmaPeloId(postagem.turma)
        val usuario = usuarioService.buscaUsuarioPeloId(postagem.usuario)
        postagemService.editaPostagem(postagem.toPostagemModelId(id, turma, usuario))
    }

    @PutMapping("/{id}/arquiva")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun arquivaPostagem(@PathVariable id: Long) {
        var postagem = postagemService.buscaPostagemPeloId(id)
        postagem.status = false
        postagemService.editaPostagem(postagem)
    }

    @DeleteMapping("/{id}")
    fun deletaPostagemPeloId(@PathVariable id: Long) {
        return postagemService.deletaPostagemPeloId(id)
    }

    @GetMapping("/{id}/entregas")
    fun buscaEntregasDaPostagem(@PathVariable id: Long): List<Entrega> {
        return postagemService.buscaEntregasDaPostagem(id)
    }
}