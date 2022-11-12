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
public interface Payment {

    boolean validate();

    boolean deduct(double price);

    String despense();

    boolean add(String money);
}
