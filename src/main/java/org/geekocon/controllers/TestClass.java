package org.geekocon.controllers;

import org.geekocon.dto.Zone;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/zones/test")
@Produces("application/json")
public class TestClass {
    @GET
    public Response getZones() {
        ArrayList<Zone> zones = new ArrayList<>();

        Zone zone1  = new Zone();
        zone1.setTotalTicketsAmount(51);
        zone1.setAvailableTicketsAmount(20);
        zone1.setName("Zone1");
        zone1.setDescription("the Best Zone");
        zones.add(zone1);

        Zone zone2  = new Zone();
        zone2.setTotalTicketsAmount(61);
        zone2.setAvailableTicketsAmount(25);
        zone2.setName("Zone2");
        zone2.setDescription("the Best Zone");
        zones.add(zone2);

        Zone zone3  = new Zone();
        zone3.setTotalTicketsAmount(24);
        zone3.setAvailableTicketsAmount(22);
        zone3.setName("Zone3");
        zone3.setDescription("the Best Zone");
        zones.add(zone3);

        return Response.ok(zones).build();
    }
}
