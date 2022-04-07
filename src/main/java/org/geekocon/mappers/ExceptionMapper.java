package org.geekocon.mappers;

import org.geekocon.exception.DependencyZoneTypeException;
import org.geekocon.exception.UnknownTypeException;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

import javax.ws.rs.core.Response;

public class ExceptionMapper {
    @ServerExceptionMapper
    public RestResponse<String> mapException(DependencyZoneTypeException x) {
        return RestResponse.status(Response.Status.CONFLICT, "Was found zone with this type: " + x.message);
    }

    @ServerExceptionMapper
    public RestResponse<String> mapException(UnknownTypeException x) {
        return RestResponse.status(Response.Status.NOT_FOUND, "Message: " + x.message);
    }
}
