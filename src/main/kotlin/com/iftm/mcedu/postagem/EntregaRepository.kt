package com.iftm.mcedu.postagem

import org.springframework.data.jpa.repository.JpaRepository

interface EntregaRepository: JpaRepository<Entrega, Long> {
}