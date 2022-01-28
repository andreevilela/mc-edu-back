package com.iftm.mcedu.exception

class NotFoundException(
    override val message: String,
    val errorCode: String
): Exception() {
}