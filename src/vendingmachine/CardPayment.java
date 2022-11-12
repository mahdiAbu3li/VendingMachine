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
public class CardPayment implements Payment {

    private String card;

    @Override
    public boolean validate() {
        System.out.println("Card is validate");
        return true;
    }

    @Override
    public boolean deduct(double price) {
        System.out.println("deduct " + price + " from " + card);
        return true;
    }

    @Override
    public String despense() {
        System.out.println("return card");
        return "";
    }

    @Override
    public boolean add(String card) {
        this.validate();
        this.card = card;
        System.out.println("Card " + card + " is added");
        return true;
    }

}
