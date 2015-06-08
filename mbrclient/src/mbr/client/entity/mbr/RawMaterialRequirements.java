/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbr.client.entity.mbr;

import mbr.client.entity.main.RawMaterial;
import mbr.client.entity.main.Unit;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author maine
 */
@XmlRootElement
public class RawMaterialRequirements implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private RawMaterial rawMaterialId;
    private double quantity;
    private UDF udfId;
    private Unit unitId;

    private double newQuantity;
    private String newUnit;

    @XmlTransient
    public double getNewQuantity() {
        return newQuantity;
    }

    public void setNewQuantity(double newQuantity) {
        this.newQuantity = newQuantity;
    }

    @XmlTransient
    public String getNewUnit() {
        return newUnit;
    }

    public void setNewUnit(String newUnit) {
        this.newUnit = newUnit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RawMaterial getRawMaterialId() {
        return rawMaterialId;
    }

    public void setRawMaterialId(RawMaterial rawMaterialId) {
        this.rawMaterialId = rawMaterialId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @XmlTransient
    public UDF getUdfId() {
        return udfId;
    }

    public void setUdfId(UDF udfId) {
        this.udfId = udfId;
    }

    public Unit getUnitId() {
        return unitId;
    }

    public void setUnitId(Unit unitId) {
        this.unitId = unitId;
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
        if (!(object instanceof RawMaterialRequirements)) {
            return false;
        }
        RawMaterialRequirements other = (RawMaterialRequirements) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ id=" + id + " ] newQuantity : " + newQuantity;
    }

}
