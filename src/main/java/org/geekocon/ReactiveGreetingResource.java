package org.geekocon;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/v1/zones")
@Produces("application/json")
public class ReactiveGreetingResource {

   /* @GET
    public Response getZone() {
        List<Zone> zones = new ArrayList<>();
        return Response.ok(zones).build();
    }*/

    @GET
    public Response getZone() {
        List<Zone> zones = new ArrayList<>();

        Zone zone1 = new Zone();
        zone1.setZoneId(1);
        zone1.setZoneType("Food");
        zone1.setZoneManager("KFC");
        zone1.setZoneManager("OOO Food");

        Zone zone2 = new Zone();
        zone2.setZoneId(2);
        zone2.setZoneType("Food");
        zone2.setZoneManager("Dodo PIZZA");
        zone2.setZoneManager("OOO DODO");

        Zone zone3 = new Zone();
        zone3.setZoneId(3);
        zone3.setZoneType("Game");
        zone3.setZoneManager("Minecraft");
        zone3.setZoneManager("OOO Game");

        zones.add(zone1);
        zones.add(zone2);
        zones.add(zone3);
        return Response.ok(zones).build();
    }
}