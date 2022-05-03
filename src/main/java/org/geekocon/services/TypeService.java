package org.geekocon.services;
import org.geekocon.dto.ZoneType;
import org.geekocon.exception.DependencyZoneTypeException;

import javax.inject.Singleton;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.List;

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
    public Response deleteType(Long id){
        try{
            ZoneType.delete("id", id);
        }
        catch (PersistenceException e){
            if(e.getCause() instanceof org.hibernate.exception.ConstraintViolationException)
                throw new DependencyZoneTypeException(e.getCause().getMessage());
        }
        return Response.status(OK).build();
    }


    @Transactional
    public ZoneType updateType(Long id, String name){
        ZoneType zoneType = ZoneType.findById(id);
        zoneType.setName(name);
        return zoneType;
    }

}
