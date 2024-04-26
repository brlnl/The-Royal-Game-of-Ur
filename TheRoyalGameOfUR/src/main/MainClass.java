package main;

public class MainClass {
	public static void main(String[] args) {
		
		new Game();
		// Erstelle ein 2D-Array für das Spielbrett
        char[][] board = new char[8][3];

        // Initialisiere das Spielbrett
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 3; col++) {
            	board[row][col] = '■';
            }
        }

        // Setze die markierten Felder
        board[1][0] = 'x'; // Trennlinie
        board[7][0] = 'x'; // Trennlinie
        board[1][2] = 'x';
        board[2][0] = ' '; // Markiertes Feld
        board[4][1] = 'X'; // Markiertes Feld
        board[2][2] = ' '; // Markiertes Feld
        board[7][2] = 'X';
        board[3][0] = ' ';
        board[3][2] = ' ';
        

        // Zeige das Spielbrett an
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
MainClass mainClass = new MainClass();
mainClass.rollDice();
	}
	void rollDice() {
	    // Simulate rolling the dice
	    int diceResult = (int) (Math.random() * 4) + 1;

	    // Update the game state based on the dice result
	    // For simplicity, let's just print the result for now
	    System.out.println("Dice rolled: " + diceResult);

	    // You can continue implementing the game logic here, such as moving the player's pieces,
	    // checking for special conditions based on the dice result, etc.
	}


}
