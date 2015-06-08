/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbr.client.entity.mbr;

import mbr.client.entity.main.Product;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author maine
 */
@XmlRootElement
public class ManufacturingProcedure implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Product productId;
    private boolean isActive;
    private Collection<CompoundingProcedure> compoundingProcedureCollection;
    private Collection<EquipmentRequirementsCompounding> equipmentRequirementsCompoundingCollection;
    private Collection<EquipmentRequirementsEncapsulation> equipmentRequirementsEncapsulationCollection;

    @XmlTransient
    /**
     * *
     * Returns a sorted list of compounding procedures based on its step number.
     */
    public List<CompoundingProcedure> getCompoundingProcedureList() {
        List<CompoundingProcedure> cpList = new ArrayList();
        for (CompoundingProcedure cp : compoundingProcedureCollection) {
            cpList.add(cp);
        }

        cpList = sortCompoundingProcedures(cpList);

        return cpList;
    }

    public Collection<EquipmentRequirementsEncapsulation> getEquipmentRequirementsEncapsulationCollection() {
        return equipmentRequirementsEncapsulationCollection;
    }

    public void setEquipmentRequirementsEncapsulationCollection(Collection<EquipmentRequirementsEncapsulation> equipmentRequirementsEncapsulationCollection) {
        this.equipmentRequirementsEncapsulationCollection = equipmentRequirementsEncapsulationCollection;
    }

    public ObservableList<CompoundingProcedure> compoundingProcedureCollectionProperty() {
        ObservableList<CompoundingProcedure> resultList = FXCollections.observableArrayList();
        for (CompoundingProcedure cp : compoundingProcedureCollection) {
            resultList.add(cp);
        }
        return resultList;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Collection<EquipmentRequirementsCompounding> getEquipmentRequirementsCompoundingCollection() {
        return equipmentRequirementsCompoundingCollection;
    }

    public void setEquipmentRequirementsCompoundingCollection(Collection<EquipmentRequirementsCompounding> equipmentRequirementsCompoundingCollection) {
        this.equipmentRequirementsCompoundingCollection = equipmentRequirementsCompoundingCollection;
    }

    public Collection<CompoundingProcedure> getCompoundingProcedureCollection() {
        //  Collections.sort(compoundingProcedureCollection, Collections.reverseOrder());	
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

    public List<CompoundingProcedure> sortCompoundingProcedures(List<CompoundingProcedure> cpList) {
        Collections.sort(cpList, Collections.reverseOrder());
        return cpList;
    }

}
