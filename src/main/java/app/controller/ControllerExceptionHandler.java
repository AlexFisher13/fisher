package app.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
class ControllerExceptionHandler {
    @ExceptionHandler(ConstraintViolationException.class)
    public String handleConflict() {
        return "error";
    }
}
