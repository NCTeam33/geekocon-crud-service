package org.geekocon.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.geekocon.dto.Zone;
import org.geekocon.services.ZoneService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.persistence.Entity;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.Response.Status.OK;

@Path("/zones")
@Produces("application/json")
public class ZoneController {

    private static final Logger logger = LogManager.getLogger(ZoneController.class);

    @Inject
    ZoneService zoneService;

    @GET
    public List<Zone> getZone() {
        return zoneService.getZones();
    }

    //@RolesAllowed({"api-manager"})
    @POST
    public Zone addZone(Zone newZone){
        logger.debug("addZone invocation with: {}", newZone);
        zoneService.addZone(newZone);
        return newZone;
    }

    @DELETE
    public Response delZone(String name){
        zoneService.deleteZone(name);
        return Response.status(OK).build();
    }

}