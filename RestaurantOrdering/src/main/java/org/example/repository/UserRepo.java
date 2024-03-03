package org.example.repository;

import org.example.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepo {
    private Map<String, User> userMap;

    public UserRepo(){
        userMap = new HashMap<>();
    }

    public boolean addUser(User user){
        if(userMap.containsKey(user.getName()))
            return false;
        userMap.put(user.getName(), user);
        return true;
    }
    public User getUser(String name){
        if(!userMap.containsKey(name))
            return null;
        return userMap.get(name);
    }
}
