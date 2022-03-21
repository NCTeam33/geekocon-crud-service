package org.geekocon.services;

import org.geekocon.dto.Zone;
import org.geekocon.dto.ZoneType;
import org.geekocon.exception.UnknownTypeException;

import javax.inject.Singleton;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.List;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import static javax.ws.rs.core.Response.Status.OK;

@Singleton
public class ZoneService {

    public List<Zone> getZones(Long type) {
        return type == null ? getZones() : getZonesByType(type);
    }

    private List<Zone> getZones() {
        return Zone.listAll();
    }

    public List<Zone> getZonesByType(Long type){
        //TODO to implement
        return Zone.find("type_id = ?1", type).list();
    }

    @Transactional
    public Zone addZone(Zone newZone){
        newZone.persist();
        return newZone;
        //throw new UnknownTypeException(newZone.getType());
    }

    @Transactional
    public Response deleteZone(Long id){
        Zone.deleteById(id);
        return Response.status(OK).build();
    }



}
