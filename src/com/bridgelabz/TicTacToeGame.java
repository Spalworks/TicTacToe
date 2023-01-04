package com.bridgelabz;

import java.util.Scanner;

public class TicTacToeGame {
	
	static char [] board = new char[10];
	static char playerSymbol;
	static char computerSymbol;

	
	static void createBoard() {
		for(int i=1; i<board.length; i++) {
			board[i] = ' ';
		}
		System.out.println("board is created");
	}
	
	static void assignSymbol(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose your letter (X or O): ");
        playerSymbol = sc.next().charAt(0);
        if(playerSymbol == 'X' || playerSymbol == 'x'){
            computerSymbol = 'O';
        }else if(playerSymbol == 'O' || playerSymbol == 'o'){
            computerSymbol = 'X';
        }else{
            System.out.println("Invalid input");
            assignSymbol();
        }
    }
	
	static void showBoard(){
        System.out.println(board[1] +" | "+ board[2] + " | " + board[3]);
        System.out.println("----------");
        System.out.println(board[4] +" | "+ board[5] + " | " + board[6]);
        System.out.println("----------");
        System.out.println(board[7] +" | "+ board[8] + " | " + board[9]);
        System.out.println("********************************************");
    }
	
	
	public static void main(String[] args) {
		createBoard();
		assignSymbol();
		showBoard();
	}
}
