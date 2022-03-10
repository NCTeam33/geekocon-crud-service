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
    public void getZone() {
        zoneService.getZones();
    }

    //@RolesAllowed({"api-manager"})
    @POST
    public void addZone(Zone newZone){
        logger.debug("addZone invocation with: {}", newZone);
        zoneService.addZone(newZone);
    }

    @DELETE
    public void delZone(List<Long> id){
        zoneService.deleteZone(id);
    }

}