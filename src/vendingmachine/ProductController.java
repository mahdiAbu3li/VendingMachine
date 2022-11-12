/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

import java.util.ArrayList;

/**
 *
 * @author mahdii
 */
public class ProductController {
    private ArrayList<Product> products;
    
    public ProductController(){
    products = new ArrayList<Product>();
    };
    
    public ProductController (ArrayList<Product> products){
        this.products = products;
    }
    
    public int addProduct(Product product) {
        products.add(product);
        return products.size();
    }
    
    public Product getProduct(int index) {
        return products.get(index);
    }
    
    public void displayProducts() {
        System.out.println("Available Products in the Machine");
        
        for(int i = 0 ; i < products.size() ; i++){
            if(i % 5 == 0){
                System.out.println("");
            }
            System.out.print("[" + (i + 1) + ". " + products.get(i).getName() + " : " + products.get(i).getPrice() + "] \t");
        }
        System.out.println("");
        System.out.println("");
    }
}
