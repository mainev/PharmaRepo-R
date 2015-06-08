/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbr.client.entity.main;

import mbr.client.entity.main.Area;
import java.io.Serializable;
import java.util.Collection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.xml.bind.annotation.XmlRootElement;
import mbr.client.entity.mbr.ManufacturingProcedure;
import mbr.client.entity.mbr.PackSize;
import mbr.client.entity.mbr.UDF;

/**
 *
 * @author maine
 */
@XmlRootElement
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String code;
    private String brandName;
    private String genericName;
    private String vrNo;
    private Short shelfLife;
    private Area areaId;
    private Client clientId;
    private Classification classificationId;
    private Collection<UDF> udfCollection;
    private Collection<PackSize> packSizeCollection;
    private Collection<ManufacturingProcedure> manufacturingProcedureCollection;
    public Product() {
    }

    public Product(Integer id) {
        this.id = id;
    }
    
    public ManufacturingProcedure getActiveManufacturingProcedure() {
        for (ManufacturingProcedure mpc : manufacturingProcedureCollection) {
            if (mpc.isIsActive()) {
                return mpc;
            }
        }
        return null;
    }

    public Collection<ManufacturingProcedure> getManufacturingProcedureCollection() {
        return manufacturingProcedureCollection;
    }

    public void setManufacturingProcedureCollection(Collection<ManufacturingProcedure> manufacturingProcedureCollection) {
        this.manufacturingProcedureCollection = manufacturingProcedureCollection;
    }
    
    

    public Collection<PackSize> getPackSizeCollection() {
        return packSizeCollection;
    }

    public void setPackSizeCollection(Collection<PackSize> packSizeCollection) {
        this.packSizeCollection = packSizeCollection;
    }

    public Collection<UDF> getUdfCollection() {
        return udfCollection;
    }

    public void setUdfCollection(Collection<UDF> udfCollection) {
        this.udfCollection = udfCollection;
    }

    public Classification getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(Classification classificationId) {
        this.classificationId = classificationId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public String getVrNo() {
        return vrNo;
    }

    public void setVrNo(String vrNo) {
        this.vrNo = vrNo;
    }

    public Short getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(Short shelfLife) {
        this.shelfLife = shelfLife;
    }

    public Area getAreaId() {
        return areaId;
    }

    public void setAreaId(Area areaId) {
        this.areaId = areaId;
    }

    public Client getClientId() {
        return clientId;
    }

    public void setClientId(Client clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return code + " : " + brandName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public UDF getActiveUdf() {
        for (UDF udf : udfCollection) {
            if (udf.isIsActive()) {
                return udf;
            }
        }
        return null;
    }

    public ObservableList<PackSize> packSizeCollectionProperty() {
        ObservableList<PackSize> list = FXCollections.observableArrayList();
        for (PackSize p : packSizeCollection) {
            list.add(p);
        }
        return list;
    }
}
