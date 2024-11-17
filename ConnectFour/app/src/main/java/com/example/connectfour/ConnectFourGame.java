package com.example.connectfour;

public class ConnectFourGame {
    int [][] board;

    public ConnectFourGame(){
        this.board = new int [7][6];
    }

    public void newGame(){
        for(int i = 0; i<7; i++){
            for(int j=0; j<6; j++){
                board[i][j] = 0;
            }
        }
    }

    public String getState(){
        StringBuilder str = new StringBuilder();

        for(int i=0; i<7; i++){
            for(int j=0; j<6; j++){
                str.append(board[i][j]);
            }
        }
        return str.toString();
    }
}
