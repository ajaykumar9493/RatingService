package com.learn.rating.service.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalException {

    static class ErrorResponse{
        private String reson;
        private String message;
        public ErrorResponse(String reson, String message) {
            this.reson = reson;
            this.message = message;
        }
    }

    @ExceptionHandler({NotFoundException.class, RuntimeException.class})
    public ErrorResponse handleDataNotFoundException(Throwable ex){
        System.out.println(">>> Global Exception - DataNotFoundException -- :::");
        return new ErrorResponse(HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleUnkownExceptions(Exception ex){
        System.out.println(">>> Global Exception - Main_Exception Occured :::");
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), ex.getMessage());
    }



}
