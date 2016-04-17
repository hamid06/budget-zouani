/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.CompteItem;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Adnane
 */
@Stateless
public class CompteItemFacade extends AbstractFacade<CompteItem> {
    @PersistenceContext(unitName = "budget_run2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CompteItemFacade() {
        super(CompteItem.class);
    }
 
//    public int affecterBudgetItem(CompteItem compteItem){
//        
//    }
    
    public Long generateId() {
        Long maxId = (Long) em.createQuery("SELECT MAX(ci.id) FROM CompteItem ci").getSingleResult();
        return (maxId == null ? 1l : maxId + 1);
    }
    
    public void create(CompteItem compteItem){
        
        super.create(compteItem);
    }
}
