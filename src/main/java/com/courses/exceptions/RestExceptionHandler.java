package com.courses.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.courses.enums.ExceptionEnum;

import lombok.RequiredArgsConstructor;

@RestControllerAdvice
@RequiredArgsConstructor
public class RestExceptionHandler {

    @ExceptionHandler({ BadRequestException.class })
    public final ResponseEntity<ExceptionType> handleBadRequestException(BadRequestException ex){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ExceptionType exceptionType = new ExceptionType();
        String format = "(" + ExceptionEnum.BAD_REQUEST.getMessage() + ") %s";

        exceptionType.setExceptionId(ExceptionEnum.BAD_REQUEST.getCode());
        exceptionType.setExceptionMessage(format(format, ex.getMessage()));

        BadRequestException.logError(logMessage(exceptionType));
        return new ResponseEntity<>(exceptionType, status);
    }

    @ExceptionHandler({ NotFoundException.class })
    public final ResponseEntity<ExceptionType> handleNotFoundException(NotFoundException ex){
        HttpStatus status = HttpStatus.NOT_FOUND;
        ExceptionType exceptionType = new ExceptionType();
        String format = "(" + ExceptionEnum.NOT_FOUND.getMessage() + ") %s";

        exceptionType.setExceptionId(ExceptionEnum.NOT_FOUND.getCode());
        exceptionType.setExceptionMessage(format(format, ex.getMessage()));

        NotFoundException.logError(logMessage(exceptionType));
        return new ResponseEntity<>(exceptionType, status);
    }

    private String format(String format, String Message){
        return String.format(format, Message);
    }

    private String logMessage (ExceptionType exceptionType){
        String codeFormat = "code: %s";
        String messageFormat = "message: %s";
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(format(codeFormat, exceptionType.getExceptionId()));
        sb.append(", ");
        sb.append(format(messageFormat, exceptionType.getExceptionMessage()));
        sb.append("}");
        return sb.toString();
    }

}
