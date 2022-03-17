package org.geekocon.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.geekocon.dto.Zone;
import org.geekocon.exception.UnknownTypeException;
import org.geekocon.services.ZoneService;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.Response.Status.OK;

@Path("/zones")
@Produces("application/json")
public class ZoneController {

    private static final Logger logger = LogManager.getLogger(ZoneController.class);

    @Inject
    ZoneService zoneService;
    @ServerExceptionMapper
    public RestResponse<String> mapException(UnknownTypeException x) {
        return RestResponse.status(Response.Status.NOT_FOUND, "Unknown type: " + x.zoneType);
    }

    @GET
    public List<Zone> getZone() {
        return zoneService.getZones();
    }

    @GET
    @Path("/type/{id}")
    public List<Zone> getZoneByType(@QueryParam("id") Long id){
        return zoneService.findByTypeId(id);
    }

    //@RolesAllowed({"api-manager"})
    @POST
    public RestResponse<String> addZone(Zone newZone){
        try {
            zoneService.addZone(newZone);
            return RestResponse.status(OK);
        } catch(UnknownTypeException e){
            return mapException(e);
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delZone(Long id){
        zoneService.deleteZone(id);
        return Response.status(OK).build();
    }

}