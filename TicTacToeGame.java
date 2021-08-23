
import java.util.*;

/**
 * @author tushar.kasturi_ymedi
 *
 */
public class TicTacToeGame {

	private static char[] board = new char[10];
	private static char playerInput;
	private static char player;
	private static char computer;
	public static final Scanner sc = new Scanner(System.in);

	/**
	 * This method is used to create board and initialize it
	 *
	 */

	public static void createBoard() {

		for (int i = 1; i < board.length; i++) {
			board[i] = ' ';
		}
	}

	public static void playerChoice() {
		System.out.println("Choose 'X' or 'O' ");
		playerInput = sc.next().charAt(0);
		if (playerInput == 'X') {
			player = playerInput;
			computer = 'O';
		} else {
			player = playerInput;
			computer = 'X';
		}

	}
	
	public static void showBoard() {
		System.out.println("\n "+board[1]+" | "+board[2]+" | "+board[3]);
		System.out.println("___|___|___");
		System.out.println(" "+board[4]+" | "+board[5]+" | "+board[6]);
		System.out.println("___|___|___");
		System.out.println(" "+board[7]+" | "+board[8]+" | "+board[9]);
		System.out.println("   |   |   \n");
	}

	public static void main(String[] args) {

		System.out.println("Welcome to Tic Tac Toe \n");
		createBoard();
		playerChoice();
		showBoard();
	}
}