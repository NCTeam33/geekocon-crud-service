package org.geekocon.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.geekocon.controllers.ZoneController;
import org.geekocon.dto.Zone;
import org.geekocon.exception.UnknownTypeException;

import javax.inject.Singleton;
import javax.persistence.*;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.Response.Status.OK;


@Singleton
public class ZoneService {
    private static final Logger logger = LogManager.getLogger(ZoneController.class);
    public List<Zone> getZones(Long type) {
        return type == null ? getZones() : getZonesByType(type);
    }

    private List<Zone> getZones() {
        return Zone.listAll();
    }

    public List<Zone> getZonesByType(Long type){
        return Zone.find("type_id = ?1", type).list();
    }

    @Transactional
    public Zone addZone(Zone newZone){
        try {
            newZone.persistAndFlush();
        } catch (PersistenceException e){
            if(e.getCause() instanceof org.hibernate.exception.ConstraintViolationException) {
                logger.info("ERRRRRR{}", e.getCause().getCause());
                throw new UnknownTypeException(e.getCause().getMessage());
            }
        }
        return newZone;
    }

    @Transactional
    public Response deleteZone(Long id){
        Zone.deleteById(id);
        return Response.status(OK).build();
    }

    @Transactional
    public Zone updateZone(long id, Zone newZone){
        Zone zone = Zone.findById(id);
        zone.setName(newZone.getName());
        zone.setType(newZone.getType());
        zone.setDescription(newZone.getDescription());
        zone.setTotalTicketAmount(newZone.getTotalTicketAmount());
        return zone;
    }


}
