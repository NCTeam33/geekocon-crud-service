package org.geekocon.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.ws.rs.core.Response;
@Setter
@Getter
@ToString
public class GeekoconMessage {

    private Response.Status response;
    private String message;

    public GeekoconMessage(Response.Status status, String message){
        this.message = message;
        this.response = status;
    }
}