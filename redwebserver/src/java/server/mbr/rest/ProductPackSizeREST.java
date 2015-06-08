/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.mbr.rest;

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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import server.mbr.entity.MBR;
import server.mbr.entity.ProductPackSize;
import server.mbr.facade.ProductPackSizeFacade;

/**
 * REST Web Service
 *
 * @author maine
 */
@Path("mbr/productpacksize")
@RequestScoped
public class ProductPackSizeREST {

    @Context
    private UriInfo context;
    
    @Inject
    private ProductPackSizeFacade productPackSizeFacade;

    /**
     * Creates a new instance of ProductPackSizeREST
     */
    public ProductPackSizeREST() {
    }

    /**
     * Retrieves representation of an instance of server.mbr.rest.ProductPackSizeREST
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    
       @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ProductPackSize create(ProductPackSize productPackSizeId) {
       return productPackSizeFacade.create(productPackSizeId);
    }

    @GET
    @Path("/getproductpacksize")
    @Produces("application/json")
    public ProductPackSize findByProductIdAndPackSizeId(@QueryParam("product_id") String productIdString,
            @QueryParam("pack_size_id") String packSizeIdString){
        int productId = Integer.parseInt(productIdString);
        int packSizeId = Integer.parseInt(packSizeIdString);
       
     
        return productPackSizeFacade.findByProductIdAndPackSizeId(productId, packSizeId);
    }
    /**
     * PUT method for updating or creating an instance of ProductPackSizeREST
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
