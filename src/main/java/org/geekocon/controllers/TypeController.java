package org.geekocon.controllers;

import org.geekocon.dto.ZoneType;
import org.geekocon.exception.DependencyZoneTypeException;
import org.geekocon.services.TypeService;
import org.jboss.resteasy.reactive.RestResponse;


import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

import static javax.ws.rs.core.Response.Status.OK;

@Path("/zones/types")
@Produces("application/json")
public class TypeController {

    @Inject
    TypeService typeService;

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
    public RestResponse deleteType(Long id){
        typeService.deleteType(id);
        return RestResponse.status(OK);

    }
}
