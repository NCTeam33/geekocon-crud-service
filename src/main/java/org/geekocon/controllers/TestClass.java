package org.geekocon.controllers;

import org.geekocon.dto.Zone;
import org.geekocon.dto.ZoneType;

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
        zone1.setTotalTicketAmount(51);
        zone1.setAvailableTicketAmount(20);
        zone1.setName("Zone1");
        zone1.setDescription("the Best Zone");
        ZoneType zoneType1 = new ZoneType();
        zoneType1.setName("type1");
        zone1.setType(zoneType1);
        zones.add(zone1);

        Zone zone2  = new Zone();
        zone2.setTotalTicketAmount(61);
        zone2.setAvailableTicketAmount(25);
        zone2.setName("Zone2");
        zone2.setDescription("the Best Zone");
        ZoneType zoneType2 = new ZoneType();
        zoneType2.setName("type2");
        zone2.setType(zoneType2);
        zones.add(zone2);

        Zone zone3  = new Zone();
        zone3.setTotalTicketAmount(24);
        zone3.setAvailableTicketAmount(22);
        zone3.setName("Zone3");
        zone3.setDescription("the Best Zone");
        ZoneType zoneType3 = new ZoneType();
        zoneType3.setName("type3");
        zone3.setType(zoneType3);
        zones.add(zone3);

        return Response.ok(zones).build();
    }
}
