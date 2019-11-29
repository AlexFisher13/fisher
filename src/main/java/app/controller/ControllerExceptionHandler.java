package app.controller;

import javassist.bytecode.DuplicateMemberException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
class ControllerExceptionHandler {
    @ExceptionHandler(ConstraintViolationException.class)
    public String handleValidation(ConstraintViolationException e) {

        switch (e.getMessage()) {
            case "addCard.number: должно соответствовать шаблону \"\\d{16}\"":
                return "error-card";
            case "addClient.firstname: размер должен быть между 3 и 15":
                return "error-client";
        }
        return "error-default";
    }

    @ExceptionHandler(DuplicateMemberException.class)
    public String handleDuplicat() {
        return "error-duplicate";
    }
}
