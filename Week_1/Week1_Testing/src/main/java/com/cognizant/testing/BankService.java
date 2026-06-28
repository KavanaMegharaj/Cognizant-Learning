/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cognizant.testing;

/**
 *
 * @author cmkav
 */


public class BankService {

    private Database database;

    public BankService(Database database) {
        this.database = database;
    }

    public int fetchBalance() {
        return database.getBalance();
    }

}
