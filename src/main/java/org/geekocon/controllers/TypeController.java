package org.geekocon.controllers;

import org.geekocon.dto.ZoneType;
import org.geekocon.services.TypeService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.Response.Status.OK;

@Path("/types")
@Produces("application/json")
public class TypeController {

    @Inject
    TypeService TypeService;

    @GET
    public List<ZoneType> getAll() {
        return TypeService.getTypes();
    }

    @POST
    public ZoneType addType(ZoneType newType){
        TypeService.addType(newType);
        return newType;
    }

    @DELETE
    public Response deleteType(String name){
        TypeService.deleteType(name);
        return Response.status(OK).build();
    }
}
