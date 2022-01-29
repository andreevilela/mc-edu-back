package com.iftm.mcedu.usuario

import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository: JpaRepository<Usuario, String> {
}