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
import server._main.entity.RawMaterial;
import server._main.entity.Unit;

/**
 *
 * @author maine
 */
@Entity
@Table(name = "dosage_in_procedure", schema="mbr")
@XmlRootElement
public class DosageInProcedure implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    
    @JoinColumn(name = "raw_material_requirements_id", referencedColumnName = "id")
    @ManyToOne
    private RawMaterialRequirements rawMaterialRequirementsId;
    
    @Column(name = "quantity")
    private Double quantity;
    
//    @JoinColumn(name = "unit_id", referencedColumnName = "id")
//    @ManyToOne
//    private Unit unitId;
//    
    @Column(name = "percent_multiplier")
    private Double percentMultiplier;
    
    @JoinColumn(name = "compounding_procedure_id", referencedColumnName = "id")
    @ManyToOne
    private CompoundingProcedure compoundingProcedureId;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RawMaterialRequirements getRawMaterialRequirementsId() {
        return rawMaterialRequirementsId;
    }

    public void setRawMaterialRequirementsId(RawMaterialRequirements rawMaterialRequirementsId) {
        this.rawMaterialRequirementsId = rawMaterialRequirementsId;
    }

    

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

//    public Unit getUnitId() {
//        return unitId;
//    }
//
//    public void setUnitId(Unit unitId) {
//        this.unitId = unitId;
//    }

    public Double getPercentMultiplier() {
        return percentMultiplier;
    }

    public void setPercentMultiplier(Double percentMultiplier) {
        this.percentMultiplier = percentMultiplier;
    }

    
    @XmlTransient
    public CompoundingProcedure getCompoundingProcedureId() {
        return compoundingProcedureId;
    }

    public void setCompoundingProcedureId(CompoundingProcedure compoundingProcedureId) {
        this.compoundingProcedureId = compoundingProcedureId;
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
        if (!(object instanceof DosageInProcedure)) {
            return false;
        }
        DosageInProcedure other = (DosageInProcedure) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "server.mbr.entity.DosageInProcedure[ id=" + id + " ]";
    }
    
}
