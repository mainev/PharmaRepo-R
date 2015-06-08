/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.mbr.rest;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import server.mbr.entity.PackSize;
import server.mbr.facade.PackSizeFacade;

/**
 * REST Web Service
 *
 * @author maine
 */
@Path("mbr/packsize")
@RequestScoped
public class PackSizeREST {

    @Context
    private UriInfo context;

    @Inject
    private PackSizeFacade packSizeFacade;

    /**
     * Creates a new instance of PackSizeREST
     */
    public PackSizeREST() {
    }

    /**
     * Retrieves representation of an instance of server.mbr.rest.PackSizeREST
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public List<PackSize> getJson() {
       return packSizeFacade.findAll();
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PackSize create(PackSize packSizeId) {
        return packSizeFacade.create(packSizeId);
    }

    /**
     * PUT method for updating or creating an instance of PackSizeREST
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
