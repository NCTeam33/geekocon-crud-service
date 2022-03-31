package org.geekocon.exception;

public class UnknownTypeException extends RuntimeException{
    public final String message;

    public UnknownTypeException(String e) {
        this.message = e;
    }
}
