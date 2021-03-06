/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server._main.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import server.mbr.entity.ManufacturingProcedure;
import server.mbr.entity.PackSize;
import server.mbr.entity.UDF;

/**
 *
 * @author maine
 */
@Entity
@Table(name = "product", schema="main")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")})
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 5)
    @Column(name = "code")
    private String code;
    @Size(max = 200)
    @Column(name = "brand_name")
    private String brandName;
    @Size(max = 200)
    @Column(name = "generic_name")
    private String genericName;
  
    @Size(max = 10)
    @Column(name = "vr_no")
    private String vrNo;
    @Column(name = "shelf_life")
    private Short shelfLife;
    @JoinColumn(name = "area_id", referencedColumnName = "id")
    @ManyToOne
    private Area areaId;
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @ManyToOne
    private Client clientId;
   
    
    @JoinColumn(name = "classification_id", referencedColumnName = "id")
    @ManyToOne
    private Classification classificationId;
    
    @OneToMany(mappedBy = "productId")
    private Collection<UDF> udfCollection;
    
    @JoinTable(name = "product_pack_size", schema = "mbr", 
            joinColumns = {
                @JoinColumn(name = "product_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "pack_size_id", referencedColumnName = "id")
            }
    )
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<PackSize> packSizeCollection;
    
    
    @OneToMany(mappedBy = "productId")
    private Collection<ManufacturingProcedure> manufacturingProcedureCollection;
    
    public Product() {
    }

    public Product(Integer id) {
        this.id = id;
    }

    public Collection<ManufacturingProcedure> getManufacturingProcedureCollection() {
        return manufacturingProcedureCollection;
    }

    public void setManufacturingProcedureCollection(Collection<ManufacturingProcedure> manufacturingProcedureCollection) {
        this.manufacturingProcedureCollection = manufacturingProcedureCollection;
    }

    
    public Collection<PackSize> getPackSizeCollection() {
        return packSizeCollection;
    }

    public void setPackSizeCollection(Collection<PackSize> packSizeCollection) {
        this.packSizeCollection = packSizeCollection;
    }

    
    public Collection<UDF> getUdfCollection() {
        return udfCollection;
    }

    public void setUdfCollection(Collection<UDF> udfCollection) {
        this.udfCollection = udfCollection;
    }
    
    
    
    public Classification getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(Classification classificationId) {
        this.classificationId = classificationId;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

  

    public String getVrNo() {
        return vrNo;
    }

    public void setVrNo(String vrNo) {
        this.vrNo = vrNo;
    }

    public Short getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(Short shelfLife) {
        this.shelfLife = shelfLife;
    }

    public Area getAreaId() {
        return areaId;
    }

    public void setAreaId(Area areaId) {
        this.areaId = areaId;
    }

    public Client getClientId() {
        return clientId;
    }

    public void setClientId(Client clientId) {
        this.clientId = clientId;
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
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "server._main.entity.Product[ id=" + id + " ]";
    }
    
}
