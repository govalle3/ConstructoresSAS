package com.ceiba.ConstructoresSAS.infraestructure.error;

import com.ceiba.ConstructoresSAS.domain.exception.ExceptionConstruction;
import com.ceiba.ConstructoresSAS.domain.exception.ExceptionCoordinates;
import com.ceiba.ConstructoresSAS.domain.exception.ExceptionMaterials;
import com.ceiba.ConstructoresSAS.domain.exception.ExceptionTypeOfConstruction;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Logger;
@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ErrorHandler.class);

    private static final String MESSAGE_ALL_ERROR = "Ha ocurrido un error";

    private static final ConcurrentHashMap<String, Integer> ERRORS = new ConcurrentHashMap<>();

    public ErrorHandler() {
        ERRORS.put(ExceptionConstruction.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        ERRORS.put(ExceptionCoordinates.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        ERRORS.put(ExceptionMaterials.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        ERRORS.put(ExceptionTypeOfConstruction.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Error> handleAllExceptions(Exception exception) {
        ResponseEntity<Error> response;
        String exceptionName = exception.getClass().getSimpleName();
        String message = exception.getMessage();

        Integer code = ERRORS.get(exceptionName);

        if (code == null) {
            LOG.error(exceptionName, message);
            Error error = new Error(exceptionName, MESSAGE_ALL_ERROR);
            response = new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            Error error = new Error(exceptionName, message);
            response = new ResponseEntity<>(error, HttpStatus.valueOf(code));
        }

        return response;
    }
}
