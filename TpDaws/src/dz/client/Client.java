/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.client;

import Produit.ProductInterface;
import java.net.URL;
import java.util.Scanner;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 *
 * @author NGSI
 */
public class Client {
    
    public static void main(String[] args) throws Exception {
    URL url = new URL("http://localhost:7777/ws/product?wsdl");
    QName qname = new QName("http://Produit/", "ProductImplService");
    //1er argument l’URI du service ( document wsdl )
    //2 eme argument le nom du service
    Service service = Service.create(url, qname);
    ProductInterface p = service.getPort(ProductInterface.class);
    Scanner input = new Scanner(System.in);
    String[] cas = new String[10];
        
    System.out.println(" Choisi une operation : ");
    System.out.println(" 1- Recherche un produit ");
    System.out.println(" 2- Lister tout les produits ");
    System.out.println(" 3- Ajouter un produit "); 
    System.out.println(" 4- Supprimer un produit ");
    System.out.println(" 5- Mettre a jour un produit ");
    
    String c = input.nextLine();
   
    
    switch(c){
       
        case "1":
        {
            cas[0]=c;
            System.out.println("Entrer l'id du produit : ");
            String id = input.next();
            
            cas[1]=id;
            System.out.print(p.fetch(cas));
            break;
        }
        case "2":
        {
            cas [0]=c;
            System.out.print(p.fetch(cas));
            break;
        }
        case "3":
        {
            
            cas[0]=c;
            String nomProduit;
            System.out.println("Entrer le nom du produit :");
            
            nomProduit = input.next();
            System.out.println("Vous avez saisiez : "+nomProduit);
            cas[2]=nomProduit;
            System.out.println("Donner la quantite du produit");
            String quantity = input.next();
            cas[3]=quantity;
            System.out.print(p.fetch(cas));
            break;
        }
        case "4":
        {
            cas[0]=c;
            System.out.println("Entrer le id du produit que voulez supprimer :");
            String idSupprimer = input.next();
            cas[1]=idSupprimer;
            System.out.print(p.fetch(cas));
            break;
        }
        case "5":
        {
            cas[0]=c;
            System.out.println("mise a jour");
            System.out.println("L'Id du produit :");
            String id = input.next();
            cas[1]=id;
           
            System.out.println("Entrer le nouveau nom :");
            String nNom = input.next();
            cas[2]=nNom;
             System.out.println("Entrer la nouvelle quantiter :");
            String nQuant = input.next();
            cas[3]=nQuant;
            System.out.print(p.fetch(cas));
            break;
        }
        default:
            System.out.println("Choisir un numero entre 1-5");
    }
 }
    
}
