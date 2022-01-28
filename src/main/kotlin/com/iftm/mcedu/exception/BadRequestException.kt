package com.iftm.mcedu.exception

class BadRequestException(
    override val message: String,
    val errorCode: String
): Exception() {
}