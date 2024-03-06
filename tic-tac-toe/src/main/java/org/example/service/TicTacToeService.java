package org.example.service;

import org.example.model.Board;
import org.example.model.User;

import java.util.List;
import java.util.Scanner;

public class TicTacToeService {
    private Board board;
    private List<User> users;
    private Integer currentPlayer;
    private Scanner sc;
    public TicTacToeService(Board board, List<User> users, Scanner sc){
        this.board = board;
        this.users = users;
        this.currentPlayer = 0;
        this.sc = sc;
    }
    public void start(){
        int i,j;
        while(true) {
            board.print();
            System.out.println("turn for player " + users.get(currentPlayer).getId());
            System.out.println("enter x y: ");
            i = sc.nextInt();
            j = sc.nextInt();
            while(!Validate.isValid(board,i,j)){
                System.out.println("invalid input");
                System.out.println("enter x y: ");
                i = sc.nextInt();
                j = sc.nextInt();
            }
            board.put(i,j,users.get(currentPlayer));
            String[][] currBoard = board.getBoard();
            String currSymbol = users.get(currentPlayer).getSymbol();
            if(isWinner(currSymbol,board.getBoard(),i,j,board.getSize())){
                board.print();
                System.out.println("player "+users.get(currentPlayer).getId()+" with symbol "+currSymbol+" is WINNER !");
                return;
            }
            currentPlayer = currentPlayer^1;
            if(board.isFull()){
                System.out.println("Game is draw!");
                return;
            }
        }
    }
    private boolean isWinner(String sybol,String[][] board, int i, int j,int n){
        boolean rowFlag = true, colFlag = true, leftDiagonalFlag = true, rightDiagonalFlag = true;
        for(int p=0;p<n;p++){
            if(!board[i][p].equals(sybol)) {
                rowFlag = false;
                break;
            }
        }
        for(int p=0;p<n;p++){
            if(!board[p][j].equals(sybol)) {
                colFlag = false;
                break;
            }
        }

        for(int p=0,q=0;p<n;p++,q++){
            if(!board[p][q].equals(sybol)) {
                leftDiagonalFlag = false;
                break;
            }
        }
        for(int p=0,q=n-1;p<n;p++,q--){
            if(!board[p][q].equals(sybol)) {
                rightDiagonalFlag = false;
                break;
            }
        }
        return rowFlag || colFlag || leftDiagonalFlag || rightDiagonalFlag;
    }
}
