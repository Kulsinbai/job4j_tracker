package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class PassportOffice {
    private Map<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        String pass = citizen.getPassport();
        if (!citizens.containsKey(pass)) {
            citizens.put(citizen.getPassport(), citizen);
            return true;
        }
        return false;
    }

    public Citizen get(String passport) {
        return citizens.get(passport);
    }
}