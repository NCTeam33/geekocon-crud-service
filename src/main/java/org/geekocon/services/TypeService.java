package org.geekocon.services;
import org.geekocon.dto.Zone;
import org.geekocon.dto.ZoneType;
import org.geekocon.exception.DependencyZoneTypeException;

import javax.inject.Singleton;
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
        Zone temp = Zone.find("type_id = ?1", id).firstResult();
        if(temp != null) throw new DependencyZoneTypeException(temp.getName());
        ZoneType.deleteById(id);
        return Response.status(OK).build();
    }

}
