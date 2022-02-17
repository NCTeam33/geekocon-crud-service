package org.geekocon.services;

import org.geekocon.dto.Zone;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class ZoneService {

    public List<Zone> getZones() {
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

        return zones;
    }


}
