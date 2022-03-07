package org.geekocon.services;
import org.geekocon.dto.ZoneType;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class TypeService {

   private List<ZoneType> types = new ArrayList<>();

   @Transactional
    public List<ZoneType> getTypes() {
        return types;
    }

    @Transactional
    public void addType(ZoneType newType){
        types.add(newType);
    }

    @Transactional
    public void deleteType(String name){
        types.remove(searchByName(name));
    }

    @Transactional
    public ZoneType searchByName(String name){
        for(ZoneType type : types)
            if(type.getName().equals(name)) return type;
        return null;
    }
}
