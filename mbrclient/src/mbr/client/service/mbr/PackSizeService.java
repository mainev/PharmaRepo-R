/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbr.client.service.mbr;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import javafx.collections.ObservableList;
import mbr.client.entity.main.Container;
import mbr.client.entity.mbr.PackSize;
import mbr.client.entity.main.Unit;
import mbr.client.utils.Serializer;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

/**
 *
 * @author maine
 */
public class PackSizeService {

    public DefaultClientConfig defaultClientConfig;
    public Client client;
    public WebResource webResource;
    public String BASE_URI = "http://localhost:8080/RedWebServer/webresources/mbr/packsize";

    public PackSizeService() {
        initClient();
    }

    private void initClient() {
        defaultClientConfig = new DefaultClientConfig();
        defaultClientConfig.getClasses().add(JacksonJsonProvider.class);
        client = Client.create(defaultClientConfig);
    }
    
    public  ObservableList<PackSize> getPackSizeList() {
        webResource = client.resource(BASE_URI);
        ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
        String jsonOutput = response.getEntity(String.class);
        return Serializer.<PackSize>deserializeList(jsonOutput, PackSize.class);
    }

    public PackSize createPackSize(double quantity, Unit unitId, Container containerId) {
        PackSize packSizeId = new PackSize(quantity, unitId, containerId);
        String jsonInput = Serializer.serialize(packSizeId);
        webResource = client.resource(BASE_URI + "/create");
        ClientResponse response = webResource.type("application/json").post(ClientResponse.class, jsonInput);
        String jsonResult = response.getEntity(String.class);
        return Serializer.<PackSize>deserialize(jsonResult, PackSize.class);
    }

}
