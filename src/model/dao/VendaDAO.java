package model.dao;

import connection.ConnectionFactory;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import model.beans.Venda;


public class VendaDAO {

    public static Venda save(Venda venda){
        
        EntityManager em = ConnectionFactory.getConnection();
        try{
            em.getTransaction().begin();
            if(venda.getId() == null){
                em.persist(venda);
            }else{
                em.merge(venda);
            }
            em.getTransaction().commit();
        }catch(Exception ex){
            em.getTransaction().rollback();
            System.err.println("erro: " + ex);
        }finally{
            em.close();
        }
        
        return venda;
    }
    
    public static Venda findById(Integer id){
        
        Venda venda = null;
        EntityManager em = ConnectionFactory.getConnection();
        try{
            venda = em.find(Venda.class, id);
        }catch(Exception ex){
            System.err.println("erro: " + ex);
        }finally{
            em.close();
        }
        
        return venda;
        
    }
    
    public static List<Venda> findAll(){
        
        List<Venda> vendas = new ArrayList<>();
        EntityManager em = ConnectionFactory.getConnection();
        try{
            vendas = em.createQuery("from Venda v").getResultList();
        }catch(Exception ex){
            System.err.println("erro: " + ex);
        }finally{
            em.close();
        }
        
        return vendas;
        
    }
}
