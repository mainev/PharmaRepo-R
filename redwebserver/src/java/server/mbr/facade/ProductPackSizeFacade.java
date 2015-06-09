/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.mbr.facade;

import java.util.List;
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

    public List<ProductPackSize> findAll() {
        return em.createQuery("Select p from ProductPackSize p").getResultList();
    }

    public ProductPackSize create(ProductPackSize productPackSizeId) {
        ProductPackSize pp = findByProductIdAndPackSizeDetails(productPackSizeId);

        if (pp != null) {
            return pp;
        } else {
            em.persist(productPackSizeId);
            em.flush();
            return em.find(ProductPackSize.class, productPackSizeId.getId());
        }
    }

    public ProductPackSize findByProductIdAndPackSizeId(int productId, int packSizeId) {
        return (ProductPackSize) em.createQuery("Select p from ProductPackSize p where p.productId.id = :productId AND p.packSizeId.id = :packSizeId")
                .setParameter("productId", productId)
                .setParameter("packSizeId", packSizeId)
                .getSingleResult();
    }

    public ProductPackSize findByProductIdAndPackSizeDetails(ProductPackSize productPackSizeId) {
        List<ProductPackSize> list = em.createQuery("Select p from ProductPackSize p where p.productId = :productId AND p.packSizeId.unitId = :unitId AND p.packSizeId.containerId = :containerId AND p.packSizeId.quantity = :quantity")
                .setParameter("productId", productPackSizeId.getProductId())
                .setParameter("unitId", productPackSizeId.getPackSizeId().getUnitId())
                .setParameter("containerId", productPackSizeId.getPackSizeId().getContainerId())
                .setParameter("quantity", productPackSizeId.getPackSizeId().getQuantity())
                .getResultList();
        if (!list.isEmpty()) {
            return list.get(0);

        }
        return null;
    }
}
