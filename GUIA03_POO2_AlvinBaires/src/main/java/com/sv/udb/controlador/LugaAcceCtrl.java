package com.sv.udb.controlador;

import com.sv.udb.modelo.LugaAcce;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * @author Alvin
 * @version 1.0 27 de Agosto de 2016
 */

public class LugaAcceCtrl {
    
    /**
     * Método que guarda un objeto del tipo LugaAcce en la base de datos
     * @param Objeto Objeto del tipo LugaAcce"
     * @return boolean si la operación se realizó correctamente o no
     * @exception Error al persistir objeto         
     * @since incluido desde la version 1.0
     */
    public boolean guar(LugaAcce obje)
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
    
    /**
     * Método que consulta todos los registros de la base de datos
     * @return Lista de objetos tipo LugaAcce
     * @exception Error al consultar       
     * @since incluido desde la version 1.0
     */
    public List<LugaAcce>  ConsTodo()
    {
        List<LugaAcce> resp = new ArrayList<>();
          EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
           EntityManager em = emf.createEntityManager();
        try
        {
          TypedQuery<LugaAcce> query =em.createNamedQuery("LugaAcce.findAll", LugaAcce.class);
           resp = query.getResultList();
        }
        catch(Exception ex)
        {
            
        }
        return resp;
       
    }
    
    /**
     * Método que modifica un objeto de la base de dtos
     * @param Objeto Objeto del tipo LugaAcce"
     * @return boolean si la operación se realizó correctamente o no
     * @exception Error al modificar registro         
     * @since incluido desde la version 1.0
     */
    public boolean modi(LugaAcce obje)
    {
        boolean resp = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        LugaAcce lugar = null;
        tx.begin();
        try
        {
            
            lugar = em.find(LugaAcce.class, obje.getCodiLugaAcce());
            lugar.setNombLugaAcce(obje.getNombLugaAcce());
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
    
   /**
     * Método que camnia estado a un registro de la base de datos
     * @param Entero Código del Registro
     * @return boolean si la operación se realizó correctamente o no
     * @exception Error al cambiar estado al registro         
     * @since incluido desde la version 1.0
     */
    public boolean elim(Long empId)
    {
        boolean resp = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        LugaAcce lugar = null;
        tx.begin();
        try
        {
            
            lugar = em.find(LugaAcce.class, empId);
            lugar.setEsta(0);
            lugar.setFechBaja(new Date());
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


     
    /**
     * Método que consulta un registro de la base de datos
     * @param empId Código del Registro que se quiere consultar
     * @return Objeto tipo LugaAcce
     * @exception Error al consultar registro         
     * @since incluido desde la version 1.0
     */
    public LugaAcce get(Long empId){        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        LugaAcce resp = null;        
        try{
            resp = em.find(LugaAcce.class, empId);
            
        }catch(Exception e){
            e.printStackTrace();
        }                
        return resp;
    }
}
