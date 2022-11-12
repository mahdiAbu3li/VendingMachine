/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mahdii
 */
public class VendingMachine {

    private ProductController productController;
    private MoneyController moneyController;
    private Product selectedProduct;
    Scanner sc = new Scanner(System.in);

    public VendingMachine() {
        productController = new ProductController();
    }

    public VendingMachine(ArrayList<Product> products) {
        this.productController = new ProductController(products);
    }

    public int addProduct(Product product) {
        return productController.addProduct(product);
    }

    public void displayProducts() {
        productController.displayProducts();
    }

    public int setPaymentMethod(int option) {
       
        if (option == 1) {
            this.moneyController = new MoneyController(new CashPayment());
        } else if (option == 2) {
            this.moneyController = new MoneyController(new CardPayment());
        }
        return option;
    }

    public boolean insertMoney(String money) {
        if (this.moneyController.add(money)) {
            if (this.selectedProduct == null) {
                System.out.println("pls choose product by index first");
                int index = sc.nextInt();
                this.chooseProduct(index);
            }
            if (this.moneyController.deduct(selectedProduct.getPrice())) {
                this.despensProduct();
                this.despense();
                this.selectedProduct.setQuentity(this.selectedProduct.getQuentity() - 1);
                return true;
            } else {
                System.out.println("pls add more money");
                return false;
            }

        }
        return false;
    }

    public boolean chooseProduct(int index) {
        try {           
            this.selectedProduct = this.productController.getProduct(--index);
        } catch (Exception e) {          
            System.out.println("not available , pls choose anothe one");
            return false;
        }

        if (selectedProduct.getQuentity() > 0) {
            System.out.println(this.selectedProduct.getName() + " is selected and it's price " + this.selectedProduct.getPrice());
            return true;

        } else {
            System.out.println("not available , pls choose anothe one");
            return false;
        }
    }

    private void despensProduct() {
        System.out.println("");
        System.out.println("Pick your " + this.selectedProduct.getName() + " , Enjoy!!");
    }

    public boolean insertCard(String card) {
        this.moneyController.add(card);
        this.moneyController.deduct(this.selectedProduct.getPrice());
        this.despense();
        this.despensProduct();

        return true;
    }

    private String despense() {
        String output = this.moneyController.despense();
        System.out.println(output);
        return output;
    }
}
