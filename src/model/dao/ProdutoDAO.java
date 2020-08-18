package model.dao;

import connection.ConnectionFactory;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import model.beans.Produto;

public class ProdutoDAO {
    
    public static Produto save(Produto produto){
        
        EntityManager em = ConnectionFactory.getConnection();
        try{
            em.getTransaction().begin();
            if(produto.getId() == null){
                em.persist(produto);
            }else{
                em.merge(produto);
            }
            em.getTransaction().commit();
        }catch(Exception ex){
            em.getTransaction().rollback();
            System.err.println("erro: " + ex);
        }finally{
            em.close();
        }
        
        return produto;
 
    }
    
    public static Produto findById(Integer id){
        
        EntityManager em = ConnectionFactory.getConnection();
        Produto produto = null;
        try{
            produto = em.find(Produto.class, id);
        }catch(Exception ex){
            System.err.println("erro: " + ex);
        }finally{
            em.close();
        }
        
        return produto;
        
    }
    
    public static List<Produto> findAll(){
        List<Produto> produtos = new ArrayList<>();
        EntityManager em = ConnectionFactory.getConnection();
        try{
            produtos = em.createQuery("from Produto p").getResultList();
        }catch(Exception ex){
            System.err.println("erro: " + ex);
        }finally{
            em.close();
        }
        
        return produtos;
        
    }
    
    public static Produto remove(Integer id){
        
        EntityManager em = ConnectionFactory.getConnection();
        Produto produto = null;
        try{
            produto = em.find(Produto.class, id);
            if(produto!=null){
                em.getTransaction().begin();
                em.remove(produto);
                em.getTransaction().commit();
            }    
        }catch(Exception ex){
            System.err.println("erro: " + ex);
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
        
        return produto;
        
    }
}
