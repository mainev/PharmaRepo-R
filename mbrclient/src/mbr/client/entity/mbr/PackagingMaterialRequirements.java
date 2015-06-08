/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbr.client.entity.mbr;

import mbr.client.entity.main.PackagingMaterial;
import mbr.client.entity.main.Unit;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author maine
 */
@XmlRootElement
public class PackagingMaterialRequirements implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private PackagingMaterial packagingMaterialId;
    private Double quantity;
    private Unit unitId;
    
    private double newQuantity;

    public PackagingMaterial getPackagingMaterialId() {
        return packagingMaterialId;
    }

    public void setPackagingMaterialId(PackagingMaterial packagingMaterialId) {
        this.packagingMaterialId = packagingMaterialId;
    }

    public double getNewQuantity() {
        return newQuantity;
    }

    public void setNewQuantity(double newQuantity) {
        this.newQuantity = newQuantity;
    }

   
    

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public void setUnitId(Unit unitId) {
        this.unitId = unitId;
    }

    public Unit getUnitId() {
        return unitId;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        if (!(object instanceof PackagingMaterialRequirements)) {
            return false;
        }
        PackagingMaterialRequirements other = (PackagingMaterialRequirements) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "server.mbr.entity.PackagingMaterialRequirements[ id=" + id + " ]";
    }
    
}
