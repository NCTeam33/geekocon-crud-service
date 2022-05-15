package org.geekocon.services;
import org.geekocon.dto.GeekoconMessage;
import org.geekocon.dto.ZoneType;
import org.geekocon.exception.GeekoconException;
import org.jboss.resteasy.reactive.RestResponse;

import javax.inject.Singleton;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import javax.validation.constraints.Negative;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.Response.Status.NOT_ACCEPTABLE;
import static javax.ws.rs.core.Response.Status.OK;

@Singleton
public class TypeService {

    public List<ZoneType> getTypes() {
        return ZoneType.listAll();
    }

    @Transactional
    public ZoneType addType(ZoneType newType){
        newType.persist();
        return newType;
    }

    @Transactional
    public GeekoconMessage deleteType(Long id){
        try{
            ZoneType.delete("id", id);
        }
        catch (PersistenceException e){
            if(e.getCause() instanceof org.hibernate.exception.ConstraintViolationException) {
                throw new GeekoconException(e.getCause().getCause().getMessage());
            }
            throw e;
        }
        return new GeekoconMessage(OK, "Good");
    }


    @Transactional
    public ZoneType updateType(Long id, ZoneType name){
        ZoneType zoneType = ZoneType.findById(id);
        zoneType.setName(name.getName());
        return zoneType;
    }

}
