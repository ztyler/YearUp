import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class LifeGUI {

	static int _x;
	static int _y;
	static GameLogic _logic;
	static Thread _continuous;
	static JButton[][] _grid;
	static Color _alive = new Color(30, 200, 30);
	
	JFrame frame;
	JPanel gridPanel, controlPanel;
	JButton btnStart, btnStep, btnStop;
	private JMenuBar menuBar;
	private JMenu mnPresets;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LifeGUI window = new LifeGUI(35, 35);
					_logic = new GameLogic();
					_continuous = new Thread(_logic);
					
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public LifeGUI(int y, int x) {
		_y = y;
		_x = x;
		_grid = new JButton[_y][_x];
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//create grid
		gridPanel = new JPanel();
		frame.getContentPane().add(gridPanel, BorderLayout.CENTER);
		if (_x != 0) {
			gridPanel.setLayout(new GridLayout(_y, _x, 0, 0));
		}
		else {
			gridPanel.setLayout(new GridLayout(25, 25, 0, 0));
		}
		
		for (int y = 0; y < _grid.length; y++) {
			for (int x = 0; x < _grid[y].length; x++) {
				
				_grid[y][x] = new JButton();
				setGridBtn(_grid[y][x]);
				gridPanel.add(_grid[y][x]);
				
			}
		}
		
		//create control panel
		controlPanel = new JPanel();
		frame.getContentPane().add(controlPanel, BorderLayout.SOUTH);
		controlPanel.setLayout(new GridLayout(0, 3, 0, 0));
		
		//populate control panel with buttons
		btnStep = new JButton("Step");
		btnStep.setEnabled(false);
		btnStep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				_logic.newGeneration();
			}
		});
		
		btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				enableGrid(false);
				_continuous.start();
			}
		});
		
		btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				_logic.keepPlaying = false;
				btnStep.setEnabled(true);
			}
		});
		
		controlPanel.add(btnStart);
		controlPanel.add(btnStep);
		controlPanel.add(btnStop);
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mnPresets = new JMenu("Presets");
		menuBar.add(mnPresets);
	}
	
	private void setGridBtn(JButton btn) {
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn.setEnabled(false);
				btn.setBackground(_alive);
			}
		});
	}
	
	private void setGridSize(int y, int x) {
		gridPanel.setLayout(new GridLayout(y, x, 0, 0));
	}
	
	private static void enableGrid(boolean option) {
		for (int y = 0; y < _grid.length; y++)
			for (int x = 0; x < _grid[y].length; x++)
				_grid[y][x].setEnabled(option);
	}
}
