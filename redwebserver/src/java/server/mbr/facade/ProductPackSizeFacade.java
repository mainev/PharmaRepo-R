/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.mbr.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import server.mbr.entity.ProductPackSize;

/**
 *
 * @author maine
 */
@Stateless
public class ProductPackSizeFacade {

    @PersistenceContext(unitName = "RedWebServerPU")
    private EntityManager em;
    
       public ProductPackSize create(ProductPackSize productPackSizeId){
        //   productPackSizeId.getProductId().getPackSizeCollection().add(productPackSizeId.getPackSizeId());
        em.persist(productPackSizeId);
        em.flush();
        return em.find(ProductPackSize.class, productPackSizeId.getId());
    }
    public ProductPackSize findByProductIdAndPackSizeId(int productId, int packSizeId){
        return (ProductPackSize)em.createQuery("Select p from ProductPackSize p where p.productId.id = :productId AND p.packSizeId.id = :packSizeId")
                .setParameter("productId", productId)
                .setParameter("packSizeId", packSizeId)
                .getSingleResult();
    }
}
