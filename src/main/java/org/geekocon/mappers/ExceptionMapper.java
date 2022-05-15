package org.geekocon.mappers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.geekocon.dto.GeekoconMessage;
import org.geekocon.exception.GeekoconException;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

import javax.ws.rs.core.Response;

public class ExceptionMapper {
    private static final Logger logger = LogManager.getLogger(ExceptionMapper.class);

    @ServerExceptionMapper
    public GeekoconMessage mapException(GeekoconException x) {
        logger.error(x);
        return new GeekoconMessage(x.response, x.getMessage());
    }

    @ServerExceptionMapper
    public GeekoconMessage mapException(Throwable x) {
        logger.error(x);
        return new GeekoconMessage(Response.Status.BAD_REQUEST, x.getMessage());
    }
}