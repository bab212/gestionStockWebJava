/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Produit;

import javax.xml.ws.Endpoint;

/**
 *
 * @author NGSI
 */
public class ProductPublisher {
public static void main(String[] args) {
Endpoint.publish("http://localhost:7777/ws/product", new ProductImpl());
}    
}
