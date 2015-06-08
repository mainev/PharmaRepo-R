/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.mbr.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import server._main.entity.Container;
import server._main.entity.Product;
import server._main.entity.Unit;

/**
 *
 * @author maine
 */
@Entity
@Table(name = "pack_size", schema="mbr")
@XmlRootElement
public class PackSize implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Short id;

    @Column(name = "quantity")
    private double quantity;
    
    @JoinColumn(name = "unit_id", referencedColumnName = "id")
    @ManyToOne
    private Unit unitId;
    
    @JoinColumn(name = "container_id", referencedColumnName = "id")
    @ManyToOne
    private Container containerId;
    
     @ManyToMany(mappedBy = "packSizeCollection")
    private Collection<Product> productCollection;

     @XmlTransient
    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }
     
     
    
    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Unit getUnitId() {
        return unitId;
    }

    public void setUnitId(Unit unitId) {
        this.unitId = unitId;
    }

    public Container getContainerId() {
        return containerId;
    }

    public void setContainerId(Container containerId) {
        this.containerId = containerId;
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
        if (!(object instanceof PackSize)) {
            return false;
        }
        PackSize other = (PackSize) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "server._main.entity.PackSize[ id=" + id + " ]";
    }
    
}
