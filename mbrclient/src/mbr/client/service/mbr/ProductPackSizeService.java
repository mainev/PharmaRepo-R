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
import mbr.client.entity.mbr.PackSize;
import mbr.client.entity.main.Product;
import mbr.client.entity.mbr.ProductPackSize;
import mbr.client.utils.Serializer;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

/**
 *
 * @author maine
 */
public class ProductPackSizeService {

    public DefaultClientConfig defaultClientConfig;
    public Client client;
    public WebResource webResource;
    public String BASE_URI = "http://localhost:8080/RedWebServer/webresources/mbr/productpacksize";

    public ProductPackSizeService() {
        initClient();
    }

    private void initClient() {
        defaultClientConfig = new DefaultClientConfig();
        defaultClientConfig.getClasses().add(JacksonJsonProvider.class);
        client = Client.create(defaultClientConfig);
    }

    public ObservableList<ProductPackSize> getProductPackSizeList() {
        webResource = client.resource(BASE_URI);
        ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
        String jsonOutput = response.getEntity(String.class);
        return Serializer.<ProductPackSize>deserializeList(jsonOutput, ProductPackSize.class);
    }

    public ProductPackSize createProductPackSize(Product productId, PackSize packSizeId) {
        ProductPackSize productPackSizeId = new ProductPackSize(productId, packSizeId);
        String jsonInput = Serializer.serialize(productPackSizeId);
        webResource = client.resource(BASE_URI + "/create");
        ClientResponse response = webResource.type("application/json").post(ClientResponse.class, jsonInput);
        String jsonResult = response.getEntity(String.class);
        return Serializer.<ProductPackSize>deserialize(jsonResult, ProductPackSize.class);
    }

    public ProductPackSize getProductPackSize(Product productId, PackSize packSizeId) {
        webResource = client.resource(BASE_URI + "/getproductpacksize");

        ClientResponse response = webResource
                .queryParam("product_id", String.valueOf(productId.getId()))
                .queryParam("pack_size_id", String.valueOf(packSizeId.getId()))
                .accept("application/json")
                .get(ClientResponse.class);

        String jsonResult = response.getEntity(String.class);
        return Serializer.<ProductPackSize>deserialize(jsonResult, ProductPackSize.class);
        // return null;
    }
}
