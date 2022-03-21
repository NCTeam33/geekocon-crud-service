package org.geekocon.services;
import org.geekocon.dto.ZoneType;

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
        ZoneType.deleteById(id);
       // throw new DependencyZoneTypeException(zone.getName());
        return;
    }

}
