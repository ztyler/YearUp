import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;

public class LifeGUI {

	static int _x;
	static int _y;
	static GameLogic _logic;
	static Thread _game;
	static JButton[][] _grid;
	static Color _alive = new Color(30, 200, 30);
	
	JFrame frame;
	JPanel gridPanel, controlPanel, launchPanel;
	JButton btnPlay, btnStep, btnPause, btnStop, btnLaunch;
	JMenuBar menuBar;
	JMenu menuPresets;
	ButtonGroup presetsBtnGroup;
	JRadioButtonMenuItem radioDefault, radioCheckerboard;
	private JPanel panel;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LifeGUI window = new LifeGUI(40, 40);
					_logic = new GameLogic();
					
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
		
		buildMenu();
		
		buildGrid();
		
		buildCntrlPanel();
		
	}
	
	private void buildMenu() {
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		menuPresets = new JMenu("Presets");
		menuBar.add(menuPresets);
		
		presetsBtnGroup = new ButtonGroup();
		
		radioDefault = new JRadioButtonMenuItem("Default");
		menuPresets.add(radioDefault);
		presetsBtnGroup.add(radioDefault);
		
		radioCheckerboard = new JRadioButtonMenuItem("Checkerboard");
		menuPresets.add(radioCheckerboard);
		presetsBtnGroup.add(radioCheckerboard);
	}
	
	private void buildGrid() {
		gridPanel = new JPanel();
		frame.getContentPane().add(gridPanel, BorderLayout.CENTER);
		
		if (_x != 0) {
			setGridSize(_y, _x);;
		}
		else {
			setGridSize(25, 25);;
		}
		
		for (int y = 0; y < _grid.length; y++) {
			for (int x = 0; x < _grid[y].length; x++) {
				_grid[y][x] = new JButton();
				setGridBtn(_grid[y][x]);
				gridPanel.add(_grid[y][x]);
			}
		}
	}
	
	private void buildCntrlPanel() {
		
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(2, 1, 0, 0));
		
		controlPanel = new JPanel();
		panel.add(controlPanel);
		controlPanel.setLayout(new GridLayout(0, 4, 0, 0));
		
		launchPanel = new JPanel();
		panel.add(launchPanel);
		launchPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		btnPlay = new JButton("Play");
		btnStep = new JButton("Step");
		btnPause = new JButton("Pause");
		btnStop = new JButton("Stop");
		
		btnPlay.setEnabled(false);
		btnStep.setEnabled(false);
		btnPause.setEnabled(false);
		btnStop.setEnabled(false);
		
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnPlay.setEnabled(false);
				btnStep.setEnabled(false);
				btnPause.setEnabled(true);
				
				_logic.continuous = true;
			}
		});
		
		btnStep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				_logic.newGeneration();
			}
		});
		
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnPlay.setEnabled(true);
				btnStep.setEnabled(true);
				btnPause.setEnabled(false);
				
				_logic.continuous = false;
			}
		});
		
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				_game.interrupt();
				
				btnPlay.setEnabled(false);
				btnStep.setEnabled(false);
				btnPause.setEnabled(false);
				btnStop.setEnabled(false);
				
				btnLaunch.setEnabled(true);
				
				resetGrid();
			}
		});
		
		controlPanel.add(btnPlay);
		controlPanel.add(btnStep);
		controlPanel.add(btnPause);
		controlPanel.add(btnStop);
		
		btnLaunch = new JButton("Launch");
		btnLaunch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLaunch.setEnabled(false);
				btnPause.setEnabled(true);
				btnStop.setEnabled(true);
				
				enableGrid(false);
				
				_game = new Thread(_logic);
				_game.start();
			}
		});
		launchPanel.add(btnLaunch);
		
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
	
	private void enableGrid(boolean option) {
		for (JButton[] array : _grid) {
			for (JButton btn : array) {
				btn.setEnabled(option);
			}
		}
	}
	
	private void resetGrid() {
		for (JButton[] array : _grid) {
			for (JButton btn : array) {
				btn.setBackground(null);
				btn.setEnabled(true);
			}
		}
	}
}
