import java.awt.Color;
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

	private static int _x = 50;
	private static int _y = 50;
	private static boolean _keepPlaying = true;
	
	JFrame frame;
	JButton[][] grid = new JButton[_y][_x];
	
	static Color alive = new Color(30, 200, 30);
	
	public LifeGUI() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel controlPanel = new JPanel();
		frame.getContentPane().add(controlPanel, BorderLayout.SOUTH);
		controlPanel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton startBtn = new JButton("Start");
		controlPanel.add(startBtn);
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
			}
		});
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				_keepPlaying = false;
				
			}
		});
		
		JButton btnStep = new JButton("Step");
		btnStep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				GameLogic.newGeneration();
				
			}
		});
		controlPanel.add(btnStep);
		controlPanel.add(btnStop);
		
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
	
	public void setGridBtn(JButton btn) {
		
		btn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				btn.setEnabled(false);
				btn.setBackground(alive);
				
			}
		});
		
	}
	
	
	
}
