/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import vendingmachine.Product;
import vendingmachine.VendingMachine;

/**
 *
 * @author mahdii
 */
public class VendingMachineTest {
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    VendingMachine vm = new VendingMachine();

    @Test
    public void addProductTest() {
        Product p = new Product("cola", 1, 20);
        int result = vm.addProduct(p);
        assertEquals(1, result);
    }

    
    @Test
    public void chooseProductTest() {
        Product p = new Product("cola", 1, 20);
         vm.addProduct(p);
        boolean result = vm.chooseProduct(1);        
        assertTrue(result);
        
        boolean result2 = vm.chooseProduct(5);
        assertFalse(result2);
    }
    
     @Test
    public void insertMoneyTest() {
        Product p = new Product("cola", 1, 20);
         vm.addProduct(p);
        boolean result = vm.chooseProduct(1);        
        assertTrue(result);
        
        vm.setPaymentMethod(1);
        
     
        assertFalse(vm.insertMoney("50c"));
        
             
        assertTrue(vm.insertMoney("50c"));
    }
    
         @Test
    public void despenseChange() {
        Product p = new Product("cola", 1, 20);
         vm.addProduct(p);
        boolean result = vm.chooseProduct(1);        
        assertTrue(result);
        
        vm.setPaymentMethod(1);
        
     
        assertFalse(vm.insertMoney("50c"));
        
             
        assertTrue(vm.insertMoney("1$"));
        
        assertEquals("")
    }
}
