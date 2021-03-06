/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbr.client.entity.mbr;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author maine
 */
@XmlRootElement
public class DosageInProcedure implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private RawMaterialRequirements rawMaterialRequirementsId;
    private Double quantity;
    private String unit;
    private Double percentMultiplier;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getPercentMultiplier() {
        return percentMultiplier;
    }

    public void setPercentMultiplier(Double percentMultiplier) {
        this.percentMultiplier = percentMultiplier;
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
