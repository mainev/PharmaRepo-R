/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbr.client.entity.mbr;

import java.io.Serializable;
import java.util.Collection;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author maine
 */
@XmlRootElement
public class PackagingProcedure implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Short stepNumber;
    private String procedureHead;
    //private ProductPackSize productPackSizeId;
    private Collection<EquipmentRequirementsPackagingProcedure> equipmentRequirementsPackagingProcedureCollection;

    public Collection<EquipmentRequirementsPackagingProcedure> getEquipmentRequirementsPackagingProcedureCollection() {
        return equipmentRequirementsPackagingProcedureCollection;
    }

    public void setEquipmentRequirementsPackagingProcedureCollection(Collection<EquipmentRequirementsPackagingProcedure> equipmentRequirementsPackagingProcedureCollection) {
        this.equipmentRequirementsPackagingProcedureCollection = equipmentRequirementsPackagingProcedureCollection;
    }

    public Short getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(Short stepNumber) {
        this.stepNumber = stepNumber;
    }

    public String getProcedureHead() {
        return procedureHead;
    }

    public void setProcedureHead(String procedureHead) {
        this.procedureHead = procedureHead;
    }

//    @XmlTransient
//    public ProductPackSize getProductPackSizeId() {
//        return productPackSizeId;
//    }
//
//    public void setProductPackSizeId(ProductPackSize productPackSizeId) {
//        this.productPackSizeId = productPackSizeId;
//    }

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
        if (!(object instanceof PackagingProcedure)) {
            return false;
        }
        PackagingProcedure other = (PackagingProcedure) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "server.mbr.entity.PackagingProcedure[ id=" + id + " ]";
    }

}
