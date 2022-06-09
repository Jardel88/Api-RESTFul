package br.com.erudio.exceptions

import java.util.Date

class ExceptionResponse(

    //Definindo a resposta que sera devolvida ao usuario
    val timestamp: Date,
    val message: String?,//eventualmente pode receber um valor nulo
    val details: String
)

