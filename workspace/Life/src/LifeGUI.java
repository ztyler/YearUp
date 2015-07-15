import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;



public class LifeGUI {

	private JFrame frame;
	private static int _x = 25;
	private static int _y = 25;
	private JButton[][] grid = new JButton[_y][_x];
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LifeGUI window = new LifeGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LifeGUI() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JButton startBtn = new JButton("Start");
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				startGame();
				
			}
		});
		panel.add(startBtn);
		
		JPanel body = new JPanel();
		frame.getContentPane().add(body, BorderLayout.CENTER);
		body.setLayout(new GridLayout(_y, _x, 0, 0));
		
		for (int y = 0; y < _y; y++)
			for (int x = 0; x < _x; x++) {
				
				grid[y][x] = new JButton();
				setGridBtn(grid[y][x]);
				body.add(grid[y][x]);
				
			}
		
	}
	
	private void setGridBtn(JButton btn) {
		
		btn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				btn.setEnabled(false);
				btn.setBackground(new Color(30, 200, 30));
				
			}
		});
		
	}
	
	private void startGame() {
		
		for (int y = 0; y < grid.length; y++)
			for (int x = 0; x < grid[y].length; x++)
				grid[y][x].setEnabled(false);
		
		for (int y = 0; y < grid.length; y++)
			for (int x = 0; x < grid[y].length; x++) {
				int liveNeighbors = 0;
				
				
				
			}	
		
	}

}
