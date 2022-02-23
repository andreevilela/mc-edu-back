package com.iftm.mcedu.usuario

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("usuarios")
class UsuarioController(
    private val usuarioService: UsuarioService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun salvaUsuario(@RequestBody @Valid usuario: Usuario): Usuario {
        return usuarioService.salvaUsuario(usuario)
    }

    @GetMapping("/{id}")
    fun buscaUsuarioPeloId(@PathVariable id: String): Usuario {
        return usuarioService.buscaUsuarioPeloId(id)
    }
}