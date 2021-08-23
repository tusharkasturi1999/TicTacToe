/**
 * @author tushar.kasturi_ymedi
 *
 */

public class TicTacToeGame {

	private static char[] board = new char[10];

	/**
	 * This method is used to create board and initialize it
	 *
	 *
	 */

	public static void createBoard() {

		for (int i = 1; i < board.length; i++) {
			board[i] = ' ';
		}
	}

	public static void main(String[] args) {

		
		System.out.println("Welcome to Tic Tac Toe \n");
		createBoard();

	}
}