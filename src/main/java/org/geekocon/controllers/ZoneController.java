package org.geekocon.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.geekocon.dto.Zone;
import org.geekocon.services.ZoneService;

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

    //@RolesAllowed({"api-manager"})
    @POST
    public Zone addZone(Zone newZone){
       return zoneService.addZone(newZone);
    }

    @DELETE
    @Path("/{id}")
    public Response delZone(Long id){
        return zoneService.deleteZone(id);
    }

}