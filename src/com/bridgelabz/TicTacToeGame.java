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
		System.out.println("-_-_-_-_-_-_-_-_-_-");
		System.out.println(board[1] +" | "+ board[2] + " | " + board[3]);
		System.out.println("----------");
		System.out.println(board[4] +" | "+ board[5] + " | " + board[6]);
		System.out.println("----------");
		System.out.println(board[7] +" | "+ board[8] + " | " + board[9]);
		 System.out.println("***********************************************");
	}
	static void userInput(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose the position b/w (1 to 9): ");
		int user = sc.nextInt();
		if(user > 9 || user < 1){
			System.out.println("Invalid input: ");
			userInput();
		}
		if(board[user] == ' '){
			board[user] = playerSymbol;
		}else{
			System.out.println("Its not Empty");
			userInput();
		}
		if(checkWinner(playerSymbol)){
			System.out.println("Player wins.");

		}else{
			checkDraw(playerSymbol);
			showBoard();
			System.out.println("Computers chance: ");
			computerInput();
		}
	}
	static void computerInput(){
		int computerMove = (int) (Math.random() * 9 + 1);
		if(board[computerMove] == ' '){
			board[computerMove] = computerSymbol;
		}else{
			System.out.println("Its not Empty");
			computerInput();
		}
		if(checkWinner(computerSymbol)){
			System.out.println("Computer wins.");

		}else{
			checkDraw(computerSymbol);
			showBoard();
			System.out.println("Player chance: ");
			userInput();
		}
	}
	static boolean checkWinner(char symbol) {
		if ((board[1] == symbol && board[2] == symbol && board[3] == symbol) ||
				(board[1] == symbol && board[4] == symbol && board[7] == symbol) ||
				(board[1] == symbol && board[5] == symbol && board[9] == symbol) ||
				(board[2] == symbol && board[5] == symbol && board[8] == symbol) ||
				(board[3] == symbol && board[6] == symbol && board[9] == symbol) ||
				(board[3] == symbol && board[5] == symbol && board[7] == symbol) ||
				(board[4] == symbol && board[5] == symbol && board[6] == symbol) ||
				(board[7] == symbol && board[8] == symbol && board[9] == symbol)) {
			showBoard();
			return true;
		}
		return false;
	}

	static void checkDraw(char symbol) {
		if (board[1] != ' ' && board[2] != ' ' && board[3] != ' ' && 
				board[4] != ' ' && board[5] != ' ' && board[6] != ' ' && 
				board[7] != ' ' && board[8] != ' ' && board[9] != ' ' && 
				checkWinner(symbol)==false) {

			System.out.println("OOPssss!!!!! The game ended with a Draw!!!");
			showBoard();
			System.exit(0);
		}
	}

	static void firstToStartGame() {
        int toss = (int) (Math.random() * 10) % 2;
        if (toss == 0) {
            System.out.println("Computer is starting the game.");
                computerInput();
        } else {
            System.out.println("Player is starting the game.");
            userInput();
        }
    }



	public static void main(String[] args) {
		createBoard();
		assignSymbol();
		showBoard();
		firstToStartGame();


	}

}
