package org.geekocon.services;

import org.geekocon.dto.Zone;
import org.geekocon.dto.ZoneType;
import org.geekocon.exception.UnknownTypeException;

import javax.inject.Singleton;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.List;
import static io.quarkus.hibernate.orm.panache.PanacheEntityBase.findById;
import static javax.ws.rs.core.Response.Status.OK;

@Singleton
public class ZoneService {

    @Transactional
    public List<Zone> getZones() {
        return Zone.listAll();
    }

    @Transactional
    public void addZone(Zone newZone){
        List<ZoneType> tempList = ZoneType.listAll();
        for(ZoneType type: tempList) {
            if (type.id.equals(newZone.getType().id)){
                newZone.persist();
                return;
            }
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
        return findById(id);
    }

}
