package com.librarysystem.service;

import com.librarysystem.model.Reader;

import java.util.HashMap;
import java.util.Map;

public class BillingService {

    private Map<Reader, Double> bills = new HashMap<>();


    //fatura
    public void charge(Reader reader, double amount) {
        bills.put(reader, bills.getOrDefault(reader, 0.0) + amount);
        System.out.println(reader.getName() +
                " adlı kullanıcıya " +
                amount + " TL fatura kesildi.");
    }

    //iade
    public void refund(Reader reader, double amount) {
        bills.put(reader, bills.getOrDefault(reader, 0.0) - amount);
        System.out.println(reader.getName() +
                " adlı kullanıcıya " +
                amount + " TL iade edildi.");
    }

    public double getBill(Reader reader) {
        return bills.getOrDefault(reader, 0.0);
    }
}
