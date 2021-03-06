import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.GridLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class TicTacToeGUI {
	
	static int size = 3;
	
	private JFrame frame;
	private static JButton[][] grid = new JButton[size][size];
	private static boolean redTurn = true;
	private static int moves = 0;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicTacToeGUI window = new TicTacToeGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TicTacToeGUI() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(size, size));
		
		for (int y = 0; y < grid.length; y++) {
			
			final int yFinal = y;
			
			for (int x = 0; x < grid[y].length; x++) {
				
				final int xFinal = x;
				
				grid[y][x] = new JButton();
				grid[y][x].setFont(new Font("OCR A Extended", Font.PLAIN, 36));
				grid[y][x].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (redTurn) {
							grid[yFinal][xFinal].setText("X");
							grid[yFinal][xFinal].setBackground(new Color(200, 30, 30));
							redTurn = false;
						}
						else {
							grid[yFinal][xFinal].setText("O");
							grid[yFinal][xFinal].setBackground(new Color(30, 30, 200));
							redTurn = true;
						}
						grid[yFinal][xFinal].setEnabled(false);
						moves++;
						checkWin();
					}
				});
				frame.add(grid[y][x]);
			}	
		}
	}
	
	static void checkWin() {
		boolean win = false;
		
		if (moves > 4) {
			
			for (int num = 0; num < grid.length; num++) {
				
				int half = (grid.length - 1) / 2;
				
				if (!grid[num][half].isEnabled()) {
					
					if ((grid[num][half].getText() == grid[num][half - 1].getText()) 
							&& (grid[num][half].getText() == grid[num][half + 1].getText())) {
						
						grid[num][half].setBackground(new Color(250, 170, 0));
						grid[num][half - 1].setBackground(new Color(250, 170, 0));
						grid[num][half + 1].setBackground(new Color(250, 170, 0));
						win = true;
						break;
						
					}
				}
				if (!grid[half][num].isEnabled()) {
					if (((grid[half][num].getText() == grid[half - 1][num].getText()) 
							&& (grid[half][num].getText() == grid[half + 1][num].getText()))) {
						
						grid[half][num].setBackground(new Color(250, 170, 0));
						grid[half - 1][num].setBackground(new Color(250, 170, 0));
						grid[half + 1][num].setBackground(new Color(250, 170, 0));
						win = true;
						break;
					}
					
				}
				
			}
			
			if (!win) {
				
				int half = (grid.length - 1) / 2;
				
				if (!grid[half][half].isEnabled()) {
					
					if ((grid[half][half].getText() == grid[half - 1][half - 1].getText()) 
							&& (grid[half][half].getText() == grid[half + 1][half + 1].getText())) {
						
						grid[half][half].setBackground(new Color(250, 170, 0));
						grid[half - 1][half - 1].setBackground(new Color(250, 170, 0));
						grid[half + 1][half + 1].setBackground(new Color(250, 170, 0));
						win = true;
						
					}
					else if (((grid[half][half].getText() == grid[half - 1][half + 1].getText())
							&& (grid[half][half].getText() == grid[half + 1][half - 1].getText()))) {
						
						grid[half][half].setBackground(new Color(250, 170, 0));
						grid[half - 1][half + 1].setBackground(new Color(250, 170, 0));
						grid[half + 1][half - 1].setBackground(new Color(250, 170, 0));
						win = true;
					}
					
				}
				
			}
			
			if (win) {
				String winner = (redTurn == false) ? "Red" : "Blue"; 
				JOptionPane.showMessageDialog(null, winner + " wins!");
				System.exit(0);
			}
			
			if (moves == size * size) {
				JOptionPane.showMessageDialog(null, "Everybody loses!");
				System.exit(0);
			}
			
		}
		
	}
	
}
