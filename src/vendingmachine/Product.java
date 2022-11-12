/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

/**
 *
 * @author mahdii
 */
public class Product {
    private String name;
    private double price;
    private int quentity;
    
    public Product (String name, double price, int quentity) {
        this.name = name;       
        this.price = price;
        this.quentity = quentity;
    }
    
    public String getName() {
        return this.name;
    }
    
    public double getPrice() {
        return this.price;
    }
    
    public int getQuentity() {
        return this.quentity;
    }
    
    public int setQuentity(int newQuentity) {
        this.quentity = newQuentity;
        return this.quentity;
    }
    
    
}
