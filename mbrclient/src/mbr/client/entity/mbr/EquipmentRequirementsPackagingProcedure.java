/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbr.client.entity.mbr;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import mbr.client.entity.main.Equipment;

/**
 *
 * @author maine
 */
@XmlRootElement
public class EquipmentRequirementsPackagingProcedure implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
   // private PackagingProcedure packagingProcedureId;
    private Equipment equipmentId;

    
//    @XmlTransient
//    public PackagingProcedure getPackagingProcedureId() {
//        return packagingProcedureId;
//    }
//
//    public void setPackagingProcedureId(PackagingProcedure packagingProcedureId) {
//        this.packagingProcedureId = packagingProcedureId;
//    }

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
