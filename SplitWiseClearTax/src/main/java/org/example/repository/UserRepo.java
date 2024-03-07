package org.example.repository;

import org.example.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepo {
    private Map<String, User> userMap;
    public UserRepo(){
        userMap = new HashMap<>();
    }
    public void addUser(User user){
        userMap.put(user.getUserId(),user);
    }
    public User findById(String userId){
        User u = null;
        if(userMap.containsKey(userId))
            u = userMap.get(userId);
        return u;
    }

    public List<User> getAll(){
        List<User> res = new ArrayList<>();
        for(User u:userMap.values()){
            res.add(u);
        }
        return res;
    }
}
