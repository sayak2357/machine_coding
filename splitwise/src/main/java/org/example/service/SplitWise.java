package org.example.service;

import org.example.model.User;

import java.util.*;

public class SplitWise {
    Map<User,Integer> userMap;
    Map<Integer,User> reverseMap;
    int userCount;
    double[][] owes;
    Set<User> allUsers;
    public SplitWise(List<User> users){
        int n = users.size();
        this.userCount = n;
        allUsers = new HashSet<>();
        userMap = new HashMap<>();
        reverseMap = new HashMap<>();
        for(int i=0;i<userCount;i++){
            this.userMap.put(users.get(i),i);
            this.reverseMap.put(i,users.get(i));
            allUsers.add(users.get(i));
        }
        this.owes = new double[userCount][userCount];
    }
    public void equalSplit(Double amount,String source,List<String> userIds){
        int n = userIds.size();
        double perHeadAmount = amount/n;
        User sourceUser = findUser(source);
        for(String uid:userIds){
            if(!uid.equals(source)){
                User currUser = findUser(uid);
                int sourceIndex = userMap.get(currUser);
                int destIndex = userMap.get(sourceUser);
                owes[sourceIndex][destIndex] += perHeadAmount;
            }
        }
        normalise();
    }
    public void exactSplit(Double amount, List<Double> amounts, String source,List<String> userIds){
        int n = userIds.size();
        User currUser = findUser(source);
        for(int i=0;i<n;i++){
            String owesTo = userIds.get(i);
            Double owesamount = amounts.get(i);
            if(owesTo!=source){
                User sourceUser = findUser(owesTo);
                int sourceIndex = userMap.get(sourceUser);
                int destIndex = userMap.get(currUser);
                owes[sourceIndex][destIndex] += owesamount;
            }
        }
        normalise();
    }
    public void percentSplit(Double amount, List<Integer> percents, String sourceUserId,List<String> userIds){
        int n = userIds.size();
        User currUser = findUser(sourceUserId);
        for(int i=0;i<n;i++){
            String owesTo = userIds.get(i);

            Double owesamount = (double) amount*percents.get(i)/100;
            if(owesTo!=sourceUserId) {
                User sourceUser = findUser(owesTo);
                int sourceIndex = userMap.get(sourceUser);
                int destIndex = userMap.get(currUser);
                owes[sourceIndex][destIndex] += owesamount;
            }

        }
        normalise();
    }
    private void normalise(){
        for(int i=0;i<userCount;i++){
            for(int j=i+1;j<userCount;j++){
                if(i!=j && owes[i][j]>0 && owes[j][i]>0 && owes[i][j]>=owes[j][i]){
                    owes[i][j] -= owes[j][i];
                    owes[j][i] = 0;
                }
                if(i!=j && owes[i][j]>0 && owes[j][i]>0 && owes[i][j]<owes[j][i]){
                    owes[j][i] -= owes[i][j];
                    owes[i][j] = 0;
                }
            }
        }
    }
    private User findUser(String uid){
        User res = null;
        for(User u:allUsers){
            //System.out.println(u.getUserId());
            if(u.getUserId().equals(uid))
            {
                res = u;
                break;
            }
        }
        return res;
    }
    public void showStatus(){
        boolean flag = false;
        for(int i=0;i<userCount;i++){
            for(int j=0;j<userCount;j++){
                if(i!=j && owes[i][j]>0){
                    User giver = reverseMap.get(j);
                    User taker = reverseMap.get(i);
                    flag = true;
                    System.out.println(taker.getUserName()+" owes "+giver.getUserName()+": "+owes[i][j]);
                }
            }
        }
        if(!flag)
            System.out.println("No balance");
    }
    public void showStatusFor(String userId){
        User currUser = findUser(userId);
        int index = userMap.get(currUser);
        boolean flag = false;
        for(int j=0;j<userCount;j++){
            if(j!=index && owes[index][j]>0){
                User giver = reverseMap.get(j);
                User taker = currUser;
                flag = true;
                System.out.println(taker.getUserName()+" owes "+giver.getUserName()+": "+owes[index][j]);
            }
        }
        if(!flag)
            System.out.println("No balance");
    }
}
