/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.mbr.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import server._main.entity.PackagingMaterial;
import server._main.entity.Unit;

/**
 *
 * @author maine
 */
@Entity
@Table(name = "packaging_material_requirements", schema="mbr")
@XmlRootElement
public class PackagingMaterialRequirements implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @JoinColumn(name = "packaging_material_id", referencedColumnName="id")
    @ManyToOne
    private PackagingMaterial packagingMaterialId;
    
    @Column(name = "quantity")
    private Double quantity;
    
    @JoinColumn(name = "udf_id", referencedColumnName = "id")
    @ManyToOne
    private UDF udfId;
    
    @JoinColumn(name = "unit_id", referencedColumnName = "id")
    @ManyToOne
    private Unit unitId;

    public PackagingMaterial getPackagingMaterialId() {
        return packagingMaterialId;
    }

    public void setPackagingMaterialId(PackagingMaterial packagingMaterialId) {
        this.packagingMaterialId = packagingMaterialId;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
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
