package org.geekocon.controllers;

import org.geekocon.dto.Zone;
import org.geekocon.services.ZoneService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/v1/zones")
@Produces("application/json")
public class ZoneController {

    @Inject
    ZoneService zoneService;

    @GET
    public List<Zone> getZone() {
        return zoneService.getZones();
    }
}