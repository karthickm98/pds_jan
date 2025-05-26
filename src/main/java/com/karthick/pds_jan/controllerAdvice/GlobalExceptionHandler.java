package com.karthick.pds_jan.controllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.karthick.pds_jan.exceptions.ProductNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> handleArithmeticException(ArithmeticException ex){
        ResponseEntity<String> res = new ResponseEntity<>(
            "Arithmetic Exception Occured",
            HttpStatus.INTERNAL_SERVER_ERROR
        );
        return res;
    }
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<String> handleArrayIndexOutOfBoundsException(ArrayIndexOutOfBoundsException ex){
        ResponseEntity<String> res = new ResponseEntity<>(
            "Array Index Out Of Bounds Exception Occured",
            HttpStatus.INTERNAL_SERVER_ERROR
        );
        return res;
    };

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException ex){
        ResponseEntity<String> res = new ResponseEntity<>(
            ex.getMessage(),
            HttpStatus.NOT_FOUND
        );
        return res;
    }
}
