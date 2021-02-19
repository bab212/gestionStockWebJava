/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Produit;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author NGSI
 */
@WebService
// Permet de spécifier l'encodage du message RPC ou Document
 @SOAPBinding(style=SOAPBinding.Style.DOCUMENT)
public interface ProductInterface{
// expose la méthode comme une opération SOAP
 @WebMethod String fetch(String [] c);
}