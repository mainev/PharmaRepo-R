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
import server._main.entity.Product;

/**
 *
 * @author maine
 */
@Entity
@Table(name ="product_pack_size", schema="mbr")
@XmlRootElement
public class ProductPackSize implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    
    @JoinColumn(name="product_id", referencedColumnName="id")
    @ManyToOne
    private Product productId;
    
    @JoinColumn(name="pack_size_id", referencedColumnName="id")
    @ManyToOne
    private PackSize packSizeId;
    
    @OneToMany(mappedBy = "productPackSizeId")
    private Collection<PackagingProcedure> packagingProcedureCollection;
    
    @OneToMany(mappedBy = "productPackSizeId")
    private Collection<PackagingProcedureOperation> packagingProcedureOperationCollection;

    public Collection<PackagingProcedureOperation> getPackagingProcedureOperationCollection() {
        return packagingProcedureOperationCollection;
    }

    public void setPackagingProcedureOperationCollection(Collection<PackagingProcedureOperation> packagingProcedureOperationCollection) {
        this.packagingProcedureOperationCollection = packagingProcedureOperationCollection;
    }
    
    

    public Collection<PackagingProcedure> getPackagingProcedureCollection() {
        return packagingProcedureCollection;
    }

    public void setPackagingProcedureCollection(Collection<PackagingProcedure> packagingProcedureCollection) {
        this.packagingProcedureCollection = packagingProcedureCollection;
    }

    
    
    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public PackSize getPackSizeId() {
        return packSizeId;
    }

    public void setPackSizeId(PackSize packSizeId) {
        this.packSizeId = packSizeId;
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
        if (!(object instanceof ProductPackSize)) {
            return false;
        }
        ProductPackSize other = (ProductPackSize) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "server.mbr.entity.ProductPackSize[ id=" + id + " ]";
    }
    
}
