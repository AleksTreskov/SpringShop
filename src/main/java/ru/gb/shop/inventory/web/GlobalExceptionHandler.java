package ru.gb.shop.inventory.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.gb.shop.inventory.exception.EntityNotFoundException;
import ru.gb.shop.inventory.exception.MailSenderException;
import ru.gb.shop.inventory.exception.NoContentException;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

@ExceptionHandler(EntityNotFoundException.class)
public ResponseEntity<ApiError> handlerNotFound(RuntimeException ex){
    return new ResponseEntity<>(new ApiError(ex.getMessage()), HttpStatus.NOT_FOUND);
}
@ExceptionHandler({MailSenderException.class})
    public ResponseEntity<ApiError> handleMailException(MailSenderException ex){
    return new ResponseEntity<>(new ApiError(ex.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
}
@ExceptionHandler({NoContentException.class})
    public ResponseEntity<ApiError> handleNoContent(NoContentException ex){
    return new ResponseEntity<>(new ApiError(ex.getMessage()),HttpStatus.NO_CONTENT);
}
}
