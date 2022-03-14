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
    public Response deleteType(@PathParam("id")Long id){
        typeService.deleteType(id);
        return Response.status(OK).build();
    }
}
