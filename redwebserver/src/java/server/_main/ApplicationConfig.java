/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server._main;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author maine
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(server._main.rest.ContainerREST.class);
        resources.add(server._main.rest.PackagingMaterialREST.class);
        resources.add(server._main.rest.ProductREST.class);
        resources.add(server._main.rest.RawMaterialREST.class);
        resources.add(server._main.rest.UnitREST.class);
        resources.add(server.mbr.rest.MBRRest.class);
        resources.add(server.mbr.rest.PackSizeREST.class);
        resources.add(server.mbr.rest.ProductPackSizeREST.class);
    }
    
}
