
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
	private static int playMore;
	private static int playerLocation;
	private static int location;
	private static int coinToss;
	private static boolean tossWin;
	private static boolean didWin = false;
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
			System.out.println("Invalid input, You have been assigned 'O'");
			player = 'O';
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

	// This method is used for toss and who plays first
	public static void toss() {
		coinToss = rand.nextInt(2) + 1;
		System.out.println("Choose 1 for Heads or 2 for Tails");
		int coinSelect = sc.nextInt();
		if (coinSelect == coinToss) {
			System.out.println("Toss Won, Player plays first:");
			tossWin = true;
		} else {
			System.out.println("Toss Lost, Computer plays first:");
			tossWin = false;
		}
	}

	// This method is used check whether location is empty or not
	public static boolean isEmpty(int location) {
		return board[location] == ' ';
	}

	// This method is used for player to select location
	public static void playerMove() {
		System.out.println("Enter Location 1-9 to Make Move");
		while (true) {
			playerLocation = sc.nextInt();
			sc.nextLine();
			location = playerLocation;
			if (isEmpty(location) && playerLocation < 10 && playerLocation > 0) {
				board[playerLocation] = player;
				showBoard();
				break;
			} else {
				System.out.println("Invalid Choice, try again");
			}
		}
	}

	// This method defines the computer's move
	public static void computerMove() {
		do {
			occupyCorner();
			if (occupyCenter()) {
			}
			if (occupyOther()) {
			}
			if (computerWinMotive()) {
			}
		} while (!isEmpty(location));

		board[location] = computer;
		showBoard();
	}

	// This method is used to occupy corner if noone is winning
	public static void occupyCorner() {

		int[] corners = { 1, 3, 7, 9 };
		int corner = rand.nextInt(3);
		location = corners[corner];
	}

	// This method is used to occupy center if no one is winning
	public static boolean occupyCenter() {
		if (board[1] != ' ' && board[3] != ' ' && board[7] != ' ' && board[9] != ' ') {
			if (isEmpty(5)) {
				location = 5;
				return true;
			}
		}
		return false;
	}

	// This method is used to occupy other positions if no one is winning and no
	// corner or center is available
	public static boolean occupyOther() {
		if (board[1] != ' ' && board[3] != ' ' && board[7] != ' ' && board[9] != ' ' && board[5] != ' ') {
			int[] notCorners = { 2, 4, 6, 8 };
			int notCorner = rand.nextInt(3);
			if (isEmpty(notCorners[notCorner])) {
				location = notCorners[notCorner];
				return true;
			}
		}
		return false;
	}

	// This method defines the conditions for a win
	public static boolean defineWin() {
		if (didWin)
			return true;
		if ((board[1] == player && board[2] == player && board[3] == player)
				|| (board[4] == player && board[5] == player && board[6] == player)
				|| (board[7] == player && board[8] == player && board[9] == player)
				|| (board[1] == player && board[4] == player && board[7] == player)
				|| (board[2] == player && board[5] == player && board[8] == player)
				|| (board[3] == player && board[6] == player && board[9] == player)
				|| (board[1] == player && board[5] == player && board[9] == player)
				|| (board[3] == player && board[5] == player && board[7] == player)) {
			System.out.println("Player 1 WINS");
			didWin = true;
			return true;
		}
		if ((board[1] == computer && board[2] == computer && board[3] == computer)
				|| (board[4] == computer && board[5] == computer && board[6] == computer)
				|| (board[7] == computer && board[8] == computer && board[9] == computer)
				|| (board[1] == computer && board[4] == computer && board[7] == computer)
				|| (board[2] == computer && board[5] == computer && board[8] == computer)
				|| (board[3] == computer && board[6] == computer && board[9] == computer)
				|| (board[1] == computer && board[5] == computer && board[9] == computer)
				|| (board[3] == computer && board[5] == computer && board[7] == computer)) {
			System.out.println("Computer WINS");
			didWin = true;
			return true;
		}
		return false;
	}

	// This method check whether the board is full or not
	public static boolean isBoardFull() {
		if ((board[1] != ' ') && (board[2] != ' ') && (board[3] != ' ') && (board[4] != ' ') && (board[5] != ' ')
				&& (board[6] != ' ') && (board[7] != ' ') && (board[8] != ' ') && (board[9] != ' ')) {

			return true;
		}
		return false;
	}

	// This method tries that the computer Wins & Blocks user from winning
	public static boolean computerWinMotive() {
		if (board[1] == computer && board[2] == computer && board[3] == ' ') {
			location = 3;
			return true;
		}
		if (board[1] == computer && board[3] == computer && board[2] == ' ') {
			location = 2;
			return true;
		}
		if (board[3] == computer && board[2] == computer && board[1] == ' ') {
			location = 1;
			return true;
		}
		if (board[4] == computer && board[5] == computer && board[6] == ' ') {
			location = 6;
			return true;
		}
		if (board[4] == computer && board[6] == computer && board[5] == ' ') {
			location = 5;
			return true;
		}
		if (board[6] == computer && board[5] == computer && board[4] == ' ') {
			location = 4;
			return true;
		}
		if (board[7] == computer && board[8] == computer && board[9] == ' ') {
			location = 9;
			return true;
		}
		if (board[7] == computer && board[9] == computer && board[8] == ' ') {
			location = 8;
			return true;
		}
		if (board[9] == computer && board[8] == computer && board[7] == ' ') {
			location = 7;
			return true;
		}
		if (board[1] == computer && board[4] == computer && board[7] == ' ') {
			location = 7;
			return true;
		}
		if (board[1] == computer && board[7] == computer && board[4] == ' ') {
			location = 4;
			return true;
		}
		if (board[7] == computer && board[4] == computer && board[1] == ' ') {
			location = 1;
			return true;
		}
		if (board[2] == computer && board[5] == computer && board[8] == ' ') {
			location = 8;
			return true;
		}
		if (board[2] == computer && board[8] == computer && board[5] == ' ') {
			location = 5;
			return true;
		}
		if (board[8] == computer && board[5] == computer && board[2] == ' ') {
			location = 2;
			return true;
		}
		if (board[3] == computer && board[6] == computer && board[9] == ' ') {
			location = 9;
			return true;
		}
		if (board[3] == computer && board[9] == computer && board[6] == ' ') {
			location = 6;
			return true;
		}
		if (board[9] == computer && board[6] == computer && board[3] == ' ') {
			location = 3;
			return true;
		}
		if (board[1] == computer && board[5] == computer && board[9] == ' ') {
			location = 9;
			return true;
		}
		if (board[1] == computer && board[9] == computer && board[5] == ' ') {
			location = 5;
			return true;
		}
		if (board[9] == computer && board[5] == computer && board[1] == ' ') {
			location = 1;
			return true;
		}
		if (board[3] == computer && board[5] == computer && board[7] == ' ') {
			location = 7;
			return true;
		}
		if (board[3] == computer && board[7] == computer && board[5] == ' ') {
			location = 5;
			return true;
		}
		if (board[7] == computer && board[5] == computer && board[3] == ' ') {
			location = 3;
			return true;
		}
		if (board[1] == player && board[2] == player && board[3] == ' ') {
			location = 3;
			return true;
		}
		if (board[1] == player && board[3] == player && board[2] == ' ') {
			location = 2;
			return true;
		}
		if (board[3] == player && board[2] == player && board[1] == ' ') {
			location = 1;
			return true;
		}
		if (board[4] == player && board[5] == player && board[6] == ' ') {
			location = 6;
			return true;
		}
		if (board[4] == player && board[6] == player && board[5] == ' ') {
			location = 5;
			return true;
		}
		if (board[6] == player && board[5] == player && board[4] == ' ') {
			location = 4;
			return true;
		}
		if (board[7] == player && board[8] == player && board[9] == ' ') {
			location = 9;
			return true;
		}
		if (board[7] == player && board[9] == player && board[8] == ' ') {
			location = 8;
			return true;
		}
		if (board[9] == player && board[8] == player && board[7] == ' ') {
			location = 7;
			return true;
		}
		if (board[1] == player && board[4] == player && board[7] == ' ') {
			location = 7;
			return true;
		}
		if (board[1] == player && board[7] == player && board[4] == ' ') {
			location = 4;
			return true;
		}
		if (board[7] == player && board[4] == player && board[1] == ' ') {
			location = 1;
			return true;
		}
		if (board[2] == player && board[5] == player && board[8] == ' ') {
			location = 8;
			return true;
		}
		if (board[2] == player && board[8] == player && board[5] == ' ') {
			location = 5;
			return true;
		}
		if (board[8] == player && board[5] == player && board[2] == ' ') {
			location = 2;
			return true;
		}
		if (board[3] == player && board[6] == player && board[9] == ' ') {
			location = 9;
			return true;
		}
		if (board[3] == player && board[9] == player && board[6] == ' ') {
			location = 6;
			return true;
		}
		if (board[9] == player && board[6] == player && board[3] == ' ') {
			location = 3;
			return true;
		}
		if (board[1] == player && board[5] == player && board[9] == ' ') {
			location = 9;
			return true;
		}
		if (board[1] == player && board[9] == player && board[5] == ' ') {
			location = 5;
			return true;
		}
		if (board[9] == player && board[5] == player && board[1] == ' ') {
			location = 1;
			return true;
		}
		if (board[3] == player && board[5] == player && board[7] == ' ') {
			location = 7;
			return true;
		}
		if (board[3] == player && board[7] == player && board[5] == ' ') {
			location = 5;
			return true;
		}
		if (board[7] == player && board[5] == player && board[3] == ' ') {
			location = 3;
			return true;
		} else
			return false;
	}

	// This method starts the game and plays till game wins or a tie
	public static void gamestart() {
		do {
			if (tossWin) {
				playerMove();
				if (!isBoardFull())
					computerMove();
			} else {
				computerMove();
				if (!isBoardFull())
					playerMove();
			}
		} while (!defineWin() && !isBoardFull());
		if (isBoardFull() && !defineWin())
			System.out.println("Its a Tie");

	}

	// This is the main method
	public static void main(String[] args) {

		System.out.println("Welcome to Tic Tac Toe \n");
		boolean check = true;
		//This loop allows user to play more than 1 game
		while(check){
			createBoard();
			playerChoice();
			showBoard();
			toss();
			gamestart();
			System.out.println("Press '1' to continue playing, '2' to exit");
			playMore = sc.nextInt();
			if(playMore ==2) {
				System.out.println("Thankyou for playing");
				System.exit(0);
			}
		}
	}
}