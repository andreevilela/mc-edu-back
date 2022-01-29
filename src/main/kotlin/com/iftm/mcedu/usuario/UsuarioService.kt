package com.iftm.mcedu.usuario

import org.springframework.stereotype.Service

@Service
class UsuarioService(
    private val usuarioRepository: UsuarioRepository
) {

    fun salvarUsuario(usuario: Usuario): Usuario {
        return usuarioRepository.save(usuario)
    }

    fun buscaUsuarioPeloId(id: String): Usuario {
        return usuarioRepository.getById(id)
    }
}