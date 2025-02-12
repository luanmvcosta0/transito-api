package com.projeto.transito_api.domain.exception;

public class NegocioExeption extends RuntimeException {

    public NegocioExeption(String message) {
        super(message);
    }
}
