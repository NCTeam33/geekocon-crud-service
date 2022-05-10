package org.geekocon.services;

import io.quarkus.security.identity.SecurityIdentity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.geekocon.controllers.ZoneController;
import org.geekocon.dto.Zone;
import org.geekocon.exception.GeekoconException;


import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.*;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.Response.Status.OK;


@Singleton
public class ZoneService {
    @Inject
    JsonWebToken token;
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
            String userId = token.getSubject();
            System.out.println(userId);
            newZone.setContributorId(userId);
            newZone.persistAndFlush();
        } catch (PersistenceException e){
            if(e.getCause() instanceof org.hibernate.exception.ConstraintViolationException) {
                throw new GeekoconException(e.getCause().getCause().getMessage());
            }
            throw e;
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
