/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

import java.util.Scanner;

/**
 *
 * @author mahdii
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        VendingMachine m1 = new VendingMachine();

        Product p1 = new Product("cola", 0.1, 20);
        for (int i = 0; i < 5; i++) {
            m1.addProduct(p1);
        }
        Product p2 = new Product("chips", 1, 40);
        for (int i = 0; i < 5; i++) {
            m1.addProduct(p2);
        }
        Product p3 = new Product("chocolate", 2, 30);
        for (int i = 0; i < 5; i++) {
            m1.addProduct(p3);
        }
        Product p4 = new Product("snacks1", 5, 10);
        for (int i = 0; i < 5; i++) {
            m1.addProduct(p4);
        }
        Product p5 = new Product("snacks2", 50, 20);
        for (int i = 0; i < 5; i++) {
            m1.addProduct(p5);
        }

        m1.displayProducts();

        
        
        System.out.println("pls choose product by index");
        int index = sc.nextInt();

        while (!m1.chooseProduct(index)) {
            System.out.println("Try again, pls choose product by index");
            index = sc.nextInt();
        }

        
        
        
        System.out.println("pls, choose your payment method: ");
        System.out.println("1. Cash");
        System.out.println("2. Card");
        int option = sc.nextInt();
        int paymentMethod = m1.setPaymentMethod(option);

        if (paymentMethod == 1) {
            System.out.println("add money from these slots [ 10c, 20c, 50c, 1$, 20$, 50$]");
            while (true) {
                if (m1.insertMoney(sc.next())) {
                    break;
                }
            }
        } else {
            System.out.println("Enter your Card ID ...");
            String card = sc.next();
            m1.insertCard(card);
        }

    }
}
