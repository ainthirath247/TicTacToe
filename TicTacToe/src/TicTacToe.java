import java.util.Scanner;

public class TicTacToe{
	static String[] boardValues = new String[9];
	static int moves;
	
	public static void main(String[] args) {
		initializeBoard();
		gameplay();
	}
	
	static void initializeBoard() {
		for(int i=0; i<boardValues.length;i++) {
			boardValues[i] = Integer.toString(i+1);
		}
		System.out.println("|" + boardValues[0] + "|" + boardValues[1] + "|" + boardValues[2] + "|" );
		System.out.println("|" + boardValues[3] + "|" + boardValues[4] + "|" + boardValues[5] + "|" );
		System.out.println("|" + boardValues[6] + "|" + boardValues[7] + "|" + boardValues[8] + "|" );
	}
	
	static void gameplay() {
		do {
			if(moves>8) {
				System.out.println("Draw!!!");
				break;
			}
			if(moves%2==0) {
				System.out.println("It is X's turn. Enter a number corresponding to the spot you would like to fill!");
				Scanner choiceObj = new Scanner(System.in);
				int choice_num = choiceObj.nextInt();
				boardValues[choice_num-1] = "X";
				System.out.println("You chose to fill spot " + choice_num + "!" + "\n");
			} else {
				System.out.println("It is O's turn. Enter a number corresponding to the spot you would like to fill!");
				Scanner choiceObj = new Scanner(System.in);
				int choice_num = choiceObj.nextInt();
				boardValues[choice_num-1] = "O";
				System.out.println("You chose to fill spot " + choice_num + "!" + "\n");
			}
			
			moves++;
			
			System.out.println("Here is the current state of the game board:" + "\n");
			System.out.println("|" + boardValues[0] + "|" + boardValues[1] + "|" + boardValues[2] + "|" );
			System.out.println("|" + boardValues[3] + "|" + boardValues[4] + "|" + boardValues[5] + "|" );
			System.out.println("|" + boardValues[6] + "|" + boardValues[7] + "|" + boardValues[8] + "|" + "\n" );
		} while(checkWinner() != true);
		
	}
	
	static boolean checkWinner() {
		for(int i=0; i<8;i++) {
			String lineCheck = "";
			switch(i) {
				case 0:
					lineCheck = boardValues[0] + boardValues[1] + boardValues[2];
					break;
				case 1:
					lineCheck = boardValues[3] + boardValues[4] + boardValues[5];
					break;
				case 2:
					lineCheck = boardValues[6] + boardValues[7] + boardValues[8]; 
					break;
				case 3:
					lineCheck = boardValues[0] + boardValues[3] + boardValues[6]; 
					break;
				case 4:
					lineCheck = boardValues[1] + boardValues[4] + boardValues[7]; 
					break;
				case 5:
					lineCheck = boardValues[2] + boardValues[5] + boardValues[8]; 
					break;
				case 6:
					lineCheck = boardValues[0] + boardValues[4] + boardValues[8];
					break;
				case 7:
					lineCheck = boardValues[2] + boardValues[4] + boardValues[6]; 
					break;
			}
			
			if(lineCheck.equals("XXX")) {
				System.out.println("X Wins!!!");
				return true;
			}
			
			if(lineCheck.equals("OOO")) {
				System.out.println("O Wins!!!");
				return true;
			}
		}
		return false;
	}
}
