package com.courses.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Getter;

@Getter
public class BadRequestException extends RuntimeException{

    private final static Logger logger = LoggerFactory.getLogger(BadRequestException.class);
    private final static long serialVersionUID = 1L;
    private final String message;

    public BadRequestException(String message) {
        super(message);
        this.message = message;
    }

    public static void logError(String message) {
        logger.error("BadRequestException: {}", message);
    }

}
