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

    public List<Zone> getZones() {
        return Zone.listAll();
    }

    @Transactional
    public void addZone(Zone newZone){
        ZoneType temp = ZoneType.find("id", newZone.getType().id).firstResult();
        if(temp != null){
            newZone.persist();
            return;
        }
        throw new UnknownTypeException(newZone.getType());
    }

    @Transactional
    public Response deleteZone(Long id){
        Zone.deleteById(id);
        return Response.status(OK).build();
    }

    @Transactional
    public List<Zone> findByTypeId(Long id){
        return Zone.find("type", id).list();
    }

}
