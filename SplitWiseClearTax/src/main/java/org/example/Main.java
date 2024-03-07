package org.example;

import org.example.repository.BalanceRepo;
import org.example.repository.UserRepo;
import org.example.service.SplitWiseService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        UserRepo userRepo = new UserRepo();
        BalanceRepo balanceRepo = new BalanceRepo();
        SplitWiseService splitWiseService = new SplitWiseService(userRepo,balanceRepo);
        Scanner sc = new Scanner(System.in);

        while(true){
            String ip = sc.nextLine();
            String[] tokens = ip.split(" ");
            String operation = tokens[0];
            if(operation.equals("register_user")){
                String uid = tokens[1];
                String name = tokens[2];
                splitWiseService.registerUser(uid,name);
            }
            else if(operation.equals("add_expense")){
                String sourceUserId = tokens[1];
                Double amount = Double.parseDouble(tokens[3]);
                String innerOp = tokens[5];
                List<String> destinationUserIds = new ArrayList<>();
                destinationUserIds.add(tokens[tokens.length-1]);
                if(innerOp.equals("EQUAL")){
                    splitWiseService.SplitEqual(amount,sourceUserId,destinationUserIds);
                }
                else if(innerOp.equals("EXACT")){
                    splitWiseService.SplitExact(sourceUserId,tokens[tokens.length-1],amount);
                }
                else if(innerOp.equals("PERCENT")){
                    splitWiseService.SplitPercent(sourceUserId,tokens[tokens.length-1],amount, Double.parseDouble(tokens[tokens.length-2]));
                }
            }
            else if(operation.equals("show_all_balance")){
                splitWiseService.showAllBalance(tokens[1]);
            }
        }
        //System.out.println("Hello world!");
    }
}