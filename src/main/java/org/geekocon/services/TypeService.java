package org.geekocon.services;
import org.geekocon.dto.Zone;
import org.geekocon.dto.ZoneType;
import org.geekocon.exception.DependencyZoneTypeException;

import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.List;

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
    public void deleteType(Long id){
      /* Zone temp = Zone.find("type", id).firstResult();
       if(temp != null) throw new DependencyZoneTypeException(temp.getName());*/
        List<Zone> tempList = Zone.listAll();
        for(Zone zone: tempList) {
            if (zone.getType().id.equals(id)) {
                throw new DependencyZoneTypeException(zone.getName());
            }
        }
        ZoneType.deleteById(id);
        return;
    }

}
