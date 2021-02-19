/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Produit;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.jws.WebService;

/**
 *
 * @author NGSI
 */
@WebService(endpointInterface = "Produit.ProductInterface")

public class ProductImpl implements ProductInterface  {
    
    Connection connect;
    
    
 

    @Override
    public String fetch(String[] c) {
        
        connect = DbConnect.connecte();
        String [] requete = c;
        
        
        switch(requete[0]){
            case "1":
            {
                String id;
                
                
                String res="";
                try{
                    id = requete[1];
                    String sql="SELECT * FROM `product` WHERE `id_product`='"+id+"' ";
                    PreparedStatement pst = connect.prepareStatement(sql);
                    ResultSet rs = pst.executeQuery();
                    while(rs.next()){
                        res="nom produit "+rs.getString(2)+"| quantiter "+rs.getString(3)+"\n";
                        
                    }
                    return res;
                }catch (SQLException e){
                    System.out.println(e);
                }
                
                break;
            }
            case "2":
            {
                try{
                   
                    String sql = "SELECT * FROM `product`";
                    PreparedStatement pst = connect.prepareStatement(sql);
                    ResultSet rs = pst.executeQuery();
                    String str= "";
                    int i=10;
                    while(rs.next()){
                        //String str1="";
                        //str1= rs.getString("id_product")+" "+rs.getString("product_name")+" "+rs.getString("quantity");
                       str= str +" || "+ rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+"  ";
                    }
                    
                    return str;
                }catch (SQLException e){
                    System.out.println(e);
                }
                break;
            }
            case "3":
            {
                try{
                   
                    String nomProduit = requete[2];
                    String quantiter = requete[3];
                    String sql ="INSERT INTO `product`(`product_name`, `quantity` WHERE product_name!='"+nomProduit+"') VALUES ('"+nomProduit+"','"+quantiter+"')";
                    PreparedStatement pst = connect.prepareStatement(sql);
                    pst.execute();
                   return "insertion succes";
                }catch (SQLException e){
                    System.out.println(e);
                }
                break;
            }
            case "4":
            {
                try{
                    String idSupprimer = requete[1];
                    String sql = "DELETE FROM `product` WHERE id_product='"+idSupprimer+"'";
                    PreparedStatement pst = connect.prepareStatement(sql);
                    pst.execute();
                    return "le produit "+idSupprimer+" est bien suprimer";
                }catch (SQLException e){
                    System.out.print(e);
                }
                break;
            }
            case "5":
            {
              try{
               String idUpdate = requete[1];
               String nouvNom = requete[2];
               String nouvQuant = requete[3];
               String sql = "UPDATE `product` SET `product_name`='"+nouvNom+"',`quantity`='"+nouvQuant+"' WHERE id_product='"+idUpdate+"'";
               PreparedStatement pst = connect.prepareStatement(sql);
               pst.execute();
               
               return "le produit :" +idUpdate+" a bien ete modifier";
              }catch (SQLException e){
                  System.out.println(e);
              }
               
            }
        }
        
        return "";
    }
    
    
    
}
