
/**
 * @author tushar.kasturi_ymedi
 *
 */
import java.util.*;

public class TicTacToeGame {

	private static char[] board = new char[10];
	private static char playerInput;
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
	}

	public static void main(String[] args) {

		System.out.println("Welcome to Tic Tac Toe \n");
		createBoard();
		playerChoice();
	}
}