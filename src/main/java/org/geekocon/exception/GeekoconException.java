package org.geekocon.exception;

import javax.ws.rs.core.Response;

public class GeekoconException extends RuntimeException{
    public Response.Status response = Response.Status.INTERNAL_SERVER_ERROR;

    public GeekoconException(String message){
        super(message);
    }
}