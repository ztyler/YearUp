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

	private JFrame frame;
	private static JButton[][] grid = new JButton[3][3];
	private static boolean redTurn = true;
	
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
		frame.setLayout(new GridLayout(3, 3));
		
		for (int y = 0; y < grid.length; y++) {
			
			final int yFinal = y;
			
			for (int x = 0; x < grid[y].length; x++) {
				
				final int xFinal = x;
				
				grid[y][x] = new JButton();
				grid[y][x].setFont(new Font("OCR A Extended", Font.PLAIN, 36));
				grid[y][x].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (redTurn) {
							grid[yFinal][xFinal].setBackground(new Color(200, 50, 50));
							grid[yFinal][xFinal].setText("X");
							redTurn = false;
						}
						else {
							grid[yFinal][xFinal].setBackground(new Color(50, 50, 200));
							grid[yFinal][xFinal].setText("O");
							redTurn = true;
						}
						grid[yFinal][xFinal].setEnabled(false);
						checkWin();
					}
				});
				frame.add(grid[y][x]);
			}	
		}
	}
	
	static void checkWin() {
		boolean win = false;
		
		//horizontal check
		for (int i = 0; i < grid.length; i++) {
			if (grid[i][0].getText() == grid[0][1].getText() 
					&& grid[i][1].getText() == grid[i][2].getText()) {
				
				if (grid[i][0].getText() == "X" ||
						grid[i][0].getText() == "O") {
					win = true;
				}
				
			}
		}
		//vertical check
		for (int i = 0; i < grid[0].length; i++) {
			if (grid[0][i].getText() == grid[1][i].getText() 
					&& grid[1][i].getText() == grid[2][i].getText()) {
				
				if (grid[0][i].getText() == "X" ||
						grid[0][i].getText() == "O") {
					
					win = true;
				}
				
			}
		}
		//diagonal check
		if (grid[1][1].getText() == "X" ||
				grid[1][1].getText() == "O") {
			if (grid[0][0].getText() == grid[1][1].getText() 
					&& grid[1][1].getText() == grid[2][2].getText()) {
				
				win = true;
				
			}
			else if (grid[0][2].getText() == grid[1][1].getText() 
					&& grid[1][1].getText() == grid[2][0].getText()) {
				
				win = true;
				
			}
		}
		
		if (win) {
			String message;
			if (redTurn) {
				message = "O's win!";
			}
			else {
				message = "X's win!";
			}
			JOptionPane.showMessageDialog(null, message);
			System.exit(0);
		}
		
	}
	
}
