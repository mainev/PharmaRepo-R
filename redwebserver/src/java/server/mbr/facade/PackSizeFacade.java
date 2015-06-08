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
import server.mbr.entity.PackSize;

/**
 *
 * @author maine
 */
@Stateless
public class PackSizeFacade {

    @PersistenceContext(unitName = "RedWebServerPU")
    private EntityManager em;

    public PackSize create(PackSize packSizeId) {
        em.persist(packSizeId);
        em.flush();
        return em.find(PackSize.class, packSizeId.getId());
    }
    public List<PackSize> findAll(){
        return em.createQuery("Select p from PackSize p order by p.id desc").getResultList();
    }
}
