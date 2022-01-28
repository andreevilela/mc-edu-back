package com.iftm.mcedu.exception

data class ErrorResponse(
    var httpCode: Int,
    var message: String,
    val internalCode: String,
    var errors: List<FieldErrorResponse>?
) {
}