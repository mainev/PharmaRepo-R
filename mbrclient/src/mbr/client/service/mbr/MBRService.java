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
import java.util.Collection;
import java.util.Date;
import javafx.collections.ObservableList;
import mbr.client.entity.mbr.MBR;
import mbr.client.entity.mbr.ProductPackSize;
import mbr.client.entity.main.Unit;
import mbr.client.entity.mbr.PackagingMaterialRequirements;
import mbr.client.entity.report.BatchPackagingMaterialRequirements;
import mbr.client.utils.MBRSerializer;
import mbr.client.utils.Serializer;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

/**
 *
 * @author maine
 */
public class MBRService {

    public DefaultClientConfig defaultClientConfig;
    public Client client;
    public WebResource webResource;
    public String BASE_URI = "http://localhost:8080/RedWebServer/webresources/mbr";

    public MBRService() {
        initClient();
    }

    private void initClient() {
        defaultClientConfig = new DefaultClientConfig();
        defaultClientConfig.getClasses().add(JacksonJsonProvider.class);
        client = Client.create(defaultClientConfig);
    }

    public ObservableList<MBR> getMBRList() {

        webResource = client.resource(BASE_URI);
        ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
        String jsonOutput = response.getEntity(String.class);

        return MBRSerializer.deserializeList(jsonOutput);
    }

    public MBR createMBR(ProductPackSize productPackSizeId, double batchSize, String batchNo, Date mfgDate, Date expDate,
            String poNo, Unit unitId) {

        MBR mbr = new MBR(productPackSizeId, batchSize, batchNo, mfgDate, expDate,
                poNo, unitId);
        String input = Serializer.serialize(mbr);
        
        webResource = client.resource(BASE_URI + "/create");
        ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);
        String output = response.getEntity(String.class);
        return Serializer.<MBR>deserialize(output, MBR.class);
        
    }
    
    public int getNoOfBottlesInBatch(Collection<PackagingMaterialRequirements> pmrList, int bottleId){
        for(PackagingMaterialRequirements bpmr : pmrList){
            if(bpmr.getPackagingMaterialId().getId()==bottleId)
                return (int) bpmr.getNewQuantity();
        }
        return 0;
    }
    
    public int getNoOfCBox(Collection<PackagingMaterialRequirements> pmrList, int cBoxId){
          for(PackagingMaterialRequirements pmr : pmrList){
            if(pmr.getPackagingMaterialId().getId()==cBoxId)
                return (int) pmr.getNewQuantity();
        }
        return 0;
    }
}
