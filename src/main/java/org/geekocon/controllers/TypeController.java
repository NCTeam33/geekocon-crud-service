package org.geekocon.controllers;

import org.geekocon.dto.ZoneType;
import org.geekocon.services.TypeService;


import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;


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
    @RolesAllowed({"api-contributor"})
    public ZoneType addType(ZoneType newType){
        return typeService.addType(newType);
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed({"api-contributor"})
    public Response deleteType(Long id){
        return typeService.deleteType(id);
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed({"api-contributor"})
    public ZoneType updateType(Long id, ZoneType name){
        return typeService.updateType(id, name);
    }
}
