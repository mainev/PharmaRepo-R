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

/**
 *
 * @author maine
 */
@Entity
@Table(name = "manufacturing_procedure", schema="mbr")
@XmlRootElement
public class ManufacturingProcedure implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @JoinColumn(name = "product_id", referencedColumnName="id")
    @ManyToOne
    private Product productId;
    
    @Column(name = "is_active")
    private Boolean isActive;
    
    @OneToMany(mappedBy = "manufacturingProcedureId")
    private Collection<CompoundingProcedure> compoundingProcedureCollection;
    
    @OneToMany(mappedBy = "manufacturingProcedureId")
    private Collection<EquipmentRequirementsCompounding> equipmentRequirementsCompoundingCollection;
    
    @OneToMany(mappedBy = "manufacturingProcedureId")
    private Collection<EquipmentRequirementsEncapsulation> equipmentRequirementsEncapsulationCollection;

    public Collection<EquipmentRequirementsEncapsulation> getEquipmentRequirementsEncapsulationCollection() {
        return equipmentRequirementsEncapsulationCollection;
    }

    public void setEquipmentRequirementsEncapsulationCollection(Collection<EquipmentRequirementsEncapsulation> equipmentRequirementsEncapsulationCollection) {
        this.equipmentRequirementsEncapsulationCollection = equipmentRequirementsEncapsulationCollection;
    }

    
    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    
    public Collection<EquipmentRequirementsCompounding> getEquipmentRequirementsCompoundingCollection() {
        return equipmentRequirementsCompoundingCollection;
    }

    public void setEquipmentRequirementsCompoundingCollection(Collection<EquipmentRequirementsCompounding> equipmentRequirementsCompoundingCollection) {
        this.equipmentRequirementsCompoundingCollection = equipmentRequirementsCompoundingCollection;
    }
    
    

    public Collection<CompoundingProcedure> getCompoundingProcedureCollection() {
        return compoundingProcedureCollection;
    }

    public void setCompoundingProcedureCollection(Collection<CompoundingProcedure> compoundingProcedureCollection) {
        this.compoundingProcedureCollection = compoundingProcedureCollection;
    }
    
    

    @XmlTransient
    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
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
        if (!(object instanceof ManufacturingProcedure)) {
            return false;
        }
        ManufacturingProcedure other = (ManufacturingProcedure) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "server.mbr.entity.ManufacturingProcedure[ id=" + id + " ]";
    }
    
}
