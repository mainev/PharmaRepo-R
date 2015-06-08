/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbr.client.entity.mbr;

import mbr.client.entity.main.Unit;
import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author maine
 */
@XmlRootElement
public class MBR implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Double batchSize;
    private String batchNo;
    private Date mfgDate;
    private Date expDate;
    private String poNo;
    private Unit unitId;
   // private Product productId;
    private ProductPackSize productPackSizeId;

    
    public MBR(ProductPackSize productPackSizeId, double batchSize, String batchNo, Date mfgDate, Date expDate, 
            String poNo, Unit unitId){
        this.productPackSizeId = productPackSizeId;
        this.batchSize = batchSize;
        this.batchNo = batchNo;
        this.mfgDate = mfgDate;
        this.expDate = expDate;
        this.poNo = poNo;
        this.unitId = unitId;
    }

    public ProductPackSize getProductPackSizeId() {
        return productPackSizeId;
    }

    public void setProductPackSizeId(ProductPackSize productPackSizeId) {
        this.productPackSizeId = productPackSizeId;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(Double batchSize) {
        this.batchSize = batchSize;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public Date getMfgDate() {
        return mfgDate;
    }

    public void setMfgDate(Date mfgDate) {
        this.mfgDate = mfgDate;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public String getPoNo() {
        return poNo;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }

    public Unit getUnitId() {
        return unitId;
    }

    public void setUnitId(Unit unitId) {
        this.unitId = unitId;
    }

//    public Product getProductId() {
//        return productId;
//    }
//
//    public void setProductId(Product productId) {
//        this.productId = productId;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MBR)) {
            return false;
        }
        MBR other = (MBR) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "server.mbr.entity.MBR[ id=" + id + " ]";
    }

}
