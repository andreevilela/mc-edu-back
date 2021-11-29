package com.iftm.mcedu.postagem

import javax.persistence.*

@Entity
class Arquivo(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val url: String
) {

}
