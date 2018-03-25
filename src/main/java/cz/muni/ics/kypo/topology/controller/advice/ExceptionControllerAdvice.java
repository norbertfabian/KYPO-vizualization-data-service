package cz.muni.ics.kypo.topology.controller.advice;

import cz.muni.ics.kypo.idm.service.interfaces.IdentityManagementException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Controller advice for handling exceptions.
 *
 * Created by norbert on 2.10.17.
 */
@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(IdentityManagementException.class)
    public ResponseEntity<String> idmExceptionHandler(IdentityManagementException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CannotCreateTransactionException.class)
    public ResponseEntity<String> transactionExceptionHandler(CannotCreateTransactionException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
