package org.example;

import org.example.model.Board;
import org.example.model.User;
import org.example.service.TicTacToeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int n = 3;
        Board board = new Board(n);
        List<User> users = new ArrayList<>();
        User A = new User("1","X");
        User B = new User("2","O");
        users.add(A);
        users.add(B);
        Scanner sc = new Scanner(System.in);
        TicTacToeService ts = new TicTacToeService(board,users,sc);
        ts.start();
        //System.out.println("Hello world!");
    }
}