package org.geekocon.controllers;

import org.geekocon.dto.ZoneType;
import org.geekocon.services.TypeService;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path("/types")
@Produces("application/json")
public class TypeController {

    @Inject
    TypeService TypeService;

    @GET
    public void getAll() {
        TypeService.getTypes();
    }

    @POST
    public void addType(ZoneType newType){
        TypeService.addType(newType);
    }

    @DELETE
    public void deleteType(List<Long> id){
        TypeService.deleteType(id);
    }
}
