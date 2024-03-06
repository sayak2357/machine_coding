package org.example.model;

public class Board {
    private String[][] board;
    private Integer n;
    private Integer filled;
    public Board(Integer n){
        board = new String[n][n];
        this.n = n;
        this.filled = 0;
        fill();
    }
    public String[][] getBoard(){
        return this.board;
    }
    public Integer getSize(){
        return this.n;
    }
    public String getValue(int i, int j){
        return board[i][j];
    }
    private void fill(){
        for(int i=0;i<this.n;i++){
            for(int j=0;j<this.n;j++) {
                board[i][j] = Symbol.BLANK;
            }
        }
    }
    public void put(int i, int j, User u){
        board[i][j] = u.getSymbol();
        this.filled++;
    }

    public void print(){
        for(int i=(n-1);i>=0;i--){
            for(int j=0;j<n;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public boolean isFull(){
        return filled==(n*n);
    }
}
