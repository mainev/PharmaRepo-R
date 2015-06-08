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
import server._main.entity.Equipment;

/**
 *
 * @author maine
 */
@Entity
@Table(name = "equipment_requirements_packaging_procedure", schema="mbr")
@XmlRootElement
public class EquipmentRequirementsPackagingProcedure implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @JoinColumn(name = "packaging_procedure_id", referencedColumnName = "id")
    @ManyToOne
    private PackagingProcedure packagingProcedureId;
    
    @JoinColumn(name = "equipment_id", referencedColumnName = "id")
    @ManyToOne
    private Equipment equipmentId;

    
    @XmlTransient
    public PackagingProcedure getPackagingProcedureId() {
        return packagingProcedureId;
    }

    public void setPackagingProcedureId(PackagingProcedure packagingProcedureId) {
        this.packagingProcedureId = packagingProcedureId;
    }

    public Equipment getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Equipment equipmentId) {
        this.equipmentId = equipmentId;
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
        if (!(object instanceof EquipmentRequirementsPackagingProcedure)) {
            return false;
        }
        EquipmentRequirementsPackagingProcedure other = (EquipmentRequirementsPackagingProcedure) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "server.mbr.entity.EquipmentRequirementsPackagingProcedure[ id=" + id + " ]";
    }
    
}
