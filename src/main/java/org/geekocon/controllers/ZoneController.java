package org.geekocon.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.geekocon.dto.Zone;
import org.geekocon.exception.UnknownTypeException;
import org.geekocon.services.ZoneService;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.Response.Status.OK;

@Path("/zones")
@Produces("application/json")
public class ZoneController {

//    private static final Logger logger = LogManager.getLogger(ZoneController.class);

    @Inject
    ZoneService zoneService;

    @GET
    public List<Zone> getZone(@QueryParam("type") Long type) {
        return zoneService.getZones(type);
    }

    //@RolesAllowed({"api-manager"})
    @POST
    public Zone addZone(Zone newZone){
       return zoneService.addZone(newZone);
    }

    @DELETE
    @Path("/{id}")
    public Response delZone(Long id){
        zoneService.deleteZone(id);
        return Response.status(OK).build();
    }

}