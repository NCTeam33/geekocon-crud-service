package org.geekocon.services;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.geekocon.dto.Zone;
import org.geekocon.dto.ZoneType;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static io.quarkus.hibernate.orm.panache.PanacheEntityBase.find;
import static javax.ws.rs.core.Response.Status.OK;

@Singleton
public class ZoneService {

    @Transactional
    public List<Zone> getZones() {
        return Zone.listAll();
    }

    @Transactional
    public Zone addZone(Zone newZone){
        newZone.persist();
        return newZone;
    }

    @Transactional
    public Response deleteZone(Long id){
        Zone.deleteById(id);
        return Response.status(OK).build();
    }

    @Transactional
    public List<Zone> findByTypeId(Long id){
        return find("type_id",id).list();
    }

}
