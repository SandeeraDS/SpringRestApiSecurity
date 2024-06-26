package org.ds.spring_security_1.utils;

import org.ds.spring_security_1.Exception.EmployeeClientException;
import org.ds.spring_security_1.Exception.EmployeeServerException;
import org.ds.spring_security_1.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionResponseHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorResponseDTO> handleException(EmployeeServerException e){
        ErrorResponseDTO errorResponseDTO  = new ErrorResponseDTO();
        errorResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponseDTO.setMessage(e.getMessage());
        errorResponseDTO.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponseDTO> handleException(EmployeeClientException e){
        ErrorResponseDTO errorResponseDTO  = new ErrorResponseDTO();
        errorResponseDTO.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponseDTO.setMessage(e.getMessage());
        errorResponseDTO.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponseDTO,HttpStatus.NOT_FOUND);
    }
}
