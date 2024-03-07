package org.example.service;

import org.example.model.User;
import org.example.repository.BalanceRepo;
import org.example.repository.UserRepo;

import java.util.List;

public class SplitWiseService {
    private UserRepo userRepo;
    private BalanceRepo balanceRepo;

    public SplitWiseService(UserRepo userRepo, BalanceRepo balanceRepo){
        this.userRepo = userRepo;
        this.balanceRepo = balanceRepo;
    }
    public void registerUser(String userId, String name){
        User u = new User(userId,name);
        userRepo.addUser(u);
    }
    public void SplitEqual(Double amount,String spenderUserId, List<String> userIds){
        int n = userIds.size()+1;
        User giver = userRepo.findById(spenderUserId);
        Double perHeadAmount = amount/n;
        for(String userId:userIds){
            User taker = userRepo.findById(userId);
            balanceRepo.AOwesToB(taker,giver,perHeadAmount);
        }
    }
    public void SplitExact(String spenderUserId, String beneficiaryUserId, Double amount){
        User giver = userRepo.findById(spenderUserId);
        User taker = userRepo.findById(beneficiaryUserId);
        balanceRepo.AOwesToB(taker,giver,amount);

    }
    public void SplitPercent(String spenderUserId, String beneficiaryUserId, Double totalAmount, Double percent){
        Double owedAmount = totalAmount*percent/100;
        User giver = userRepo.findById(spenderUserId);
        User taker = userRepo.findById(beneficiaryUserId);
        balanceRepo.AOwesToB(taker,giver,owedAmount);

    }
    public void showAllBalance(String userId){
        List<User> users = userRepo.getAll();
        for(User u:users){
            String uid = u.getUserId();
            if(!uid.equals(userId)){
                Double amount = balanceRepo.queryAOwesB(userId,uid);
                if(amount>0){
                    System.out.println(userId+" owes"+uid+" "+amount);
                }

                Double revAmount = balanceRepo.queryAOwesB(uid,userId);
                if(revAmount>0){
                    System.out.println(uid+" owes "+userId+" "+revAmount);
                }
            }
        }
    }
}
