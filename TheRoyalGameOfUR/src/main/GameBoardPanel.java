package main;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class GameBoardPanel extends JPanel{

	  public GameBoardPanel() {
		  super();
	        setLayout(new GridLayout(8, 3)); // Example grid layout

	        // Add MouseListener to handle clicks on the game board
	        addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                // Calculate the clicked cell based on the mouse coordinates
	                int cellWidth = getWidth() / 3;
	                int cellHeight = getHeight() / 8;
	                int row = e.getY() / cellHeight;
	                int col = e.getX() / cellWidth;
	                System.out.println("Clicked on row: " + row + ", col: " + col);
	            }
	        });
      }
}
