package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.beans.Produto;
import model.beans.Venda;
import org.junit.Ignore;
import org.junit.Test;


public class VendaDAOTest {
    
    public VendaDAOTest() {
    }
    private void printProduto(Produto p){
        System.out.println("id produto -> " + p.getId());
        System.out.println("nome -> " + p.getNome());
        System.out.println("preco -> " + p.getPreco());
        System.out.println("quantidade -> " + p.getQuantidade()); 
    }
    
    private void printVenda(Venda v){
        System.out.println("id  = " + v.getId());
        printProduto(v.getProduto());
    }

    @Ignore
    public void testSave(){
        
        Venda v = new Venda();
        
        Produto p = null;
        p = ProdutoDAO.findById(7);
        
        v.setProduto(p);
        v = VendaDAO.save(v);
        
        printVenda(v);
    
    }
    
    @Ignore
    public void testFindById(){
        int id = 1;
        Venda v = VendaDAO.findById(id);
        try{
            printVenda(v);
        }catch(Exception ex){
            System.err.println("erro: " + ex);
        }
        
    }
    
    @Test
    public void testFindAll(){
        
        List<Venda> vendas = new ArrayList<>();
        try{
            vendas = VendaDAO.findAll();
            for(Venda v : vendas){
                printVenda(v);
                System.out.println("");
            }
        }catch(Exception ex){
            System.err.println("erro: " + ex);
        }
           
    }
}
