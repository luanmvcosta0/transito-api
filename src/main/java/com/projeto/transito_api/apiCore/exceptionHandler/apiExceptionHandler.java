package com.projeto.transito_api.apiCore.exceptionHandler;

import com.projeto.transito_api.domain.exception.NegocioExeption;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class apiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NegocioExeption.class)    // Metodo capaz de capturar exeções e dar respostas adequedas
    public ResponseEntity<String> capturar(NegocioExeption e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
