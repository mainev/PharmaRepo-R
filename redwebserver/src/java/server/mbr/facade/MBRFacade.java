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
import server.mbr.entity.MBR;

/**
 *
 * @author maine
 */
@Stateless
public class MBRFacade {

    @PersistenceContext(unitName = "RedWebServerPU")
    private EntityManager em;
    
    public List<MBR> findAll(){
        return em.createQuery("SELECT m from MBR m order by m.id desc").getResultList();
    }
    
    public MBR create(MBR mbr){
        em.persist(mbr);
        em.flush();
        return em.find(MBR.class, mbr.getId());
    }
}
