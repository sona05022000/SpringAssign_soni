package com.assign3.q3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.assign.q3.BankAccountController;

public class BankAccountControllerTest {
    private ApplicationContext context;
    private BankAccountController bankAccountController;
    
    @Before
    public void setUp() {
        context = new ClassPathXmlApplicationContext("applicationcontextq3.xml");
        bankAccountController = (BankAccountController) context.getBean("bankAccountController");
    }

    @Test
    public void testWithdraw() {
        double newBalance = bankAccountController.withdraw(123456L, 2000);
        assertEquals(8000, newBalance, 0);
    }

    @Test
    public void testDeposit() {
        double newBalance = bankAccountController.deposit(234567L, 500);
        assertEquals(5500, newBalance, 0);
    }

    @Test
    public void testGetBalance() {
        double balance = bankAccountController.getBalance(123456L);
        assertEquals(10000, balance, 0);
    }

    @Test
    public void testFundTransfer() {
        boolean result = bankAccountController.fundTransfer(123456L, 234567L, 1000);
        assertTrue(result);
        
        result = bankAccountController.fundTransfer(123456L, 234567L, 10000);
        assertFalse(result);
    }
}