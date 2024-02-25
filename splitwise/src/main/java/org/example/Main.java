package org.example;

import org.example.model.User;
import org.example.service.SplitWise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import static org.example.common.Constants.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
//        // to see how IntelliJ IDEA suggests fixing it.
//        System.out.printf("Hello and welcome!");
//
//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.println("i = " + i);
//        }
        User user1 = new User("u1","User1");
        User user2 = new User("u2","User2");
        User user3 = new User("u3","User3");
        User user4 = new User("u4","User4");
        List<User> setOfUsers = new ArrayList<>();
        setOfUsers.add(user1);
        setOfUsers.add(user2);
        setOfUsers.add(user3);
        setOfUsers.add(user4);

        SplitWise service = new SplitWise(setOfUsers);
        Scanner sc = new Scanner(System.in);
        while(true){
            String ip = sc.nextLine();
            String[] tuples = ip.split(" ");
            //printStringArray(tuples);
            int n = tuples.length;
            if(n>2){
                String sourceUid = tuples[1];
                Double amount = Double.parseDouble(tuples[2]);
                List<String> uids = new ArrayList<>();
                Integer count = Integer.parseInt(tuples[3]);
                for(int i=0;i<count;i++){
                    uids.add(tuples[4+i]);
                }
                String ops = tuples[4+count];
                if(ops.equals("EQUAL"))
                    service.equalSplit(amount,sourceUid,uids);
                else if(ops.equals("EXACT")){
                    List<Double> amounts = new ArrayList<>();
                    for(int i=0;i<count;i++){
                        amounts.add(Double.parseDouble(tuples[5+count+i]));
                    }
                    service.exactSplit(amount,amounts,sourceUid,uids);
                }
                else if(ops.equals("PERCENT")){
                    List<Integer> percents = new ArrayList<>();
                    for(int i=0;i<count;i++){
                        percents.add(Integer.parseInt(tuples[5+count+i]));
                    }
                    service.percentSplit(amount,percents,sourceUid,uids);
                }
            }
            else if(n==2)
                service.showStatusFor(tuples[1]);
            else
                service.showStatus();
        }
    }
    private static void printStringArray(String[] ip){
        StringBuilder res = new StringBuilder();
        for(String word:ip) {
            res.append(word);
            res.append(WHITE_SPACE);
        }
        System.out.println(res);
    }
}