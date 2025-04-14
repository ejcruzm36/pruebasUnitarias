package com.courses.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException{

    private final static Logger logger = LoggerFactory.getLogger(NotFoundException.class);
    private final static long serialVersionUID = 1L;
    private String message;

    public NotFoundException(String message) {
        super(message);
        this.message = message;
    }

    public static void logError(String message) {
        logger.error("NotFoundException: {}", message);
    }

}
