package org.geekocon.services;
import org.geekocon.dto.ZoneType;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.Response.Status.OK;

@Singleton
public class TypeService {

   @Transactional
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
        ZoneType.deleteById(id);
        return Response.status(OK).build();
    }

}
