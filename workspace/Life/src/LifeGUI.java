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
	static Thread _continuous;
	static JButton[][] _grid;
	static Color _alive = new Color(30, 200, 30);
	
	JFrame frame;
	JPanel gridPanel, controlPanel;
	JButton btnStart, btnStep, btnPause, btnStop;
	JMenuBar menuBar;
	JMenu menuPresets;
	ButtonGroup presetsBtnGroup;
	JRadioButtonMenuItem radioDefault, radioCheckerboard;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LifeGUI window = new LifeGUI(75, 75);
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
		
		buildMenu();
		
		buildCntrlPanel();
		
		buildGrid();
		
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
	
	private void buildCntrlPanel() {
		controlPanel = new JPanel();
		frame.getContentPane().add(controlPanel, BorderLayout.SOUTH);
		controlPanel.setLayout(new GridLayout(0, 4, 0, 0));
		
		btnStart = new JButton("Start");
		btnStep = new JButton("Step");
		btnPause = new JButton("Pause");
		btnStop = new JButton("Stop");
		
		btnStep.setEnabled(false);
		btnPause.setEnabled(false);
		btnStop.setEnabled(false);
		
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				enableGrid(false);
				btnPause.setEnabled(true);
				btnStop.setEnabled(true);
				if (_continuous.isAlive()) {
					_logic.keepPlaying = true;
				}
				else {
					_continuous.start();
				}
				
				
			}
		});
		
		btnStep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				_logic.newGeneration();
			}
		});
		
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				_logic.keepPlaying = false;
				btnStep.setEnabled(true);
			}
		});
		
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
				_logic.keepPlaying = false;
				
				while(!_logic.keepPlaying)
				{
					_continuous.sleep(500);
				}
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		
		controlPanel.add(btnStart);
		controlPanel.add(btnStep);
		controlPanel.add(btnPause);
		controlPanel.add(btnStop);
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
		for (int y = 0; y < _grid.length; y++)
			for (int x = 0; x < _grid[y].length; x++)
				_grid[y][x].setEnabled(option);
	}
}
