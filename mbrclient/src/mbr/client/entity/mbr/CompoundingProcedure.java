/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbr.client.entity.mbr;

import java.io.Serializable;
import java.util.Collection;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author maine
 */
@XmlRootElement
public class CompoundingProcedure implements Serializable, Comparable<CompoundingProcedure> {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private short stepNumber;
    private String procedureHead;
    private Boolean footer;
    private String doneBy;
    private String checkedBy;
    private ManufacturingProcedure manufacturingProcedureId;
    private Collection<DosageInProcedure> dosageInProcedureCollection;

    public Collection<DosageInProcedure> getDosageInProcedureCollection() {
        return dosageInProcedureCollection;
    }

    public void setDosageInProcedureCollection(Collection<DosageInProcedure> dosageInProcedureCollection) {
        this.dosageInProcedureCollection = dosageInProcedureCollection;
    }

    @XmlTransient
    public ManufacturingProcedure getManufacturingProcedureId() {
        return manufacturingProcedureId;
    }

    public void setManufacturingProcedureId(ManufacturingProcedure manufacturingProcedureId) {
        this.manufacturingProcedureId = manufacturingProcedureId;
    }

    public short getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(short stepNumber) {
        this.stepNumber = stepNumber;
    }

    public String getProcedureHead() {
        return procedureHead;
    }

    public void setProcedureHead(String procedureHead) {
        this.procedureHead = procedureHead;
    }

    public Boolean getFooter() {
        return footer;
    }

    public void setFooter(Boolean footer) {
        this.footer = footer;
    }

    public String getDoneBy() {
        return doneBy;
    }

    public void setDoneBy(String doneBy) {
        this.doneBy = doneBy;
    }

    public String getCheckedBy() {
        return checkedBy;
    }

    public void setCheckedBy(String checkedBy) {
        this.checkedBy = checkedBy;
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
        if (!(object instanceof CompoundingProcedure)) {
            return false;
        }
        CompoundingProcedure other = (CompoundingProcedure) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "server.mbr.entity.CompoundingProcedure[ id=" + id + " ]";
    }

    @Override
    public int compareTo(CompoundingProcedure cp) {
        int comparedNumber = cp.getStepNumber();
        if (stepNumber < comparedNumber) {
            return 1;
        } else if (stepNumber == comparedNumber) {
            return 0;
        } else {
            return -1;
        }
    }
}
