/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbr.client.entity.mbr;

import mbr.client.entity.main.Product;
import java.io.Serializable;
import java.util.Collection;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author maine
 */
@XmlRootElement
public class ProductPackSize implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Product productId;
    private PackSize packSizeId;
    private Collection<PackagingProcedure> packagingProcedureCollection;
    private Collection<PackagingProcedureOperation> packagingProcedureOperationCollection;

    public Collection<PackagingProcedure> getPackagingProcedureCollection() {
        return packagingProcedureCollection;
    }

    public void setPackagingProcedureCollection(Collection<PackagingProcedure> packagingProcedureCollection) {
        this.packagingProcedureCollection = packagingProcedureCollection;
    }

    public Collection<PackagingProcedureOperation> getPackagingProcedureOperationCollection() {
        return packagingProcedureOperationCollection;
    }

    public void setPackagingProcedureOperationCollection(Collection<PackagingProcedureOperation> packagingProcedureOperationCollection) {
        this.packagingProcedureOperationCollection = packagingProcedureOperationCollection;
    }

    public ProductPackSize(Product productId, PackSize packSizeId) {
        this.productId = productId;
        this.packSizeId = packSizeId;
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
