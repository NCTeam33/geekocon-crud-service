package org.geekocon.controllers;

import org.geekocon.dto.ZoneType;
import org.geekocon.exception.DependencyZoneTypeException;
import org.geekocon.services.TypeService;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.Response.Status.OK;

@Path("/types")
@Produces("application/json")
public class TypeController {

    @Inject
    TypeService typeService;
    @ServerExceptionMapper
    public RestResponse<String> mapException(DependencyZoneTypeException x) {
        return RestResponse.status(Response.Status.CONFLICT, "Was found zone with this type: " + x.zoneName);
    }

    @GET
    public List<ZoneType> getAll() {
        return typeService.getTypes();
    }

    @POST
    public ZoneType addType(ZoneType newType){
        return typeService.addType(newType);
    }

    @DELETE
    @Path("/{id}")
    public RestResponse<String> deleteType(Long id){
        try {
            typeService.deleteType(id);
            return RestResponse.status(OK);
        }catch (DependencyZoneTypeException e){
            return mapException(e);
        }
    }
}
