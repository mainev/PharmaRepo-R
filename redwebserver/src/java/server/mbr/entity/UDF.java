/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.mbr.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import server._main.entity.Product;
import server._main.entity.Unit;

/**
 *
 * @author maine
 */
@Entity
@Table(name = "udf", schema = "mbr")
@XmlRootElement
public class UDF implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Short id;

    @Column(name = "content")
    private double content;

    @JoinColumn(name = "unit_id", referencedColumnName = "id")
    @ManyToOne
    private Unit unitId;

    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne
    private Product productId;
    
    @Column(name = "is_active")
    private boolean isActive;
    
    @OneToMany(mappedBy = "udfId")
    private Collection<RawMaterialRequirements> rawMaterialRequirementsCollection;
    
    @OneToMany(mappedBy = "udfId")
    private Collection<PackagingMaterialRequirements> packagingMaterialRequirementsCollection;

    public Collection<PackagingMaterialRequirements> getPackagingMaterialRequirementsCollection() {
        return packagingMaterialRequirementsCollection;
    }

    public void setPackagingMaterialRequirementsCollection(Collection<PackagingMaterialRequirements> packagingMaterialRequirementsCollection) {
        this.packagingMaterialRequirementsCollection = packagingMaterialRequirementsCollection;
    }
    
    

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Collection<RawMaterialRequirements> getRawMaterialRequirementsCollection() {
        return rawMaterialRequirementsCollection;
    }

    public void setRawMaterialRequirementsCollection(Collection<RawMaterialRequirements> rawMaterialRequirementsCollection) {
        this.rawMaterialRequirementsCollection = rawMaterialRequirementsCollection;
    }

    
    public double getContent() {
        return content;
    }

    public void setContent(double content) {
        this.content = content;
    }

    public Unit getUnitId() {
        return unitId;
    }

    public void setUnitId(Unit unitId) {
        this.unitId = unitId;
    }

    @XmlTransient
    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
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
        if (!(object instanceof UDF)) {
            return false;
        }
        UDF other = (UDF) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "server.mbr.entity.UDF[ id=" + id + " ]";
    }

}
