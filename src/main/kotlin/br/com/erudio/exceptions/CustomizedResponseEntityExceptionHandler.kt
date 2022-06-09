package br.com.erudio.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*
import java.lang.*

/*
*  @ControllerAdvice é usado sempre que precisamos concentrar algum tratamento
*  que seria espalhadoem diversos controllers, se ocorrer uma excecao e ninguem fornecer um tratamento adequado,
* vai entrar no tratamento global do ControllerAdvice
* filtros de autenticacao podem nao funcionar em versoes anteriores ao spring 3
*/
@ControllerAdvice
@RestController
class CustomizedResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(Exception::class)
    fun handleAllException(ex: Exception, request: WebRequest):
            ResponseEntity<ExceptionResponse>{
        val exceptionResponse = ExceptionResponse(
            Date(),
            ex.message,
            request.getDescription(false)
        )
        return ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }
    @ExceptionHandler(UnsuppertedMathOperationException::class)
    fun handleBadRequestException(ex: Exception, request: WebRequest):
            ResponseEntity<ExceptionResponse>{
        val exceptionResponse = ExceptionResponse(
            Date(),
            ex.message,
            request.getDescription(false)
        )
        return ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST)
    }
}