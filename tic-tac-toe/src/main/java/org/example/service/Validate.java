package org.example.service;

import org.example.model.Board;
import org.example.model.Symbol;

public class Validate {
    public static boolean isValid(Board board, int i, int j){
        int n = board.getSize();
        return i>=0 && i<n && j>=0 && j<n && board.getValue(i,j).equals(Symbol.BLANK);
    }
}
