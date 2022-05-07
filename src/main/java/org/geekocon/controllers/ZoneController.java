package org.geekocon.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.geekocon.dto.Zone;
import org.geekocon.services.ZoneService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/zones")
@Produces("application/json")
public class ZoneController {

    private static final Logger logger = LogManager.getLogger(ZoneController.class);

    @Inject
    ZoneService zoneService;

    @GET
    public List<Zone> getZone(@QueryParam("type") Long type) {
        return zoneService.getZones(type);
    }

    @POST
    @RolesAllowed({"api-contributor"})
    public Zone addZone(Zone newZone){
       return zoneService.addZone(newZone);
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed({"api-contributor"})
    public Response delZone(Long id){
        return zoneService.deleteZone(id);
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed({"api-contributor"})
    public Zone updateZone(Long id, Zone newZone){
        return zoneService.updateZone(id, newZone);
    }

}