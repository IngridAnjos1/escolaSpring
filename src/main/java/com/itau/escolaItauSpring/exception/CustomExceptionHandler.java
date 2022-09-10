package com.itau.escolaItauSpring.exception;

import com.itau.escolaItauSpring.dto.exception.CustomException;
import feign.FeignException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;


@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {DataIntegrityViolationException.class})
    protected ResponseEntity<Object> handleConstraintViolationException(
            RuntimeException ex, WebRequest request) {
        CustomException exceptionDetail = new CustomException(List.of("Problema ao inserir registro"), HttpStatus.CONFLICT.value());
        return handleExceptionInternal(ex, exceptionDetail,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(value = {ItemNaoExistenteException.class})
    protected ResponseEntity<Object> handleItemNotFound(RuntimeException ex, WebRequest request) {
        CustomException exceptionDetail = new CustomException(List.of("Elemento não encontrado"), HttpStatus.NOT_FOUND.value());
        return handleExceptionInternal(ex, exceptionDetail,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
    @ExceptionHandler(value = {FeignException.BadRequest.class})
    protected ResponseEntity<Object> handleFeignException(FeignException ex, WebRequest request) {
        CustomException exceptionDetail = new CustomException(List.of("Verifique seu CEP"), HttpStatus.BAD_REQUEST.value());
        return handleExceptionInternal(ex, exceptionDetail,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);

    }
}
