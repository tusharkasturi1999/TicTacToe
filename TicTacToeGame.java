
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
	private static int location;
	private static int coinToss;
	public static final Scanner sc = new Scanner(System.in);
	public static final Random rand = new Random();

	// This method is used to create board and initialize it
	public static void createBoard() {

		for (int index = 1; index < board.length; index++) {
			board[index] = ' ';
		}
	}

	// This method is used for player to select 'X' or 'O'
	public static void playerChoice() {
		System.out.println("Choose 'X' or 'O' ");
		playerInput = sc.next().charAt(0);
		sc.nextLine();
		if (playerInput == 'X') {
			player = playerInput;
			computer = 'O';
		} else {
			player = playerInput;
			computer = 'X';
		}

	}

	// This method is used to display board
	public static void showBoard() {
		System.out.println("\n " + board[1] + " | " + board[2] + " | " + board[3]);
		System.out.println("___|___|___");
		System.out.println(" " + board[4] + " | " + board[5] + " | " + board[6]);
		System.out.println("___|___|___");
		System.out.println(" " + board[7] + " | " + board[8] + " | " + board[9]);
		System.out.println("   |   |   \n");
	}

	// This method is used for player to select location
	public static void playerMove() {
		System.out.println("Enter Location 1-9 to Make Move");
		location = sc.nextInt();
		sc.nextLine();
		if (isEmpty() && location < 10 && location > 0) {
			board[location] = player;
			showBoard();
		} else {
			System.out.println("Invalid Choice");
		}
	}

	// This method is used check whether location is empty or not
	public static boolean isEmpty() {
		if (board[location] == ' ') {
			return true;
		} else {
			return false;
		}
	}

	// This method is used for toss and who plays first
	public static void toss() {
		coinToss = rand.nextInt(2) + 1;
		System.out.println("Choose 1 for Heads or 2 for Tails");
		int coinSelect = sc.nextInt();
		if (coinSelect == coinToss) {
			System.out.println("Toss Won, Player plays first:");
		} else {
			System.out.println("Toss Lost, Computer plays first:");
		}
	}

	public static void main(String[] args) {

		System.out.println("Welcome to Tic Tac Toe \n");
		createBoard();
		playerChoice();
		showBoard();
		playerMove();
		toss();
	}
}