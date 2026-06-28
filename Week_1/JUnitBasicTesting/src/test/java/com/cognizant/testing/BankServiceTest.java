/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cognizant.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

public class BankServiceTest {

    @Test
    public void testMockBalance() {

        Database db = mock(Database.class);

        when(db.getBalance()).thenReturn(5000);

        BankService service = new BankService(db);

        int balance = service.fetchBalance();

        assertEquals(5000, balance);

    }

}