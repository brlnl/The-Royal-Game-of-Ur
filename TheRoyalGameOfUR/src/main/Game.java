package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game extends JFrame {
	
	private JPanel mainPanel;
    private JPanel gamePanel;
    private JButton rollDiceButton;
    private JLabel[][] board;

	private int currentPlayer;
	private boolean gameOver;
	
	public Game() {
		setTitle("Das Königliche Spiel von Ur");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        gamePanel = new JPanel();
        rollDiceButton = new JButton("Würfeln");
        board = new JLabel[8][3]; // Example board size

        mainPanel.setLayout(new BorderLayout());
        gamePanel.setLayout(new GridLayout(8, 3)); // Example grid layout

        initializeBoard();

        mainPanel.add(gamePanel, BorderLayout.CENTER);
        mainPanel.add(rollDiceButton, BorderLayout.SOUTH);

        add(mainPanel);

        rollDiceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
				MainClass mainClass = new MainClass();
				mainClass.rollDice();
            }
        });

        setVisible(true);
	}
	
	private void initializeBoard() {
		for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 3; j++) {
                JLabel label = new JLabel();
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setVerticalAlignment(JLabel.CENTER);
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                board[i][j] = label;
                gamePanel.add(label);
            }
        }
        
        // Füge einen MouseListener hinzu, um auf Klickereignisse zu reagieren
        gamePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Berechne die geklickte Zelle basierend auf den Mauskoordinaten
                int cellWidth = gamePanel.getWidth() / 3;
                int cellHeight = gamePanel.getHeight() / 8;
                int row = e.getY() / cellHeight;
                int col = e.getX() / cellWidth;
                movePiece(row, col);
            }
        });
	}
	   void movePiece(int row, int col) {
		   System.out.println("Move piece at row: " + row + ", col: " + col);

		    // Überprüfen, ob das Spiel bereits vorbei ist
		    if (gameOver) {
		        return;
		    }

		    // Überprüfen, ob das Feld gültig ist
		    if (row < 0 || row >= 8 || col < 0 || col >= 3) {
		        return;
		    }

		    // Überprüfen, ob das Feld leer ist
		    if (!board[row][col].getText().isEmpty()) {
		        return;
		    }

		    // Bewege den Spielstein des aktuellen Spielers auf das ausgewählte Feld
		    if (currentPlayer == 1) {
		        board[row][col].setText("P1");
		    } else {
		        board[row][col].setText("P2");
		    }

		    // Wechsle den Spieler
		    currentPlayer = (currentPlayer == 1) ? 2 : 1;

		    // Überprüfen auf Gewinnbedingungen
		    // ...

		    // Aktualisierung der Anzeige des aktuellen Spielers oder des Gewinners
		    // ...
		}
}

