import java.awt.Color;
import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

import java.util.ArrayList;
import java.util.List;



public class LifeGUI {

	private static int _x = 25;
	private static int _y = 25;
	private static boolean _keepPlaying = true;
	
	private JFrame frame;
	private JButton[][] grid = new JButton[_y][_x];
	private Color alive = new Color(30, 200, 30);
	
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
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton startBtn = new JButton("Start");
		panel_1.add(startBtn);
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				_keepPlaying = false;
				
			}
		});
		panel_1.add(btnStop);
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				startGame();
				
			}
		});
		
		JPanel body = new JPanel();
		frame.getContentPane().add(body, BorderLayout.CENTER);
		body.setLayout(new GridLayout(_y, _x, 0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnPresets = new JMenu("Presets");
		menuBar.add(mnPresets);
		
		JMenuItem mntmTest = new JMenuItem("Test");
		mnPresets.add(mntmTest);
		
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
				btn.setBackground(alive);
				
			}
		});
		
	}
	
	private void startGame() {
		
		for (int y = 0; y < grid.length; y++)
			for (int x = 0; x < grid[y].length; x++)
				grid[y][x].setEnabled(false);
		
		List<JButton> birth = new ArrayList<JButton>();
		List<JButton> death = new ArrayList<JButton>();
		
		for (int y = 0; y < grid.length; y++) {
			for (int x = 0; x < grid[y].length; x++) {
				
				int liveNeighbors = 0;
				
				for (int i = -1; i < 2; i++) {
					for (int n = -1; n < 2; n++) {
						if (n == 0 && i == 0) continue;
						
						JButton btnCheck = null;
						
						try {
							btnCheck = grid[y - i][x - n];
						}
						catch (ArrayIndexOutOfBoundsException e) {
							continue;
						}
						
						if (btnCheck.getBackground().equals(alive)) {
							liveNeighbors++;
						}
						
					}
					
				}
					
				if ((liveNeighbors >= 2 && liveNeighbors <= 3)) {
						
					birth.add(grid[y][x]);
					
				}
				else {
					
					death.add(grid[y][x]);
					
				}
				
			}
			
		}
		
		for (JButton btn : birth) {
			
			btn.setBackground(alive);
			
		}
		
		for (JButton btn : death) {
			
			btn.setBackground(null);
			
		}
		
	}
	
}
