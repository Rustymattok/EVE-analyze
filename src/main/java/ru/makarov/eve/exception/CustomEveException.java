package ru.makarov.eve.exception;

import org.springframework.web.client.HttpStatusCodeException;

public class CustomEveException extends RuntimeException{

    public CustomEveException() {
    }

    public CustomEveException(String message) {
        super(message);
    }

    public CustomEveException(HttpStatusCodeException e){
        super(e);
    }

}
