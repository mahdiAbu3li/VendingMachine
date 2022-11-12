/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 *
 * @author mahdii
 */
public class CashPayment implements Payment {

    private String paidMoney = "";
    private double cumulativeMoney = 0;
    private double change = 0;
    private final double[] coinsValues = {0.1, 0.2, 0.5, 1.0, 20.0, 50.0};
    private HashMap<String, Double> coins = new HashMap<String, Double>();

    {
        coins.put("10c", coinsValues[0]);
        coins.put("20c", coinsValues[1]);
        coins.put("50c", coinsValues[2]);
        coins.put("1$", coinsValues[3]);
        coins.put("20$", coinsValues[4]);
        coins.put("50$", coinsValues[5]);

    }

    @Override
    public boolean add(String money) {
        this.paidMoney = money;
        if (this.validate()) {
            System.out.println("Sucess: your money is added : " + this.cumulativeMoney);
            return true;
        } else {
            System.out.println("Faild: your Money isn't added");
            return false;
        }
    }

    @Override
    public boolean validate() {

        if (coins.containsKey(paidMoney)) {
            this.cumulativeMoney += coins.get(paidMoney);
            return true;
        }
        return false;
    }

    @Override
    public boolean deduct(double price) {
        if (this.cumulativeMoney >= price) {
            this.change = this.cumulativeMoney - price;
            return true;
        }
        return false;
    }

    @Override
    public String despense() {
        if (change == 0) {
            return "";
        }
        int index = 0;
        String result = "pick your change ";

        for (int i = coinsValues.length - 1; i >= 0; i--) {
            if (change >= coinsValues[i]) {
                index = i;
                break;
            }
        }
        while (change != 0) {
            change = Math.round((change - coinsValues[index]) * 10) / 10.00;
            if (change < 0) {
                change += coinsValues[index];
                if (index > 0) {
                    index--;
                }
                continue;
            }
            result += (getValue(coinsValues[index]) + " ");
        }

        return result;
    }

    private String getValue(double value) {
        for (Entry<String, Double> entry : coins.entrySet()) {

            if (entry.getValue() == value) {
                return entry.getKey();
            }
        }
        return "";
    }

}
