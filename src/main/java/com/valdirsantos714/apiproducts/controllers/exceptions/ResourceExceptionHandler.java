package com.valdirsantos714.apiproducts.controllers.exceptions;

import com.valdirsantos714.apiproducts.services.exceptions.DataBaseException;
import com.valdirsantos714.apiproducts.services.exceptions.ResourceNotFound;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice //SERVE PRA DIZER QUE É UMA CLASSE QUE CONTROLA OS ERROS
public class ResourceExceptionHandler {

    //ESSA CLASSE SERVE PARA PEGAR OS ERROS E AMOSTRAR AS MENSAGENS DE ERRO DELAS

    @ExceptionHandler(ResourceNotFound.class) // AQUI SE COLOCA O NOME DA CLASSE DE EXCEÇÃO
    public ResponseEntity<StandardError> resouceNotFound(ResourceNotFound e, HttpServletRequest request) {
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<StandardError> database (DataBaseException e, HttpServletRequest request) {
        String error = "Database error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        var err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }
}
