
package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.beans.Produto;
import org.junit.Ignore;




public class ProdutoDAOTest {
    
    public ProdutoDAOTest() {
    }
    
    private void printProduto(Produto p){
        System.out.println("id -> " + p.getId());
        System.out.println("nome -> " + p.getNome());
        System.out.println("preco -> " + p.getPreco());
        System.out.println("quantidade -> " + p.getQuantidade()); 
    }
    
    @Ignore
    public void testSave(){
        Produto p = new Produto();
        p.setNome("Sabonete");
        p.setPreco(1.29);
        p.setQuantidade(300);
        
        p = ProdutoDAO.save(p);
        printProduto(p);   
    }
    
    @Ignore
    public void testFindById(){
        int id = 8;
        Produto p = null;
        try{
            p = ProdutoDAO.findById(id);
            printProduto(p);
        }catch(NullPointerException ex){
            System.out.println("Não existe produto com indice = " + id + ".");
        }   
    }
    
    @Ignore
    public void testFindAll(){
        List<Produto> produtos = new ArrayList<>();
        produtos = ProdutoDAO.findAll();
        for (Produto p : produtos) {
            printProduto(p);
            System.out.println("");
            System.out.println("");
        }   
    }
    
    @Ignore
    public void testRemove(){
        int id = 1;
        Produto p = ProdutoDAO.remove(id);
        try{
            printProduto(p);
        }catch(NullPointerException ex){
            System.err.println("erro: " + ex);
        }
        if(p==null){
            System.out.println("Não existia produto com este indice!");
        }else if(ProdutoDAO.findById(id) == null){
            System.out.println("Produto apagado!");
        }else{
            System.out.println("Produto não foi apagado!");
        }
    }
    
    
}    

    
    
