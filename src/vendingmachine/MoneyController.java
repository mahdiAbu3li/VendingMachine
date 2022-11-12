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
public class MoneyController {

    private Payment payment;

    MoneyController(Payment strategy) {
        this.payment = strategy;
    }

    public boolean add(String money) {
        return this.payment.add(money);
    }

    public boolean deduct(double price) {
        return this.payment.deduct(price);
    }

    public String despense() {
        return this.payment.despense();
    }

}
