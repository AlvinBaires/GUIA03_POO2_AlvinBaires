package com.sv.udb.controlador;

import com.sv.udb.modelo.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TipoDocuCtrl {
    
    public boolean guar(TipoDocu obje)
    {
        boolean resp = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try
        {
            em.persist(obje);
            tx.commit();
            resp = true;
        }
        catch(Exception ex)
        {
            tx.rollback();
        }
        em.close();
        emf.close();
        return resp;
    }
    
     public List<TipoDocu>  ConsTodo()
    {
        List<TipoDocu> resp = new ArrayList<>();
          EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
           EntityManager em = emf.createEntityManager();
        try
        {
          TypedQuery<TipoDocu> query =em.createNamedQuery("TipoDocu.findAll", TipoDocu.class);
          resp = query.getResultList();
        }
        catch(Exception ex)
        {
            
        }
        return resp;
       
    }
        public boolean modi(TipoDocu obje)
    {
        boolean resp = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
         TipoDocu objeTipoDocu = null;
        tx.begin();
        try
        {
            
            objeTipoDocu = em.find(TipoDocu.class, obje.getCodiTipoDocu());
            objeTipoDocu.setNombTipoDocu(obje.getNombTipoDocu());
            tx.commit();
            resp = true;
        }
        catch(Exception ex)
        {
            tx.rollback();
        }
        em.close();
        emf.close();
        return resp;
    }
    
   
    public boolean elim(Long empId)
    {
        boolean resp = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();       
        tx.begin();
        TipoDocu respo = null;
        try{
            respo = em.find(TipoDocu.class, empId);
            if(respo != null)
            {
                em.remove(respo);
                tx.commit();
                resp = true; 
            }
        }catch(Exception e){
            tx.rollback();
        }
        em.close();
        emf.close();
        return resp;
    }


     
     
    public TipoDocu get(Long empId){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        TipoDocu resp = null;
        
        try{
            resp = em.find(TipoDocu.class, empId);
            
        }catch(Exception e){
            e.printStackTrace();
        }                
        return resp;
    }
}
