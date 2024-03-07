package org.example.repository;

import org.example.model.User;

import java.util.HashMap;
import java.util.Map;

public class BalanceRepo {
    private Map<String, Double> AOwesB;
    public BalanceRepo(){
        AOwesB = new HashMap<>();
    }
    public void AOwesToB(User u1, User u2, Double amount){
        String key = u1.getUserId()+"#"+u2.getUserId();
        Double prevAmount = AOwesB.getOrDefault(key,0d);
        AOwesB.put(key,prevAmount+amount);
    }

    public Double queryAOwesB(String u1, String u2){
        String key = u1+"#"+u2;
        Double amount = 0d;
        if(AOwesB.containsKey(key))
            amount+= AOwesB.get(key);
        return amount;
    }
}
