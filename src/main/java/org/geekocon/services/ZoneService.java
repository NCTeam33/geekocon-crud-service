package org.geekocon.services;

import org.geekocon.dto.Zone;

import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class ZoneService {

    private List<Zone> zones = new ArrayList<>();

    @Transactional
    public List<Zone> getZones() {
        return zones;
    }

    @Transactional
    public void addZone(Zone newZone){
        zones.add(newZone);
    }

    @Transactional
    public void deleteZone(String name){
        zones.remove(searchByName(name));
    }

    @Transactional
    public Zone searchByName(String name){
        for(Zone zone : zones)
            if(zone.getName().equals(name)) return zone;
        return null;
    }

}
