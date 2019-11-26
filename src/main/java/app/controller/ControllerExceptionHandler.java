package app.controller;

import javassist.bytecode.DuplicateMemberException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
class ControllerExceptionHandler {
    @ExceptionHandler(ConstraintViolationException.class)
    public String handleValidation() {
        return "validation-error";
    }
    @ExceptionHandler(DuplicateMemberException.class)
    public String handleDuplicat() {
        return "duplicate-error";
    }
}
