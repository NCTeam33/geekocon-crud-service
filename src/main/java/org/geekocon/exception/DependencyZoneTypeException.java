package org.geekocon.exception;

public class DependencyZoneTypeException extends RuntimeException{
    public final String message;

    public DependencyZoneTypeException(String m) {
        this.message = m;
    }
}
