package org.geekocon.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.geekocon.dto.Zone;
import org.geekocon.services.ZoneService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/v1/zones")
@Produces("application/json")
public class ZoneController {

    private static final Logger logger = LogManager.getLogger(ZoneController.class);

    @Inject
    ZoneService zoneService;

    @GET
    public List<Zone> getZone() {
        return zoneService.getZones();
    }

    @POST
    public Zone addZone(Zone newZone){
        logger.debug("addZone invocation with: {}", newZone);
        zoneService.getZones().add(newZone);
        return newZone;
    }

}